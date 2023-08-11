package com.katalyst.highlighter.kotlin.lexer

import com.katalyst.highlighter.kotlin.tokenizer.*

fun basicKotlinLexer(input: List<Token>): List<Token> {
    val hardKeywords = listOf("as", "break", "class", "continue", "do", "else", "false", "for", "if", "in",
        "interface", "is", "null", "object", "package", "return", "super", "this", "throw", "true",
        "try", "typealias", "typeof", "val", "var", "when", "while")
    val softKeywords = listOf("by", "catch", "constructor", "delegate", "dynamic", "field", "file",
        "finally", "fun", "get", "import", "init", "param", "property", "receiver", "set", "setparam", "value",
        "where")
    val modifierKeywords = listOf("abstract", "actual", "annotation", "companion", "const", "crossinline",
        "data", "enum", "expect", "external", "final", "infix", "inline", "inner", "internal", "lateinit",
        "noinline", "open", "operator", "out", "override", "private", "protected", "public", "reified",
        "sealed", "suspend", "tailrec", "vararg")
    val keywords = buildList {
        addAll(hardKeywords)
        addAll(softKeywords)
        addAll(modifierKeywords)
    }
    return input.map {
        when {
            it.text in keywords -> {
                it.copy(type = TYPE_KOTLIN_KEYWORD)
            }
            it.text.startsWith('@') -> {
                it.copy(type = TYPE_KOTLIN_ANNOTATION)
            }
            else -> {
                it
            }
        }
    }
}

fun semanticKotlinLexer(input: List<Token>): List<Token> {
    val postTokenTypeOverrides = mapOf(
        "fun" to TYPE_KOTLIN_FUNCTION_NAME,
        "class" to TYPE_KOTLIN_CLASS_NAME,
        "typealias" to TYPE_KOTLIN_CLASS_NAME,
        "var" to TYPE_TOKEN,
        "val" to TYPE_TOKEN,
    )
    return input.mapIndexed { index, token ->
        val prevToken = input.getOrNull(index - 1)
        val prevTokenText = prevToken?.text
        if (prevTokenText in postTokenTypeOverrides.keys) {
            token.copy(type = postTokenTypeOverrides[prevTokenText]!!)
        } else {
            token
        }
    }
}