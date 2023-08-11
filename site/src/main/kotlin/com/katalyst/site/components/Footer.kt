package com.katalyst.site.components

import com.katalyst.dom.BodyContext

fun BodyContext.includeSiteFooter() {
    footer {
        span {
            text("Made with ❤ by ")
            a(
                href = "https://mastodon.social/@anandbose",
                text = "Anand Bose",
                customAttributes = mapOf("rel" to "me"),
            )
            text(". Content on this site is licensed under ")
            a(
                href = "https://creativecommons.org/licenses/by-sa/4.0/",
                text = "CC BY-SA 4.0"
            )
        }
    }
}