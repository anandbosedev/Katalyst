package com.katalyst.generator

import com.katalyst.css.CssDefinition
import com.katalyst.css.Preload
import com.katalyst.dom.Element
import com.katalyst.dom.Node
import com.katalyst.environment.Environment
import com.katalyst.dom.Text

class InlineStyleGenerator(val cssDefinitionList: List<CssDefinition>) : DeferredGenerator {
    override fun generate(root: Node, environment: Environment): List<Element> {
        val matchingDefinitions = extractMatchingStylesheets(root)
        val definitionsWithDependencies = resolveDependencies(matchingDefinitions)
        val elements = definitionsWithDependencies
            .filter { !it.preloadList.isNullOrEmpty() }
            .flatMap { it.preloadList!! }
            .toSet()
            .map {
                Node(
                    tagName = "link",
                    attributes = mapOf(
                        "rel" to "preload",
                        "href" to it.href,
                        "as" to it.`as`,
                        "type" to it.type,
                        "crossorigin" to null,
                    ),
                )
            }.toMutableList()
        val generatedCss = definitionsWithDependencies.joinToString(separator = " ") { it.render() }
        val node = Node("style")
        node.children = mutableListOf(
            Text(text = generatedCss, parent = node)
        )
        elements.add(node)
        return elements
    }

    private fun extractMatchingStylesheets(root: Node): MutableSet<CssDefinition> {
        val cssSet = mutableSetOf<CssDefinition>()
        val elementListStack = mutableListOf<MutableList<Element>>()
        val indexStack = mutableListOf<Int>()
        var elementList = mutableListOf<Element>(root)
        var index = 0
        while (true) {
            when (val element = elementList.getOrNull(index)) {
                is Node -> {
                    cssSet.addAll(
                        cssDefinitionList.filter { cssDefinition ->
                            cssDefinition.matchers?.any { matcher ->
                                matcher.matches(element)
                            } == true
                        }
                    )
                    val children = element.children
                    if (!children.isNullOrEmpty()) {
                        elementListStack.add(elementList)
                        indexStack.add(index)
                        elementList = children
                        index = 0
                        continue
                    }
                }
                null -> {
                    try {
                        elementList = elementListStack.removeLast()
                        index = indexStack.removeLast()
                    } catch (e: NoSuchElementException) {
                        break
                    }
                }
                else -> {}
            }
            index++
        }
        return cssSet
    }

    private fun resolveDependencies(definitions: Collection<CssDefinition>): Set<CssDefinition> {
        val list = mutableListOf<CssDefinition>()
        list.addAll(definitions)
        var index = 0
        while (index < list.size) {
            val definition = list[index]
            val dependencyTags = definition.depends
            if (!dependencyTags.isNullOrEmpty()) {
                dependencyTags.forEach { requiredDependencyTag ->
                    val dependencies = cssDefinitionList.filter { externalDefinition ->
                        externalDefinition.dependencyTag == requiredDependencyTag
                    }
                    list.addAll(dependencies - list.toSet())
                }
            }
            index++
        }
        return list.toSet()
    }
}