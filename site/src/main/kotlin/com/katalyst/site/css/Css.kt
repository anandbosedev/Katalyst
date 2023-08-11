package com.katalyst.site.css

import com.katalyst.highlighter.kotlin.css.KotlinSyntaxHighlighterCss

val css = buildList {
    addAll(variablesCss)
    addAll(baseCss)
    addAll(interFontsCss)
    addAll(jetBrainsMonoFontsCss)
    addAll(KotlinSyntaxHighlighterCss)
}