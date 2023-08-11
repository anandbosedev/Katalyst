package com.katalyst.css

import com.katalyst.dom.Node

/**
 * Represents CSS declaration.
 *
 * The implementation of [CssDefinition] is motivated by the reduction of request waterfalls by inclusion of
 * CSS within the `<style>` element in HTML. The implementation of [com.katalyst.generator.InlineStyleGenerator]
 * will traverse through the HTML tree and looks for matching CSS rules for including in `<style>` element, therefore
 * it eliminates the presence of unneeded CSS rules.
 *
 * Also, [com.katalyst.generator.InlineStyleGenerator] will recursively resolve dependencies by
 * looking up on [depends] list, searches the list of CSS rules with matching [dependencyTag] and
 * includes them in the `<style>` element.
 *
 * @param matchers List of matchers which specifies the criteria for discoverability of CSS rules
 * when [com.katalyst.generator.InlineStyleGenerator] look-up applicable styles when traversing
 * through the HTML element tree. It is possible to match by [Id], [ClassName], [TagName], [Attribute] and
 * [All] that combines type, id and class.
 *
 * Here is a simple illustration how matchers builds the selectors:
 *
 * | Matcher | Matched element | Generated CSS selector |
 * |--------|------------|------------|
 * | [Id] | `<element id="foo">` | `#foo  { ... }` |
 * | [ClassName] | `<element class="foo">` | `.foo  { ... }` |
 * | [TagName] | `<foo ...>` | `foo { ... }` |
 * | [Attribute] | `<element key="value">` | `[key="value"]  { ... }` |
 * | [All] | `<type class="foo bar" id="baz">` | `type.foo.bar#baz  { ... }` |
 *
 * @param selectors The list of raw selectors if it is not possible to produce the required selector with
 * [matchers]. Example: It is not possible to define [combinators](https://developer.mozilla.org/en-US/docs/Learn/CSS/Building_blocks/Selectors/Combinators)
 * using [matchers]. In that case, you have to provide [matchers] as well as [selectors].
 *
 * *Note: If [selectors] are provided,
 * [matchers] will be completely ignored for CSS selector generation. Make sure to include all selectors defined in
 * the matchers.*
 *
 * @param query Should be provided if you need to wrap the CSS rule inside a query statement.
 *
 * Example `@media screen and (min-width: 38em)`
 *
 * @param declarations The parameter to provide CSS properties.
 *
 * Example: `declarations = mapOf("display" to "inline-block")`
 *
 * @param dependencyTag A unique identifier for reference in other [CssDefinition] block in [depends] parameter.
 * If [CssDefinition] `foo` declares [dependencyTag] as "foo" and [CssDefinition] `bar` requires the dependency `foo`
 * in the [depends] list, `bar` will be included in the `<style>` element if any HTML node matches the `foo` [CssDefinition].
 *
 * @param depends The list of dependent CSS rules if the current [CssDefinition] is selected to include in the `<style>` element.
 */
data class CssDefinition(
    var matchers: List<CssMatcher>? = null,
    var selectors: List<String>? = null,
    var query: String? = null,
    var declarations: Map<String, String>? = null,
    var dependencyTag: String? = null,
    var depends: List<String>? = null,
    var preloadList: List<Preload>? = null,
) {
    /**
     * Compiles the [CssDefinition] for including them in the `<style>` element.
     *
     * *Note: The produced CSS declaration is not indented/prettified*
     */
    fun render(): String {
        return buildString {
            val query = query
            if (query != null) {
                append(query)
                append(" { ")
                append(renderRuleSet())
                append("} ")
            } else {
                append(renderRuleSet())
            }
        }
    }

    private fun renderRuleSet(): String {
        return buildString {
            val selectors = selectors
            val matchers = matchers
            when {
                !selectors.isNullOrEmpty() -> {
                    append(selectors.joinToString())
                    append(" { ")
                    append(renderDeclarations())
                    append("} ")
                }
                !matchers.isNullOrEmpty() -> {
                    append(matchers.joinToString { it.toCssNotation() })
                    append(" { ")
                    append(renderDeclarations())
                    append("} ")
                }
                else -> {
                    append(renderDeclarations())
                }
            }
        }
    }

    private fun renderDeclarations(): String {
        return buildString {
            declarations?.forEach { (key, value) ->
                append(key)
                append(": ")
                append(value)
                append("; ")
            }
        }
    }
}

/**
 * The interface to define a predicate that matches a [CssDefinition] to [Node]
 */
interface CssMatcher {
    /**
     * Called by the [com.katalyst.generator.InlineStyleGenerator] during HTML element tree
     * traversal
     *
     * @return `true` if [CssDefinition] is applicable to [Node]
     */
    fun matches(node: Node): Boolean

    /**
     * Represent the [CssMatcher] as a valid CSS selector.
     */
    fun toCssNotation(): String
}

/**
 * The [CssMatcher] implementation that applies to [Node] with attribute id == [id].
 *
 * @param id Value of `id` attribute of the element `<element id=[id]>`
 */
data class Id(val id: String): CssMatcher {
    override fun matches(node: Node): Boolean {
        return id == node.id
    }

    override fun toCssNotation(): String = "#$id"
}

/**
 * The [CssMatcher] implementation that applies to [Node]s if `class` attribute matches the [className].
 *
 * @param className Value of `class` attribute of the element `<element class="[className] ...">`
 */
data class ClassName(val className: String): CssMatcher {
    override fun matches(node: Node): Boolean {
        return node.classNames?.contains(className) == true
    }

    override fun toCssNotation(): String = ".$className"
}

/**
 * The [CssMatcher] implementation that applies to [Node]s if tag matches the [tagName].
 *
 * @param tagName The tag name of the element `<[tagName] ...>`
 */
data class TagName(val tagName: String): CssMatcher {
    override fun matches(node: Node): Boolean {
        return  node.tagName == tagName
    }

    override fun toCssNotation(): String = tagName
}

/**
 * The [CssMatcher] implementation that applies to the [Node]s with the matching attribute key and value
 *
 * @param key The key for `<element [key]="[value]">`
 * @param value The value for `<element [key]="[value]">`
 */
data class Attribute(val key: String, val value: String?): CssMatcher {
    override fun matches(node: Node): Boolean {
        return if (value != null) {
            node.attributes?.get(key) == value
        } else {
            node.attributes?.contains(key) == true
        }
    }

    override fun toCssNotation(): String {
        return buildString {
            append("[")
            append(key)
            if (value != null) {
                append("=")
                append("\"$value\"")
            }
            append("]")
        }
    }
}

/**
 * The [CssMatcher] implementation that matches if all the provided parameters matches with the node.
 * The resultant selector will be [tagName].[classNames].[classNames]:[pseudoClassNames]#[id]
 */
data class All(
    val tagName: String? = null,
    val classNames: List<String>? = null,
    val pseudoClassNames: List<String>? = null,
    val id: String? = null,
): CssMatcher {

    override fun matches(node: Node): Boolean {
        val isTagMatch = tagName == null || node.tagName == tagName
        val isClassNamesMatch = if (!classNames.isNullOrEmpty()) {
            val nodeClassNames = node.classNames
            nodeClassNames == null || nodeClassNames.containsAll(classNames)
        } else true
        val isIdMatch = id == null || node.id == id
        return isTagMatch && isClassNamesMatch && isIdMatch
    }

    override fun toCssNotation(): String {
        return buildString {
            if (tagName != null) {
                append(tagName)
            }
            pseudoClassNames?.forEach { pseudoClassName ->
                append(":$pseudoClassName")
            }
            classNames?.forEach { className ->
                append(".$className")
            }
            if (id != null) {
                append("#$id")
            }
        }
    }
}