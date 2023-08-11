package com.katalyst.dom

import com.katalyst.environment.Environment
import com.katalyst.generator.DeferredGenerator
import kotlin.NoSuchElementException

sealed interface Element {
    fun render(): String
}

data class Node(
    var tagName: String,
    var attributes: Map<String, String?>? = null,
    var children: MutableList<Element>? = null,
    var parent: Node? = null,
) : Element {

    val id: String?
        get() = attributes?.get("id")

    val classNames: List<String>?
        get() = attributes?.get("class")?.split(" ")

    override fun render(): String {
        return buildString {
            append("<")
            append(tagName)
            val attributes = attributes
            val children = children
            if (!attributes.isNullOrEmpty()) {
                attributes.forEach { (key, value) ->
                    append(" ")
                    append(key)
                    if (value != null) {
                        append("=")
                        append("\"$value\"")
                    }
                }
            }
            if (!children.isNullOrEmpty()) {
                append(">")
                children.forEach { child ->
                    append(child.render())
                }
                append("</$tagName>")
            } else {
                append("/>")
            }
        }
    }
}

data class Text(
    var text: String,
    var parent: Node? = null,
) : Element {
    override fun render(): String {
        return text
    }
}

class Deferred(val generator: DeferredGenerator, val priority: Int = 0) : Element {
    override fun render(): String = ""

}

data class DeferredElementResolveResult(val traversalCount: Int, val deferredElementCount: Int)

fun resolveDeferredNodes(root: Node, environment: Environment): DeferredElementResolveResult {
    var traversalCount = 0
    var deferredElementCount = 0
    outer@ while (true) {
        traversalCount++
        val elementListStack = mutableListOf<MutableList<Element>>()
        val indexStack = mutableListOf<Int>()
        var elementList = mutableListOf<Element>(root)
        var index = 0
        var deferredElement: Deferred? = null
        var deferredElementIndex: Int = -1
        var deferredElementParentList: MutableList<Element>? = null
        inner@ while (true) {
            when (val element = elementList.getOrNull(index)) {
                is Deferred -> {
                    if (element.priority > (deferredElement?.priority ?: Int.MIN_VALUE)) {
                        deferredElement = element
                        deferredElementIndex = index
                        deferredElementParentList = elementList
                    }
                }

                is Node -> {
                    val children = element.children
                    if (!children.isNullOrEmpty()) {
                        elementListStack.add(elementList)
                        indexStack.add(index)
                        elementList = children
                        index = 0
                        continue@inner
                    }
                }

                is Text -> {}
                null -> {
                    try {
                        elementList = elementListStack.removeLast()
                        index = indexStack.removeLast()
                    } catch (e: NoSuchElementException) {
                        break@inner
                    }
                }
            }
            index++
        }
        if (
            deferredElement != null &&
            deferredElementParentList != null &&
            deferredElementIndex >= 0
        ) {
            val elements = deferredElement.generator.generate(root, environment)
            deferredElementParentList.removeAt(deferredElementIndex)
            deferredElementParentList.addAll(deferredElementIndex, elements)
            deferredElementCount += elements.size
        } else {
            break@outer
        }
    }
    return DeferredElementResolveResult(traversalCount, deferredElementCount)
}