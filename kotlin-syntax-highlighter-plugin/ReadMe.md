# Kotlin Syntax Highlighter Plugin for Katalyst

Usage:

```kotlin
html {
    head {
        deferred(InlineStyleGenerator(KotlinSyntaxHighlighterCss))
    }
    body {
        h1("Hello!")
        p("This is a Kotlin code snippet, highlighted with kotlin-syntax-highlighter-plugin")
        kotlinCode("""
            fun main() {
                println("Hello, world!")
            }
        """.trimIndent())
    }
}
```