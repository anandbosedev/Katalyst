package com.katalyst.environment

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import java.io.File
import kotlin.io.path.relativeTo

class Environment(
    val baseDir: File,
    val outputDir: File,
) {
    init {
        if (!outputDir.exists()) {
            outputDir.mkdirs()
        }
    }
    fun getAbsoluteBasePath(path: String) = File(baseDir, path)

    fun getAbsoluteOutputPath(path: String) = File(outputDir, path)
}

fun clean(environment: Environment) {
    if (environment.outputDir.exists()) {
        environment.outputDir.deleteRecursively()
    }
    environment.outputDir.mkdir()
    println("clean: ${environment.outputDir.absolutePath}")
}

suspend fun copyStaticAssets(environment: Environment, isVerbose: Boolean = false) = withContext(Dispatchers.IO) {
    val baseDirPath = environment.baseDir.toPath()
    val outputDirPath = environment.outputDir.toPath()
    environment.baseDir.walk().map {
        async {
            val path = it.toPath()
            val relativePathInBaseDir = path.relativeTo(baseDirPath)
            val absolutePathInOutputDir = outputDirPath.resolve(relativePathInBaseDir)
            if (isVerbose) {
                println("copyStaticAssets: ${if (it.isDirectory) "DIR " else "FILE"} $path -> $absolutePathInOutputDir")
            }
            val target = absolutePathInOutputDir.toFile()
            if (it.isDirectory) {
                target.mkdir()
            } else {
                it.copyTo(target)
            }
        }
    }.toList().awaitAll()
}