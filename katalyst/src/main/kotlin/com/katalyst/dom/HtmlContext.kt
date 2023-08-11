package com.katalyst.dom

import com.katalyst.environment.Environment

class HtmlContext(val node: Node, environment: Environment) : BaseContext(environment) {
    fun head(block: HeadContext.() -> Unit) {
        val node = Node(
            tagName = "head",
            parent = node,
        )
        val context = HeadContext(node, environment)
        block(context)
        node.children = context.elements
        elements.add(node)
    }

    fun body(block: BodyContext.() -> Unit) {
        val node = Node(
            tagName = "body",
            parent = node,
        )
        val context = BodyContext(node, environment)
        block(context)
        node.children = context.elements
        elements.add(node)
    }
}