package com.katalyst.site.css

import com.katalyst.css.CssDefinition

val variablesCss = listOf(
    CssDefinition(
        dependencyTag = ":root",
        selectors = listOf(":root"),
        declarations = mapOf(
            "--nav-text-color-light" to "#00201f",
            "--nav-background-color-light" to "#c5eae7",
            "--nav-text-color-dark" to "#c5eae7",
            "--nav-background-color-dark" to "#2b4c4a",
        ),
    ),
    CssDefinition(
        dependencyTag = ":root",
        selectors = listOf(":root", ":root.light"),
        declarations = mapOf(
            "--text-color" to "black",
            "--background-color" to "white",
            "--secondary-text-color" to "#555555",
            "--nav-menu-border-color" to "black",
            "--nav-menu-text-color" to "var(--nav-text-color-light)",
            "--nav-menu-bg-normal" to "var(--nav-background-color-light)",
            "--highlight-background-color" to "#00000011",
            "--link-color-normal" to "#006151",
            "--link-color-visited" to "#595959",
            "--btn-switch-dark-display" to "inline-block",
            "--btn-switch-light-display" to "none",
            "--btn-switch-theme-icon" to "url(\"data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' version='1.1' width='24' height='24' viewBox='0 0 256 256' xml:space='preserve'%3E%3Cdefs%3E%3C/defs%3E%3Cg style='stroke: none; stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill: none; fill-rule: nonzero; opacity: 1;' transform='translate(1.4065934065934016 1.4065934065934016) scale(2.81 2.81)' %3E%3Cpath d='M 68.946 70.5 c -18.255 3.338 -35.76 -8.754 -39.099 -27.009 s 8.754 -35.76 27.009 -39.099 c 1.737 -0.318 3.462 -0.453 5.174 -0.499 c -7.274 -2.784 -15.379 -3.671 -23.6 -2.168 C 14.531 6.096 -1.3 29.014 3.071 52.914 s 27.288 39.731 51.188 35.361 c 15.891 -2.906 28.206 -14.016 33.396 -28.158 C 82.878 65.341 76.446 69.128 68.946 70.5 z' style='stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill: rgb(247,215,127); fill-rule: nonzero; opacity: 1;' transform=' matrix(1 0 0 1 0 0) ' stroke-linecap='round' /%3E%3Cpath d='M 46.249 90.005 c -9.048 0 -17.872 -2.733 -25.476 -7.986 C 10.885 75.187 4.249 64.916 2.087 53.094 C -2.376 28.69 13.847 5.205 38.252 0.742 c 8.118 -1.484 16.466 -0.718 24.137 2.217 c 0.445 0.17 0.709 0.632 0.628 1.103 c -0.08 0.47 -0.481 0.818 -0.958 0.831 c -1.904 0.052 -3.5 0.206 -5.022 0.484 c -8.566 1.566 -16.009 6.375 -20.959 13.54 s -6.812 15.828 -5.246 24.395 c 1.566 8.566 6.375 16.01 13.54 20.959 c 7.165 4.95 15.831 6.81 24.395 5.246 l 0 0 c 7.02 -1.284 13.297 -4.768 18.15 -10.074 c 0.324 -0.354 0.852 -0.426 1.258 -0.18 c 0.408 0.248 0.584 0.751 0.419 1.199 c -5.473 14.91 -18.559 25.944 -34.155 28.796 C 51.708 89.757 48.968 90.005 46.249 90.005 z M 46.375 2.004 c -2.591 0 -5.189 0.234 -7.764 0.705 C 15.292 6.974 -0.21 29.415 4.055 52.734 C 6.12 64.03 12.461 73.845 21.91 80.373 c 9.448 6.526 20.87 8.984 32.169 6.918 c 13.308 -2.434 24.704 -11.102 30.715 -23.077 c -4.512 3.72 -9.849 6.206 -15.668 7.269 l 0 0 c -9.097 1.664 -18.287 -0.314 -25.891 -5.567 C 35.63 60.663 30.526 52.763 28.864 43.67 c -1.663 -9.091 0.314 -18.286 5.568 -25.891 c 5.253 -7.604 13.153 -12.708 22.245 -14.371 c 0.116 -0.021 0.232 -0.042 0.35 -0.062 C 53.547 2.454 49.968 2.004 46.375 2.004 z' style='stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill: rgb(0,0,0); fill-rule: nonzero; opacity: 1;' transform=' matrix(1 0 0 1 0 0) ' stroke-linecap='round' /%3E%3C/g%3E%3C/svg%3E\")",
        ),
    ),
    CssDefinition(
        dependencyTag = ":root",
        selectors = listOf(":root.dark"),
        declarations = mapOf(
            "--text-color" to "white",
            "--background-color" to "#222222",
            "--secondary-text-color" to "#cccccc",
            "--nav-menu-border-color" to "white",
            "--nav-menu-text-color" to "var(--nav-text-color-dark)",
            "--nav-menu-bg-normal" to "var(--nav-background-color-dark)",
            "--highlight-background-color" to "#ffffff11",
            "--link-color-normal" to "#90D0CD",
            "--link-color-visited" to "#C2C2C2",
            "--btn-switch-dark-display" to "none",
            "--btn-switch-light-display" to "inline-block",
            "--btn-switch-theme-icon" to "url(\"data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' version='1.1' width='24' height='24' viewBox='0 0 256 256' xml:space='preserve'%3E%3Cdefs%3E%3C/defs%3E%3Cg style='stroke: none; stroke-width: 0; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill: none; fill-rule: nonzero; opacity: 1;' transform='translate(1.4065934065934016 1.4065934065934016) scale(2.81 2.81)' %3E%3Ccircle cx='44.995999999999995' cy='44.995999999999995' r='26.676' style='stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill: rgb(249,193,0); fill-rule: nonzero; opacity: 1;' transform=' matrix(1 0 0 1 0 0) '/%3E%3Cpath d='M 45 72.676 c -15.26 0 -27.676 -12.415 -27.676 -27.676 c 0 -15.26 12.416 -27.676 27.676 -27.676 c 15.261 0 27.676 12.416 27.676 27.676 C 72.676 60.261 60.261 72.676 45 72.676 z M 45 19.324 c -14.158 0 -25.676 11.518 -25.676 25.676 c 0 14.157 11.518 25.676 25.676 25.676 c 14.157 0 25.676 -11.519 25.676 -25.676 C 70.676 30.842 59.157 19.324 45 19.324 z' style='stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;' transform=' matrix(1 0 0 1 0 0) ' stroke-linecap='round' /%3E%3Cpath d='M 45 11.053 c -0.552 0 -1 -0.448 -1 -1 V 1 c 0 -0.552 0.448 -1 1 -1 s 1 0.448 1 1 v 9.053 C 46 10.605 45.552 11.053 45 11.053 z' style='stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;' transform=' matrix(1 0 0 1 0 0) ' stroke-linecap='round' /%3E%3Cpath d='M 45 90 c -0.552 0 -1 -0.447 -1 -1 v -9.053 c 0 -0.553 0.448 -1 1 -1 s 1 0.447 1 1 V 89 C 46 89.553 45.552 90 45 90 z' style='stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;' transform=' matrix(1 0 0 1 0 0) ' stroke-linecap='round' /%3E%3Cpath d='M 10.053 46 H 1 c -0.552 0 -1 -0.448 -1 -1 s 0.448 -1 1 -1 h 9.053 c 0.552 0 1 0.448 1 1 S 10.605 46 10.053 46 z' style='stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;' transform=' matrix(1 0 0 1 0 0) ' stroke-linecap='round' /%3E%3Cpath d='M 89 46 h -9.053 c -0.553 0 -1 -0.448 -1 -1 s 0.447 -1 1 -1 H 89 c 0.553 0 1 0.448 1 1 S 89.553 46 89 46 z' style='stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;' transform=' matrix(1 0 0 1 0 0) ' stroke-linecap='round' /%3E%3Cpath d='M 69.711 21.289 c -0.256 0 -0.512 -0.098 -0.707 -0.293 c -0.391 -0.391 -0.391 -1.023 0 -1.414 l 6.401 -6.401 c 0.391 -0.391 1.023 -0.391 1.414 0 s 0.391 1.023 0 1.414 l -6.401 6.401 C 70.223 21.191 69.967 21.289 69.711 21.289 z' style='stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;' transform=' matrix(1 0 0 1 0 0) ' stroke-linecap='round' /%3E%3Cpath d='M 13.887 77.112 c -0.256 0 -0.512 -0.098 -0.707 -0.293 c -0.391 -0.391 -0.391 -1.023 0 -1.414 l 6.401 -6.401 c 0.391 -0.391 1.023 -0.391 1.414 0 s 0.391 1.023 0 1.414 l -6.401 6.401 C 14.399 77.015 14.143 77.112 13.887 77.112 z' style='stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;' transform=' matrix(1 0 0 1 0 0) ' stroke-linecap='round' /%3E%3Cpath d='M 20.289 21.289 c -0.256 0 -0.512 -0.098 -0.707 -0.293 l -6.401 -6.401 c -0.391 -0.391 -0.391 -1.023 0 -1.414 s 1.023 -0.391 1.414 0 l 6.401 6.401 c 0.391 0.391 0.391 1.023 0 1.414 C 20.8 21.191 20.544 21.289 20.289 21.289 z' style='stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;' transform=' matrix(1 0 0 1 0 0) ' stroke-linecap='round' /%3E%3Cpath d='M 76.112 77.112 c -0.256 0 -0.512 -0.098 -0.707 -0.293 l -6.401 -6.401 c -0.391 -0.391 -0.391 -1.023 0 -1.414 s 1.023 -0.391 1.414 0 l 6.401 6.401 c 0.391 0.391 0.391 1.023 0 1.414 C 76.624 77.015 76.368 77.112 76.112 77.112 z' style='stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 10; fill: rgb(255,255,255); fill-rule: nonzero; opacity: 1;' transform=' matrix(1 0 0 1 0 0) ' stroke-linecap='round' /%3E%3C/g%3E%3C/svg%3E\")",
        ),
    ),
    CssDefinition(
        dependencyTag = ":root",
        query = "@media (prefers-color-scheme: dark)",
        selectors = listOf(":root"),
        declarations = mapOf(
            "--text-color" to "white",
            "--background-color" to "#222222",
            "--secondary-text-color" to "#cccccc",
            "--nav-menu-border-color" to "white",
            "--nav-menu-text-color" to "var(--nav-text-color-dark)",
            "--nav-menu-bg-normal" to "var(--nav-background-color-dark)",
            "--highlight-background-color" to "#ffffff11",
            "--link-color-normal" to "#90D0CD",
            "--link-color-visited" to "#C2C2C2",
            "--btn-switch-dark-display" to "none",
            "--btn-switch-light-display" to "inline-block",
        ),
    )
)