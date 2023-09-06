package com.katalyst.site.components

import com.katalyst.generator.InlineStyleGenerator
import com.katalyst.dom.HtmlContext
import com.katalyst.site.SITE_PREFIX
import com.katalyst.site.css.css

fun HtmlContext.includeSiteHead(title: String, description: String, imagePath: String) {
    head {
        meta(charset = "utf-8")
        title(title)
        meta(name = "viewport", content = "width=device-width, initial-scale=1, user-scalable=1")
        meta(
            name = "description",
            content = description
        )

        // Google site verification
        meta(name = "google-site-verification", content = "jmtVjY3zdU-jXicYnnvtgjWl1cJafFfMYymZIAQheqA")

        // Open graph: Facebook
        meta(property = "og:title", content = title)
        meta(
            property = "og:description",
            content = description
        )
        meta(property = "og:image", content = imagePath)
        meta(property = "og:image:alt", content = title)

        // Open graph: Twitter card
        meta(name = "twitter:card", content = "summary_large_image")
        meta(name = "twitter:title", content = title)
        meta(
            name = "twitter:description",
            content = description
        )
        meta(name = "twitter:image:src", content = imagePath)
        meta(name = "twitter:image:alt", content = title)
        meta(name = "twitter:creator", content = "@anandbosetech")
        meta(name = "twitter:site", content = "@anandbosetech")

        deferred(InlineStyleGenerator(css))

        link(rel = "apple-touch-icon", sizes = "57x57", href = "${SITE_PREFIX}/apple-icon-57x57.png")
        link(rel = "apple-touch-icon", sizes = "60x60", href = "${SITE_PREFIX}/apple-icon-60x60.png")
        link(rel = "apple-touch-icon", sizes = "72x72", href = "${SITE_PREFIX}/apple-icon-72x72.png")
        link(rel = "apple-touch-icon", sizes = "76x76", href = "${SITE_PREFIX}/apple-icon-76x76.png")
        link(rel = "apple-touch-icon", sizes = "114x114", href = "${SITE_PREFIX}/apple-icon-114x114.png")
        link(rel = "apple-touch-icon", sizes = "120x120", href = "${SITE_PREFIX}/apple-icon-120x120.png")
        link(rel = "apple-touch-icon", sizes = "144x144", href = "${SITE_PREFIX}/apple-icon-144x144.png")
        link(rel = "apple-touch-icon", sizes = "152x152", href = "${SITE_PREFIX}/apple-icon-152x152.png")
        link(rel = "apple-touch-icon", sizes = "180x180", href = "${SITE_PREFIX}/apple-icon-180x180.png")
        link(rel = "icon", type = "image/png", sizes = "192x192", href = "${SITE_PREFIX}/android-icon-192x192.png")
        link(rel = "icon", type = "image/png", sizes = "32x32", href = "${SITE_PREFIX}/favicon-32x32.png")
        link(rel = "icon", type = "image/png", sizes = "96x96", href = "${SITE_PREFIX}/favicon-96x96.png")
        link(rel = "icon", type = "image/png", sizes = "16x16", href = "${SITE_PREFIX}/favicon-16x16.png")
        link(rel = "manifest", href = "${SITE_PREFIX}/manifest.json")

        meta(name = "robots", content = "index, follow")

        meta(name = "msapplication-TileColor", content = "#ffffff")
        meta(name = "msapplication-TileImage", content = "${SITE_PREFIX}/ms-icon-144x144.png")
        meta(name = "theme-color", content = "#ffffff")

        script(
            """
                function switchToDarkMode() {
                    if (document.documentElement.classList.contains("light")) {
                        document.documentElement.classList.remove("light");
                    }
                    document.documentElement.classList.add("dark");
                    window.localStorage.setItem("theme", "dark");
                }

                function switchToLightMode() { 
                    if (document.documentElement.classList.contains("dark")) {
                        document.documentElement.classList.remove("dark");
                    }
                    document.documentElement.classList.add("light");
                    window.localStorage.setItem("theme", "light");
                }

                function checkTheme() {
                    let theme = window.localStorage.getItem("theme");
                    switch (theme) {
                        case undefined: {
                            break;
                        }
                        case "dark": {
                            switchToDarkMode();
                            break;
                        }
                        case "light": {
                            switchToLightMode();
                            break;
                        }
                    }
                }

                checkTheme();
            """.trimIndent()
        )
    }
}