package com.katalyst.generator

import com.katalyst.dom.Element
import com.katalyst.dom.Node
import com.katalyst.environment.Environment

fun interface DeferredGenerator {
    fun generate(root: Node, environment: Environment): List<Element>
}