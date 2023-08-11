package com.katalyst.highlighter.kotlin.tokenizer

val Tokenizers: List<Tokenizer>
    get() = listOf(
        StringLiteralTokenizer(),
        SingleLineCommentTokenizer(),
        BlockCommentTokenizer(),
        SymbolTokenizer(),
        PunctuationTokenizer(),
    )

open class GenericTokenizer(
    private val allowedChars: List<Char>,
    private val type: Int,
) : Tokenizer {
    private var buffer: StringBuffer? = null
    private var receiver: TokenCollector? = null
    private var startIndex = 0
    private var endIndex = 0
    override fun consume(char: Char, index: Int): ConsumptionState {
        if (char in allowedChars) {
            if (buffer == null) {
                buffer = StringBuffer()
                startIndex = index
            }
            buffer!!.append(char)
            endIndex = index
            return Consumed
        } else {
            if (buffer != null) {
                val token = Token(
                    buffer!!.toString(),
                    startIndex,
                    endIndex,
                    type
                )
                receiver!!.collect(token)
                buffer = null
                startIndex = 0
                endIndex = 0
            }
        }
        return NotConsumed
    }

    override fun registerTokenReceiver(receiver: TokenCollector) {
        this.receiver = receiver
    }
}

class SymbolTokenizer : GenericTokenizer(
    buildList {
        addAll('a'..'z')
        addAll('A'..'Z')
        addAll('0'..'9')
        add('_')
        add('`')
        add('@')
    }, TYPE_TOKEN
)

class PunctuationTokenizer : Tokenizer {
    private var receiver: TokenCollector? = null
    companion object {
        val allowedChars = listOf('{', '}', '(', ')', ':', '\$')
    }
    override fun consume(char: Char, index: Int): ConsumptionState {
        if (char in allowedChars) {
            receiver!!.collect(
                Token(
                    char.toString(),
                    index,
                    index,
                    TYPE_PUNCTUATION
                )
            )
            return Consumed
        }
        return NotConsumed
    }

    override fun registerTokenReceiver(receiver: TokenCollector) {
        this.receiver = receiver
    }

}

class StringLiteralTokenizer: Tokenizer {
    companion object {
        private const val STATE_EXPECTING_START_QUOTES = 0
        private const val STATE_EXPECTING_STRING_BODY = 1
        private const val STATE_EXPECTING_ESCAPE_SEQUENCE = 2
    }
    private var receiver: TokenCollector? = null
    //    private var isParsingString = false
//    private var isParsingEscapeSequence = false
    private var startIndex = 0
    private var endIndex = 0
    private var buffer: StringBuffer? = null
    private var state = STATE_EXPECTING_START_QUOTES

    override fun consume(char: Char, index: Int): ConsumptionState {
        return when (state) {
            STATE_EXPECTING_START_QUOTES -> {
                if (char == '"') {
                    appendBuffer(char, index)
                    state = STATE_EXPECTING_STRING_BODY
                    Consumed
                } else {
                    NotConsumed
                }
            }
            STATE_EXPECTING_STRING_BODY -> {
                appendBuffer(char, index)
                when (char) {
                    '\\' -> {
                        state = STATE_EXPECTING_ESCAPE_SEQUENCE
                    }
                    '"' -> {
                        receiver!!.collect(
                            Token(
                                buffer!!.toString(),
                                startIndex,
                                endIndex,
                                TYPE_STRING_LITERAL
                            )
                        )
                        clearState()
                    }
                }
                Consumed
            }
            STATE_EXPECTING_ESCAPE_SEQUENCE -> {
                appendBuffer(char, index)
                state = STATE_EXPECTING_STRING_BODY
                Consumed
            }
            else -> error("Invalid state: $state")
        }
    }

    override fun registerTokenReceiver(receiver: TokenCollector) {
        this.receiver = receiver
    }
    private fun appendBuffer(char: Char, index: Int) {
        if (buffer == null) {
            buffer = StringBuffer()
            startIndex = index
        }
        buffer!!.append(char)
        endIndex = index
    }

    private fun clearState() {
        buffer = null
        state = STATE_EXPECTING_START_QUOTES
        startIndex = 0
        endIndex = 0
    }

}

class SingleLineCommentTokenizer : Tokenizer {
    companion object {
        private val STATE_EXPECTING_FIRST_SLASH = 0
        private val STATE_EXPECTING_SECOND_SLASH = 1
        private val STATE_EXPECING_COMMENT_TEXT = 2
    }
    private var buffer: StringBuffer? = null
    private var startIndex = 0
    private var endIndex = 0
    private var events = mutableListOf<CharEvent>()
    private var receiver: TokenCollector? = null
    private var state = STATE_EXPECTING_FIRST_SLASH

    override fun consume(char: Char, index: Int): ConsumptionState {
        return when (state) {
            STATE_EXPECTING_FIRST_SLASH -> {
                if (char == '/') {
                    state = STATE_EXPECTING_SECOND_SLASH
                    events.add(CharEvent(index, char))
                    appendBuffer(char, index)
                    Consumed
                } else {
                    NotConsumed
                }
            }
            STATE_EXPECTING_SECOND_SLASH -> {
                if (char == '/') {
                    state = STATE_EXPECING_COMMENT_TEXT
                    events.add(CharEvent(index, char))
                    appendBuffer(char, index)
                    Consumed
                } else {
                    val events = this.events
                    clearState()
                    Cancelled(events)
                }
            }
            STATE_EXPECING_COMMENT_TEXT -> {
                if (char == '\n') {
                    receiver!!.collect(
                        Token(
                            buffer!!.toString(),
                            startIndex,
                            endIndex,
                            TYPE_KOTLIN_LINE_COMMENT
                        )
                    )
                    clearState()
                    NotConsumed
                } else {
                    appendBuffer(char, index)
                    Consumed
                }
            }
            else -> error("Invalid state: $state")
        }
    }

    override fun registerTokenReceiver(receiver: TokenCollector) {
        this.receiver = receiver
    }

    private fun appendBuffer(char: Char, index: Int) {
        if (buffer == null) {
            buffer = StringBuffer()
            startIndex = index
        }
        buffer!!.append(char)
        endIndex = index
    }

    private fun clearState() {
        buffer = null
        events = mutableListOf()
        state = STATE_EXPECTING_FIRST_SLASH
        startIndex = 0
        endIndex = 0
    }
}

class BlockCommentTokenizer : Tokenizer {
    companion object {
        private const val STATE_EXPECTING_START_SLASH = 0
        private const val STATE_EXPECTING_START_ASTERISK = 1
        private const val STATE_EXPECTING_COMMENT_BODY = 2
        private const val STATE_EXPECTING_END_SLASH = 3
    }
    private var buffer: StringBuffer? = null
    private var receiver: TokenCollector? = null
    private var events = mutableListOf<CharEvent>()
    private var state = STATE_EXPECTING_START_SLASH
    private var startIndex = 0
    private var endIndex = 0
    override fun consume(char: Char, index: Int): ConsumptionState {
        return when (state) {
            STATE_EXPECTING_START_SLASH -> {
                if (char == '/') {
                    state = STATE_EXPECTING_START_ASTERISK
                    events.add(CharEvent(index, char))
                    appendBuffer(char, index)
                    Consumed
                } else {
                    NotConsumed
                }
            }
            STATE_EXPECTING_START_ASTERISK -> {
                if (char == '*') {
                    state = STATE_EXPECTING_COMMENT_BODY
                    events.add(CharEvent(index, char))
                    appendBuffer(char, index)
                    Consumed
                } else {
                    events.add(CharEvent(index, char))
                    val events = this.events
                    clearState()
                    Cancelled(events)
                }
            }
            STATE_EXPECTING_COMMENT_BODY -> {
                if (char == '*') {
                    state = STATE_EXPECTING_END_SLASH
                }
                appendBuffer(char, index)
                return Consumed
            }
            STATE_EXPECTING_END_SLASH -> {
                if (char == '/') {
                    appendBuffer(char, index)
                    receiver!!.collect(
                        Token(
                            buffer!!.toString(),
                            startIndex,
                            endIndex,
                            TYPE_KOTLIN_BLOCK_COMMENT
                        )
                    )
                    clearState()
                } else {
                    appendBuffer(char, index)
                    state = STATE_EXPECTING_COMMENT_BODY
                }
                return Consumed
            }
            else -> {
                error("Unknown state $state")
            }
        }
    }

    private fun appendBuffer(char: Char, index: Int) {
        if (buffer == null) {
            buffer = StringBuffer()
            startIndex = index
        }
        buffer!!.append(char)
        endIndex = index
    }

    private fun clearState() {
        buffer = null
        events = mutableListOf()
        state = STATE_EXPECTING_START_SLASH
        startIndex = 0
        endIndex = 0
    }

    override fun registerTokenReceiver(receiver: TokenCollector) {
        this.receiver = receiver
    }

}