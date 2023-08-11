package com.katalyst.highlighter.kotlin.tokenizer

const val TYPE_TOKEN = 1
const val TYPE_PUNCTUATION = 2
const val TYPE_STRING_LITERAL = 3
const val TYPE_KOTLIN_KEYWORD = 4
const val TYPE_KOTLIN_FUNCTION_NAME = 5
const val TYPE_KOTLIN_CLASS_NAME = 6
const val TYPE_KOTLIN_ANNOTATION = 7
const val TYPE_KOTLIN_LINE_COMMENT = 8
const val TYPE_KOTLIN_BLOCK_COMMENT = 9

interface Tokenizer {
    fun consume(char: Char, index: Int): ConsumptionState
    fun registerTokenReceiver(receiver: TokenCollector)
}

fun interface TokenCollector {
    fun collect(token: Token)
}

data class CharEvent(val index: Int, val char: Char)
sealed interface ConsumptionState
object Consumed : ConsumptionState
object NotConsumed : ConsumptionState
data class Cancelled(val capturedEvents: MutableList<CharEvent>):
    ConsumptionState
data class Token(
    val text: String,
    val startIndex: Int,
    val endIndex: Int,
    val type: Int,
)
