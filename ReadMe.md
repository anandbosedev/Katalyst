# Katalyst Static Site Generator

Katalyst is a Kotlin/JVM library for developing static websites. Currently, Katalyst implements the following concepts:

1. Type-safe, extendable Kotlin DSL of basic HTML elements.
2. Multi-phased HTML tree builder that splits the build pipeline to several phases, so that the generation of a nested
   tree can be postponed to the next phase `T + 1` without blocking the generation of the parent tree on the current
   phase `T`. This is quite useful if the nested tree generation depends on the other branches of the parent tree.
3. CSS compiler utilising the multi-phased HTML builder by analyzing the HTML tree and compiles only the minimal set of
   CSS rules required to include in the page.

[Guide](https://katalyst.pages.dev) [API Reference](https://katalyst.pages.dev/doc)

## Roadmap

| # | Project Roadmap        | Status                                        |
|---|------------------------|-----------------------------------------------|
| 1 | API documentation      | [In Progress](https://katalyst.pages.dev/doc) |
| 2 | Publish Maven Artifact | Available https://katalyst.pages.dev/maven    |

| # | Plugins Roadmap           | Status                                                                                                                                  |
|---|---------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|
| 1 | Responsive Images         | Available: [`responsive-image`](https://github.com/anandbosetech/Katalyst/tree/main/responsive-image) module                                |
| 2 | Kotlin Syntax Highlighter | Available: [`kotlin-syntax-highligher-plugin`](https://github.com/anandbosetech/Katalyst/tree/main/kotlin-syntax-highlighter-plugin) module |
