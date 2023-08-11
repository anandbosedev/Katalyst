package com.katalyst.dom

import com.katalyst.environment.Environment

open class BaseContext(val environment: Environment) {
    val elements = mutableListOf<Element>()
}