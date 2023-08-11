package com.katalyst.site.templates

import com.katalyst.dom.BodyContext
import com.katalyst.dom.DocumentContext
import com.katalyst.site.SITE_PREFIX
import com.katalyst.site.components.includeSiteFooter
import com.katalyst.site.components.includeSiteHead
import com.katalyst.site.components.includeSiteHeader

inline fun DocumentContext.pageTemplate(
    crossinline contentBlock: BodyContext.() -> Unit
) {
    html {
        includeSiteHead(
            title = "Katalyst Static Site Generator",
            description = "Katalyst is a Kotlin/JVM library for developing static websites.",
            imagePath = "$SITE_PREFIX/twitter-card.png"
        )
        body {
            includeSiteHeader()
            main {
                contentBlock()
            }
            includeSiteFooter()
        }
    }
}