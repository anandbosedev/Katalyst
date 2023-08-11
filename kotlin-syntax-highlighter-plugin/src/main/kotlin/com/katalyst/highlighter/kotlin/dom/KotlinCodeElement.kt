package com.katalyst.highlighter.kotlin.dom

import com.katalyst.dom.BodyContext
import com.katalyst.highlighter.kotlin.tokenizeKotlinCode
import com.katalyst.highlighter.kotlin.tokenizer.*

fun BodyContext.kotlinCode(code: String) {
    val tokens = tokenizeKotlinCode(Tokenizers, code)
    pre(className = "kotlin-syntax-highlighter") {
        code {
            for (i in tokens.indices) {
                val currentToken = tokens.getOrNull(i - 1)
                val nextToken = tokens.getOrNull(i)
                val textRange = ((currentToken?.endIndex ?: -1) + 1) until (nextToken?.startIndex ?: 0)
                val textBlock = code.substring(textRange)
                if (textBlock.isNotEmpty()) {
                    span(className = "kotlin-syntax-highlighter-token", text = textBlock)
                }
                if (nextToken != null) {
                    val className = when (val type = nextToken.type) {
                        TYPE_TOKEN -> "kotlin-syntax-highlighter-token"
                        TYPE_PUNCTUATION -> "kotlin-syntax-highlighter-punctuation"
                        TYPE_STRING_LITERAL -> "kotlin-syntax-highlighter-string-literal"
                        TYPE_KOTLIN_KEYWORD -> "kotlin-syntax-highlighter-keyword"
                        TYPE_KOTLIN_FUNCTION_NAME -> "kotlin-syntax-highlighter-function-name"
                        TYPE_KOTLIN_CLASS_NAME -> "kotlin-syntax-highlighter-class-name"
                        TYPE_KOTLIN_ANNOTATION -> "kotlin-syntax-highlighter-annotation"
                        TYPE_KOTLIN_LINE_COMMENT -> "kotlin-syntax-highlighter-line-comment"
                        TYPE_KOTLIN_BLOCK_COMMENT -> "kotlin-syntax-highlighter-block-comment"
                        else -> error("Unknown token type $type")
                    }
                    span(className = className, text = nextToken.text)
                }
            }
        }
    }
}