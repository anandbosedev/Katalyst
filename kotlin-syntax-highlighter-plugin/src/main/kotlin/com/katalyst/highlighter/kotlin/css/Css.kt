package com.katalyst.highlighter.kotlin.css

import com.katalyst.css.ClassName
import com.katalyst.css.CssDefinition

val colorText = "#BCBEC4"
val colorBackground = "#1E1F22"
val colorFunctionName = "#56A8F5"
val colorAnnotation = "#B3AE60"
val colorStringLiteral = "#6AAB73"
val colorComment = "#8A8A8A"
val colorKeyword = "#CF8E6D"

val KotlinSyntaxHighlighterCss = listOf(
    CssDefinition(
        matchers = listOf(
            ClassName("kotlin-syntax-highlighter")
        ),
        declarations = mapOf(
            "background" to colorBackground,
            "padding" to "0.5em",
        ),
    ),
    CssDefinition(
        matchers = listOf(
            ClassName("kotlin-syntax-highlighter-token"),
        ),
        declarations = mapOf("color" to colorText),
    ),
    CssDefinition(
        matchers = listOf(
            ClassName("kotlin-syntax-highlighter-punctuation"),
        ),
        declarations = mapOf("color" to colorText),
    ),
    CssDefinition(
        matchers = listOf(
            ClassName("kotlin-syntax-highlighter-string-literal"),
        ),
        declarations = mapOf("color" to colorStringLiteral),
    ),
    CssDefinition(
        matchers = listOf(
            ClassName("kotlin-syntax-highlighter-keyword"),
        ),
        declarations = mapOf("color" to colorKeyword),
    ),
    CssDefinition(
        matchers = listOf(
            ClassName("kotlin-syntax-highlighter-function-name"),
        ),
        declarations = mapOf("color" to colorFunctionName),
    ),
    CssDefinition(
        matchers = listOf(
            ClassName("kotlin-syntax-highlighter-class-name"),
        ),
        declarations = mapOf("color" to colorText),
    ),
    CssDefinition(
        matchers = listOf(
            ClassName("kotlin-syntax-highlighter-annotation"),
        ),
        declarations = mapOf("color" to colorAnnotation),
    ),
    CssDefinition(
        matchers = listOf(
            ClassName("kotlin-syntax-highlighter-line-comment"),
        ),
        declarations = mapOf(
            "color" to colorComment,
            "font-style" to "italic",
        ),
    ),
    CssDefinition(
        matchers = listOf(
            ClassName("kotlin-syntax-highlighter-block-comment"),
        ),
        declarations = mapOf(
            "color" to colorComment,
            "font-style" to "italic",
        ),
    ),
)