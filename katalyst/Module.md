# Module katalyst

Katalyst is a simple and minimal static site generator implemented in Kotlin. The goals of this project are:

* Provide a declarative interface for building HTML pages with type-safety.
* Build HTML components for reuse.
* Declarativley declare CSS rules and establish dependency graph between CSS declarations.
* Provide a resolver that statically analyzes HTML nodes and includes only the essential CSS blocks.
* A plugin interface to extend Katalyst.

# Package com.katalyst.css

Declaratively define CSS rules and establish dependency graph between CSS rules

# Package com.katalyst.dom

The `dom` package comes with everything needed to declarativley build HTML with Kotlin code. The basic building blocks are:

* `Node` - Represents an HTML tag, with attributes and children
* `Text` - Represents a text block
* `Deferred` - An empty element that defers rendering to the next phase. `Deferred` element should be linked to a generator that will be invoked after the current phase of DOM tree building. Here is an example use case: To resolve required CSS after building the DOM tree.

# Package com.katalyst.environment

Environment variables, accessible from anywhere in the DSL.

# Package com.katalyst.generator

The interfaces to implement generators to generate a specific part of DOM tree after the current build phase.
