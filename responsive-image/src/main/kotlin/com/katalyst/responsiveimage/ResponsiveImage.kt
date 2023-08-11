package com.katalyst.responsiveimage

import com.katalyst.dom.BodyContext
import kotlinx.coroutines.*
import java.io.File
import java.text.DecimalFormat
import java.util.*

enum class ResponsiveImageFormat(val mimeType: String) {
    PNG("image/png"),
    WEBP("image/webp"),
    AVIF("image/avif"),
}

private data class SrcSet<T>(
    val format: ResponsiveImageFormat,
    val images: List<ScaledImage<T>>,
)

private data class ScaledImage<T>(
    val imageFile: T,
    val scaleFactor: Float,
)
fun BodyContext.responsiveImage(
    id: String? = null,
    className: String? = null,
    src: String,
    width: Int,
    height: Int,
    scaleModes: List<Float> = listOf(1f, 1.5f, 2f, 2.5f, 3f),
    imageFormats: List<ResponsiveImageFormat> = listOf(
        ResponsiveImageFormat.AVIF,
        ResponsiveImageFormat.WEBP,
        ResponsiveImageFormat.PNG,
    ),
    alt: String? = null,
    customAttributes: Map<String, String?>? = null,
) {
    runBlocking(Dispatchers.Default) {
        val decimalFormat = DecimalFormat("0.#")
        val imageMagickPath = findImageMagickBinaryPath()
        val inputFile = File(environment.baseDir, src)
        val outputDir = File(environment.outputDir, src).parentFile
        picture {
            if (imageMagickPath != null) {
                val deferredSrcSets = mutableListOf<SrcSet<Deferred<File>>>()
                for (imageFormat in imageFormats) {
                    val deferredScaledImages = mutableListOf<ScaledImage<Deferred<File>>>()
                    for (scale in scaleModes) {
                        deferredScaledImages.add(
                            ScaledImage(
                                imageFile = async {
                                    resizeImage(inputFile, outputDir, width, height, scale, imageFormat)
                                },
                                scaleFactor = scale,
                            )
                        )
                    }
                    deferredSrcSets.add(SrcSet(imageFormat, deferredScaledImages))
                }
                val srcSets = deferredSrcSets.map { deferredSrcSet ->
                    SrcSet(
                        format = deferredSrcSet.format,
                        images = deferredSrcSet.images.map { deferredScaledImage ->
                            ScaledImage(
                                imageFile = deferredScaledImage.imageFile.await(),
                                scaleFactor = deferredScaledImage.scaleFactor
                            )
                        }
                    )
                }
                srcSets.forEach { srcSet ->
                    val type = srcSet.format.mimeType
                    val srcSetAttr = srcSet.images.joinToString { img ->
                        String.format(
                            Locale.US, "/%s %sx",
                            img.imageFile.relativeTo(environment.outputDir),
                            decimalFormat.format(img.scaleFactor),
                        )
                    }
                    source(type = type, srcSet = srcSetAttr)
                }
            } else {
                println("responsiveImage: ImageMagick not found.")
            }
            img(
                id = id,
                className = className,
                src = src,
                alt = alt,
                customAttributes = buildMap {
                    put("width", width.toString())
                    put("height", height.toString())
                    if (customAttributes != null) {
                        putAll(customAttributes)
                    }
                }
            )
        }
    }
}

suspend fun resizeImage(
    inputFile: File,
    outputDir: File,
    width: Int,
    height: Int,
    scale: Float,
    format: ResponsiveImageFormat,
) = withContext(Dispatchers.IO) {
    val sw = (width * scale).toInt()
    val sh = (height * scale).toInt()
    val inputFileName = inputFile.nameWithoutExtension
    val outputFileExtension = when (format) {
        ResponsiveImageFormat.PNG -> "png"
        ResponsiveImageFormat.AVIF -> "avif"
        ResponsiveImageFormat.WEBP -> "webp"
    }
    val decimalFormat = DecimalFormat("0.#")
    val targetFileName = String.format(
        Locale.US,
        "%s-%dx%d-%sx.%s",
        inputFileName, width, height, decimalFormat.format(scale), outputFileExtension
    )
    val targetFile = File(outputDir, targetFileName)
    if (targetFile.exists()) {
        targetFile.delete()
    }
    val processBuilder = ProcessBuilder(
        "/bin/sh",
        "-c",
        "magick convert '${inputFile.absolutePath}' -resize ${sw}x$sh ${targetFile.absolutePath}",
    )
    val process = processBuilder.start()
    try {
        process.inputStream.bufferedReader().lines().forEach { line ->
            println("IN: $line")
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    try {
        process.errorStream.bufferedReader().lines().forEach { line ->
            println("ER: $line")
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    val exitCode = process.waitFor()
    println("Exit code: $exitCode")
    return@withContext targetFile
}

suspend fun findImageMagickBinaryPath(): String? = withContext(Dispatchers.IO) {
    val processBuilder = ProcessBuilder(
        "/bin/sh",
        "-c",
        "which magick"
    )
    val process = processBuilder.start()
    var imageMagickBinaryPath: String? = null
    try {
        process.inputStream.bufferedReader().lines().forEach { line ->
            imageMagickBinaryPath = line
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    try {
        process.errorStream.bufferedReader().lines().forEach { line ->
            println("findImageMagickBinaryPath: Error: $line")
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    process.waitFor()
    return@withContext imageMagickBinaryPath
}