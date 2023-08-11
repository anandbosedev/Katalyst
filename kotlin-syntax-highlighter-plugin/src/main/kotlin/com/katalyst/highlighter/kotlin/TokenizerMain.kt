package com.katalyst.highlighter.kotlin

import com.katalyst.highlighter.kotlin.lexer.basicKotlinLexer
import com.katalyst.highlighter.kotlin.lexer.semanticKotlinLexer
import com.katalyst.highlighter.kotlin.tokenizer.*

fun main() {
    val kotlinCode = """import java.util.*
        import java.util.List
        
        fun greet() {
            val value = "Hello, world" // This is a comment
            println(value.repeat(size * 3))
        }
        /*
        * This is a block comment
        * This spans multiple lines
        */
        
        @JvmName("Person")
        data class Person(val name: String, val age: Int)
        value class Type(val type: Int)
    """.trimIndent()
    val tokens = tokenizeKotlinCode(Tokenizers, kotlinCode)
    tokens.forEach { token ->
        println(token.toString())
    }
    println("== End Token List ==")
}

fun tokenizeKotlinCode(tokenizers: List<Tokenizer>, kotlinCode: String): List<Token> {
    val receivedTokens = mutableListOf<Token>()
    val tokenCollector = TokenCollector {
        receivedTokens.add(it)
    }
    tokenizers.forEach { it.registerTokenReceiver(tokenCollector) }
    kotlinCode.forEachIndexed { index, char ->
        val charEvents = mutableSetOf(
            CharEvent(
                index,
                char
            )
        )
        for (tokenizer in tokenizers) {
            val states = mutableListOf<ConsumptionState>()
            for (event in charEvents.sortedBy { it.index }) {
                val state = tokenizer.consume(event.char, event.index)
                states.add(state)
            }
            if (states.all { it == Consumed }) {
                break
            }
            for (state in states) {
                when (state) {
                    is Cancelled -> {
                        charEvents.addAll(state.capturedEvents)
                    }

                    Consumed -> {}
                    NotConsumed -> {}
                }
            }
        }
    }
    return semanticKotlinLexer(
        basicKotlinLexer(
            receivedTokens.sortedBy { it.startIndex }
        )
    )
}

