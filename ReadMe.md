# Katalyst Static Site Generator
```
This project is an experimentation of the possibility of Kotlin for static site generation. This is not professional but just a free-time work, and I don't wish to continue it further.
```
Katalyst is a Kotlin/JVM library for developing static websites. Currently, Katalyst implements the following concepts:

1. Type-safe, extendable Kotlin DSL of basic HTML elements.
2. Multi-phased HTML tree builder that splits the build pipeline to several phases, so that the generation of a nested
   tree can be postponed to the next phase `T + 1` without blocking the generation of the parent tree on the current
   phase `T`. This is quite useful if the nested tree generation depends on the other branches of the parent tree.
3. CSS compiler utilising the multi-phased HTML builder by analyzing the HTML tree and compiles only the minimal set of
   CSS rules required to include in the page.

[Guide](https://katalyst.pages.dev) [API Reference](https://katalyst.pages.dev/doc)
