package com.katalyst.site.components

import com.katalyst.dom.BodyContext
import com.katalyst.dom.Node

fun BodyContext.includeSiteNavigation() {
    nav(className = "site-nav") {
        a(className = "nav-menu-item", href = "https://github.com/droidcrafts/Katalyst", text = "GitHub")
        text(" ")
        a(className = "nav-menu-item", href = "https://katalyst.pages.dev/doc", text = "API Docs")
    }
}

fun BodyContext.includeSiteHeader() {
    header {
        h1 {
            katalystLogo(
                customAttributes = mapOf(
                    "style" to "width: 2em; height: 0.8em; margin-right: 0.5em;",
                ),
            )
            text("Katalyst")
        }
        includeSiteNavigation()
    }
}

fun BodyContext.katalystLogo(
    id: String? = null,
    className: String? = null,
    customAttributes: Map<String, String>? = null,
) {
    val svgRoot = Node(
        tagName = "svg",
        attributes = buildMap {
            put("xmlns", "http://www.w3.org/2000/svg")
            put("width", "604.724")
            put("height", "241.89")
            put("viewBox", "0 0 160 64")
            if (id != null) {
                put("id", id)
            }
            if (className != null) {
                put("class", className)
            }
            if (!customAttributes.isNullOrEmpty()) {
                putAll(customAttributes)
            }
        },
        parent = node
    )
    val path1 = Node(
        tagName = "path",
        attributes = mapOf(
            "d" to "M64 64H0V0h64L32 32z",
            "fill" to "#fb772b",
        ),
        parent = svgRoot,
    )
    val path2 = Node(
        tagName = "path",
        attributes = mapOf(
            "d" to "M96 0h64v64H96l32-32z",
            "fill" to "#6a74cb",
        ),
        parent = svgRoot,
    )
    svgRoot.children = mutableListOf(path1, path2)
    elements.add(svgRoot)
}