package com.katalyst.dom

import com.katalyst.generator.DeferredGenerator
import com.katalyst.environment.Environment

class HeadContext(val node: Node, environment: Environment) : BaseContext(environment) {
    fun title(title: String) {
        val node = Node(
            tagName = "title",
            parent = node,
        )
        node.children = mutableListOf(
            Text(
                text = title,
                parent = node,
            ),
        )
        elements.add(node)
    }

    fun meta(
        charset: String? = null,
        name: String? = null,
        property: String? = null,
        content: String? = null,
    ) {
        val node = Node(
            tagName = "meta",
            parent = node,
            attributes = buildMap {
                if (charset != null) {
                    put("charset", charset)
                }
                if (name != null) {
                    put("name", name)
                }
                if (property != null) {
                    put("property", property)
                }
                if (content != null) {
                    put("content", content)
                }
            }
        )
        elements.add(node)
    }

    fun link(
        rel: String? = null,
        sizes: String? = null,
        type: String? = null,
        href: String? = null,
    ) {
        val node = Node(
            tagName = "link",
            parent = node,
            attributes = buildMap {
                if (rel != null) {
                    put("rel", rel)
                }
                if (sizes != null) {
                    put("sizes", sizes)
                }
                if (type != null) {
                    put("type", type)
                }
                if (href != null) {
                    put("href", href)
                }
            }
        )
        elements.add(node)
    }

    fun script(
        src: String? = null,
        async: Boolean = false,
        defer: Boolean = false,
    ) {
        val node = Node(
            tagName = "script",
            parent = node,
            attributes = buildMap {
                if (src != null) {
                    put("src", src)
                }
                if (async) {
                    put("async", null)
                }
                if (defer) {
                    put("defer", null)
                }
            },
            children = mutableListOf(
                Text(text = "")
            ),
        )
        elements.add(node)
    }

    fun script(javascript: String) {
        val node = Node(
            tagName = "script",
            parent = node,
            children = mutableListOf(
                Text(text = javascript)
            ),
        )
        elements.add(node)
    }

    fun deferred(generator: DeferredGenerator, priority: Int = 0) {
        elements.add(Deferred(generator, priority))
    }
}