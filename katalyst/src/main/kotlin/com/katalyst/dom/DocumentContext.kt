package com.katalyst.dom

import com.katalyst.environment.Environment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DocumentContext(val environment: Environment) {
    var rootNode: Node? = null
        private set
    fun html(
        lang: String = "en-US",
        customAttributes: Map<String, String?>? = null,
        block: HtmlContext.() -> Unit,
    ) {
        val node = Node(
            tagName = "html",
            attributes = buildMap {
                put("lang", lang)
                if (customAttributes != null) {
                    putAll(customAttributes)
                }
            },
        )
        val context = HtmlContext(node, environment)
        block(context)
        node.children = context.elements
        rootNode = node
    }

    fun getHtmlRepresentation(): String {
        val rootNode = checkNotNull(rootNode) {
            "You should build your DOM tree with html() method"
        }
        return "<!DOCTYPE html>\n${rootNode.render()}"
    }

    suspend fun recursivelyResolveDeferredNodes() = withContext(Dispatchers.Default) {
        val result = resolveDeferredNodes(rootNode!!, environment)
        println("recursivelyResolveDeferredNodes: traversalCount = ${result.traversalCount} deferredElementCount = ${result.deferredElementCount}")
    }

    suspend fun writeToFile(relativePath: String, isOverwriteAllowed: Boolean = true) = withContext(Dispatchers.IO) {
        val outputFile = environment.getAbsoluteOutputPath(relativePath)
        if (outputFile.isDirectory) {
            error("The path ${outputFile.absolutePath} is a dir.")
        }
        if (!isOverwriteAllowed && outputFile.exists()) {
            error("The file ${outputFile.absolutePath} exists. Set isOverwriteAllowed = true to allow overwriting file contents.")
        }
        val output = getHtmlRepresentation()
        if (outputFile.exists()) {
            outputFile.delete()
        }
        outputFile.createNewFile()
        outputFile.outputStream().use {
            it.write(output.toByteArray(Charsets.UTF_8))
        }
    }
}

inline fun document(
    environment: Environment,
    block: DocumentContext.() -> Unit,
): DocumentContext {
    val context = DocumentContext(environment)
    block(context)
    return context
}