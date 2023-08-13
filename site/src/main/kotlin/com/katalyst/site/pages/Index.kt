package com.katalyst.site.pages

import com.katalyst.dom.document
import com.katalyst.environment.Environment
import com.katalyst.extension.formattedTime
import com.katalyst.highlighter.kotlin.dom.kotlinCode
import com.katalyst.site.templates.pageTemplate
import java.io.File
import java.time.Instant
import java.time.ZoneId

suspend fun buildIndexPage(environment: Environment) {
    val indexPage = document(environment) {
        pageTemplate {
            h2("Katalyst Static Site Generator")
            span(className = "article-date") {
                text("Last updated on ")
                formattedTime(
                    epochMillis = Instant.now().toEpochMilli(),
                    timeZoneId = ZoneId.of("GMT+05:30"),
                )
            }
            p("Katalyst is a Kotlin/JVM library for developing static websites. You can develop HTML pages with " +
                    "the DSL provided by the library like this:")

            kotlinCode("""
                html {
                    head {
                        title("Hello, Katalyst!")
                    }
                    body {
                        h1("Hello, world!")
                        p("This is an example of a static site built with Katalyst.")
                    }
                }
            """.trimIndent())
            p("Currently, Katalyst implements the following concepts:")
            ol {
                li("Type-safe, extendable Kotlin DSL of basic HTML elements.")
                li {
                    text("Multi-phased HTML tree builder that splits the build pipeline to several phases, ")
                    text("so that the generation of a nested tree can be postponed to the next phase ")
                    code("T + 1", className = "highlight")
                    text(" without blocking the generation of the parent tree on the current phase ")
                    code("T", className = "highlight")
                    text(". This is quite useful if the ")
                    text("nested tree generation depends on the other branches of the parent tree.")
                }
                li(
                    "CSS compiler utilising the multi-phased HTML builder " +
                            "by analyzing the HTML tree and compiles only the " +
                            "minimal set of CSS rules required to include in the page."
                )
            }
            h2("Type-safe, extendable Kotlin DSL")
            p {
                text("You can develop HTML pages with the idiomatic Kotlin code like this:")
            }
            kotlinCode(
                """
                    suspend fun main() {
                        /* Get the current working directory
                         * The :run gradle command will set the working directory to
                         * the module directory by default.
                         */
                        val workingDirectory = System.getProperty("user.dir")
                        val environment = Environment(
                            baseDir = File(workingDirectory,"static"),
                            outputDir = File(workingDirectory,"dist"),
                        )
                        clean(environment)
                        // Copy all static assets from ./static directory to ./dist directory
                        copyStaticAssets(environment)
                        val indexPage = document(environment) {
                            html {
                                head {
                                    title("Hi from Katalyst!")
                                }
                                body {
                                    h1("Hello!")
                                    p("This HTML page is built with Katalyst in Kotlin!")
                                }
                            }
                        }
                        // Render to index.html in dist directory
                        indexPage.writeToFile("/index.html")
                    }
                """.trimIndent()
            )
            p {
                text("Katalyst internally translates the DSL function calls to tree structure of ")
                code("Element", className = "highlight")
                text("s. The classes that implements the ")
                code("Element", className = "highlight")
                text(" interface are:")
                ul {
                    li {
                        code("Node", className = "highlight")
                        text(" - defines an HTML element with tag, attributes and nested nodes.")
                    }
                    li {
                        code("Text", className = "highlight")
                        text(" - represents a plain text body inside an element.")
                    }
                    li {
                        code("Deferred", className = "highlight")
                        text(" - represents an empty dummy node which will be replaced by the element returned by the generator, during the next phase of tree building.")
                    }
                }
            }
            p {
                text("Kotlin provides us the ability to extend a class without having to inherit from the class through ")
                a(href = "https://kotlinlang.org/docs/extensions.html", text = "extensions")
                text(". You can extend the DSL to define your own templates, so you can efficiently reuse them in your " +
                        "projects, and also you can share them as Maven artifacts. Here is a short example:")
            }
            kotlinCode("""
                fun BodyContext.myFancyTextBox(text: String) {
                    div(className = "my-fancy-box") {
                        span(text)
                    }
                }
            """.trimIndent())
            p {
                text("For a real-life use case, you can refer to the implementation of ")
                code(className = "highlight") {
                    a(
                        href = "https://github.com/droidcrafts/Katalyst/tree/main/responsive-image",
                        text = "responsive-image",
                        customAttributes = mapOf("target" to "_blank"),
                    )
                }
                text(" and ")
                code(className = "highlight") {
                    a(
                        href = "https://github.com/droidcrafts/Katalyst/tree/main/kotlin-syntax-highlighter-plugin",
                        text = "kotlin-syntax-highlighter-plugin",
                        customAttributes = mapOf("target" to "_blank"),
                    )
                }
                text(" plugins.")
                text("These artifacts are available along with Katalyst in the project's ")
                a(href = "#katalyst-maven-repo", text = "Maven repository.")
            }
            h2("Phased HTML element tree generation")
            p {
                text("With Katalyst, you can split the web page generation to multiple phases, such that the partial " +
                        "tree generated during the current phase can be analyzed between the phases. This is helpful " +
                        "if the elements of the tree depends on other elements, or something can be built conditionally. " +
                        "If a branch of the tree cannot be determined on this phase, place a ")
                code(text = "Deferred", className = "highlight")
                text(" element in that position, and continue building the other parts of the tree. You should provide a ")
                code(text = "DeferredGenerator", className = "highlight")
                text(" so Katalyst will provide access to the current state of the tree to the generator, so that it " +
                        "can generate the elements according to the current state of the tree. ")
                text("The deferred elements will be prioritised, built and replace the deferred node with the elements " +
                        " returned by the generator at the same position of the deferred node. The ")
                code("recursivelyResolveDeferredNodes", className = "highlight")
                text(" method of the Katalyst framework takes care of the prioritisation, building and replacement of " +
                        "the deferred nodes.")
            }

            p {
                text("Here is an example of deferred generator, which iterates through the tree and prints them " +
                        "in the same page:")
            }
            val wd = System.getProperty("user.dir")
            val file = File(wd, "/src/main/kotlin/com/katalyst/site/pages/Example.kt")
            val codeLines = file.inputStream().use { stream ->
                stream.bufferedReader(Charsets.UTF_8)
                    .readLines()
            }
            kotlinCode(codeLines.subList(6, 53).joinToString(separator = "\n"))
            p {
                text("In the page, here we add a ")
                code("deferred", className = "highlight")
                text(" element with the ")
                code("HtmlTreeStructureGenerator", className = "highlight")
                text(".")
            }
            kotlinCode(codeLines.subList(54, 73).joinToString(separator = "\n"))
            p {
                text("You can see the generated page here:")
            }
            iframe(
                title = "Page rendered with deferred generators",
                src = "./deferred-generator-example.html",
                customAttributes = buildMap {
                    put("width", "100%")
                    put("height", "300")
                    put("style", "background: #ffffff;")
                }
            )
            a(
                href = "./deferred-generator-example.html",
                text = "Open in new tab",
                customAttributes = mapOf("target" to "_blank"),
            )
            blockquote {
                text("Fun fact: The code of ")
                code("HtmlTreeStructureGenerator", className = "highlight")
                text(" shown here is copied from the actual source code ")
                a(
                    href = "https://github.com/droidcrafts/Katalyst/blob/main/site/src/main/kotlin/com/katalyst/site/pages/Example.kt",
                    text = "(Example.kt)"
                )
                text(" and embedded while building this page! ")
                text("Also, the page embedded here is the actual page rendered by Katalyst while building this website!")
            }
            h2("Meet InlineStyleGenerator")
            p {
                code("InlineStyleGenerator", className = "highlight")
                text(" is a built-in implementation of ")
                code("DeferredGenerator", className = "highlight")
                text(". It traverse through the HTML nodes and search for matching styles in the provided list ")
                text("of CSS rules. You need to place a ")
                code("deferred(generator = InlineStyleGenerator(cssRuleList))", className = "highlight")
                text(" inside your head element. Before rendering the web page, you should call ")
                code("recursivelyResolveDeferredNodes()", className = "highlight")
                text(" to include the optimized list of CSS rules in the ")
                code("style", className = "highlight")
                text(" element.")
            }
            p {
                text("This is how you can define CSS rules for ")
                code("InlineStyleGenerator", className = "highlight")
                text(".")
            }
            kotlinCode(
                """
                val myCssRules = listOf(
                    CssDefinition(
                        matchers = listOf(
                            TagName("code"),
                            TagName("pre")
                        ),
                        declarations = mapOf(
                            "font-family" to "'JetBrains Mono', monospace",
                            "font-size" to "14px",
                            "font-variant-ligatures" to "normal",
                            "line-height" to "1.7em",
                        ),
                        depends = listOf("JetBrains Mono"),
                    ),
                    CssDefinition(
                        query = "@font-face",
                        declarations = mapOf(
                            "font-family" to "'JetBrains Mono'",
                            "font-style" to "italic",
                            "font-weight" to "400",
                            "font-display" to "swap",
                            "src" to "url(/styles/fonts/jetbrains-mono/JetBrainsMono-Italic.woff2) format('truetype')",
                        ),
                        dependencyTag = "JetBrains Mono",
                    ),
                    CssDefinition(
                        query = "@font-face",
                        declarations = mapOf(
                            "font-family" to "'JetBrains Mono'",
                            "font-style" to "normal",
                            "font-weight" to "400",
                            "font-display" to "swap",
                            "src" to "url(/styles/fonts/jetbrains-mono/JetBrainsMono-Regular.woff2) format('truetype')",
                        ),
                        dependencyTag = "JetBrains Mono",
                    ),
                )
            """.trimIndent()
            )
            p {
                text("The ")
                code("InlineStyleGenerator", className = "highlight")
                text(" tries to match a ")
                code("Node", className = "highlight")
                text(" to ")
                code("CssDefinition", className = "highlight")
                text(" by matching their ")
                code("tag name", className = "highlight")
                text(", ")
                code("class names", className = "highlight")
                text(", or by ")
                code("id", className = "highlight")
                text(" provided in the ")
                code("matchers", className = "highlight")
                text(" list. If it successfully matches with the provided criteria in the ")
                code("matchers", className = "highlight")
                text(" list, the CSS rule will be compiled and included in the generated ")
                code("style", className = "highlight")
                text(" element.")
            }
            h2(id = "katalyst-maven-repo", text = "Get started with Katalyst")
            p {
                text("You can start your static site right now with the pre-release builds of Katalyst in GitHub ")
                text("Packages Maven repository or the public Maven repository.")
            }
            h3("Set up Katalyst Public Maven Repository")
            p {
                text("The access to the public Maven repository is fairly easier and does not require authentication. ")
                text("It is hosted along with the GitHub hosted website of Katalyst. ")
                kotlinCode("""
                    repositories {
                        maven {
                            url = uri("https://katalyst.pages.dev/maven")
                        }
                    }
                    dependencies {
                        implementation("com.katalyst:katalyst:1.0.0-SNAPSHOT")
                        implementation("com.katalyst:kotlin-syntax-highlighter-plugin:1.0.0-SNAPSHOT")
                        implementation("com.katalyst:responsive-image:1.0.0-SNAPSHOT")
                    }
                """.trimIndent())
            }
            blockquote {
                text("Feel free to checkout the project source code in ")
                a(href = "https://github.com/droidcrafts/Katalyst", text = "GitHub")
                text(". If you have any comments, ideas, suggestions or anything, ")
                a(href = "mailto:anandbose16@gmail.com", text = "just let me know!")
            }
        }
    }
    indexPage.recursivelyResolveDeferredNodes()
    indexPage.writeToFile("/index.html")
}