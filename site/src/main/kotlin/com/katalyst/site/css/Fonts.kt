package com.katalyst.site.css

import com.katalyst.css.CssDefinition
import com.katalyst.css.Preload
import com.katalyst.site.SITE_PREFIX

val jetBrainsMonoFontsCss = listOf(
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'JetBrains Mono'",
//            "font-style" to "italic",
//            "font-weight" to "100",
//            "font-display" to "swap",
//            "src" to "url($SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-ThinItalic.woff2) format('truetype')",
//        ),
//        dependencyTag = "JetBrains Mono",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-ThinItalic.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'JetBrains Mono'",
//            "font-style" to "italic",
//            "font-weight" to "200",
//            "font-display" to "swap",
//            "src" to "url($SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-ExtraLightItalic.woff2) format('truetype')",
//        ),
//        dependencyTag = "JetBrains Mono",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-ExtraLightItalic.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'JetBrains Mono'",
//            "font-style" to "italic",
//            "font-weight" to "300",
//            "font-display" to "swap",
//            "src" to "url($SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-LightItalic.woff2) format('truetype')",
//        ),
//        dependencyTag = "JetBrains Mono",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-LightItalic.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'JetBrains Mono'",
//            "font-style" to "italic",
//            "font-weight" to "400",
//            "font-display" to "swap",
//            "src" to "url($SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-Italic.woff2) format('truetype')",
//        ),
//        dependencyTag = "JetBrains Mono",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-Italic.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'JetBrains Mono'",
//            "font-style" to "italic",
//            "font-weight" to "500",
//            "font-display" to "swap",
//            "src" to "url($SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-MediumItalic.woff2) format('truetype')",
//        ),
//        dependencyTag = "JetBrains Mono",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-MediumItalic.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'JetBrains Mono'",
//            "font-style" to "italic",
//            "font-weight" to "600",
//            "font-display" to "swap",
//            "src" to "url($SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-SemiBoldItalic.woff2) format('truetype')",
//        ),
//        dependencyTag = "JetBrains Mono",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-SemiBoldItalic.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'JetBrains Mono'",
//            "font-style" to "italic",
//            "font-weight" to "700",
//            "font-display" to "swap",
//            "src" to "url($SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-BoldItalic.woff2) format('truetype')",
//        ),
//        dependencyTag = "JetBrains Mono",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-BoldItalic.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'JetBrains Mono'",
//            "font-style" to "italic",
//            "font-weight" to "800",
//            "font-display" to "swap",
//            "src" to "url($SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-ExtraBoldItalic.woff2) format('truetype')",
//        ),
//        dependencyTag = "JetBrains Mono",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-ExtraBoldItalic.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'JetBrains Mono'",
//            "font-style" to "normal",
//            "font-weight" to "100",
//            "font-display" to "swap",
//            "src" to "url($SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-Thin.woff2) format('truetype')",
//        ),
//        dependencyTag = "JetBrains Mono",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-Thin.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'JetBrains Mono'",
//            "font-style" to "normal",
//            "font-weight" to "200",
//            "font-display" to "swap",
//            "src" to "url($SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-ExtraLight.woff2) format('truetype')",
//        ),
//        dependencyTag = "JetBrains Mono",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-ExtraLight.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'JetBrains Mono'",
//            "font-style" to "normal",
//            "font-weight" to "300",
//            "font-display" to "swap",
//            "src" to "url($SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-Light.woff2) format('truetype')",
//        ),
//        dependencyTag = "JetBrains Mono",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-Light.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'JetBrains Mono'",
//            "font-style" to "normal",
//            "font-weight" to "400",
//            "font-display" to "swap",
//            "src" to "url($SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-Regular.woff2) format('truetype')",
//        ),
//        dependencyTag = "JetBrains Mono",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-Regular.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'JetBrains Mono'",
//            "font-style" to "normal",
//            "font-weight" to "500",
//            "font-display" to "swap",
//            "src" to "url($SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-Medium.woff2) format('truetype')",
//        ),
//        dependencyTag = "JetBrains Mono",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-Medium.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'JetBrains Mono'",
//            "font-style" to "normal",
//            "font-weight" to "600",
//            "font-display" to "swap",
//            "src" to "url($SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-SemiBold.woff2) format('truetype')",
//        ),
//        dependencyTag = "JetBrains Mono",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-SemiBold.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'JetBrains Mono'",
//            "font-style" to "normal",
//            "font-weight" to "700",
//            "font-display" to "swap",
//            "src" to "url($SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-Bold.woff2) format('truetype')",
//        ),
//        dependencyTag = "JetBrains Mono",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-Bold.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
    CssDefinition(
        query = "@font-face",
        declarations = mapOf(
            "font-family" to "'JetBrains Mono'",
            "font-style" to "normal",
            "font-weight" to "100 900",
            "font-display" to "swap",
            "font-named-instance" to "'Regular'",
            "src" to "url(\"$SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono[wght].woff2\") format(\"woff2\")",
        ),
        dependencyTag = "JetBrains Mono",
        preloadList = listOf(
            Preload(
                href = "$SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono[wght].woff2",
                `as` = "font",
                type = "font/woff2"
            ),
        ),
    ),
    CssDefinition(
        query = "@font-face",
        declarations = mapOf(
            "font-family" to "'JetBrains Mono'",
            "font-style" to "italic",
            "font-weight" to "100 900",
            "font-display" to "swap",
            "font-named-instance" to "'Regular'",
            "src" to "url(\"$SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-Italic[wght].woff2\") format(\"woff2\")",
        ),
        dependencyTag = "JetBrains Mono",
        preloadList = listOf(
            Preload(
                href = "$SITE_PREFIX/styles/fonts/jetbrains-mono/JetBrainsMono-Italic[wght].woff2",
                `as` = "font",
                type = "font/woff2"
            ),
        ),
    ),
)

val interFontsCss = listOf(
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'Inter'",
//            "font-style" to "normal",
//            "font-weight" to "100",
//            "font-display" to "swap",
//            "src" to "url(\"$SITE_PREFIX/styles/fonts/inter/Inter-Thin.woff2\") format(\"woff2\"), url(\"/styles/fonts/inter/Inter-Thin.woff\") format(\"woff\")",
//        ),
//        dependencyTag = "Inter",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/inter/Inter-Thin.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'Inter'",
//            "font-style" to "italic",
//            "font-weight" to "100",
//            "font-display" to "swap",
//            "src" to "url(\"$SITE_PREFIX/styles/fonts/inter/Inter-ThinItalic.woff2\") format(\"woff2\"), url(\"/styles/fonts/inter/Inter-ThinItalic.woff\") format(\"woff\")",
//        ),
//        dependencyTag = "Inter",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/inter/Inter-ThinItalic.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'Inter'",
//            "font-style" to "normal",
//            "font-weight" to "200",
//            "font-display" to "swap",
//            "src" to "url(\"$SITE_PREFIX/styles/fonts/inter/Inter-ExtraLight.woff2\") format(\"woff2\"), url(\"/styles/fonts/inter/Inter-ExtraLight.woff\") format(\"woff\")",
//        ),
//        dependencyTag = "Inter",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/inter/Inter-ExtraLight.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'Inter'",
//            "font-style" to "italic",
//            "font-weight" to "200",
//            "font-display" to "swap",
//            "src" to "url(\"$SITE_PREFIX/styles/fonts/inter/Inter-ExtraLightItalic.woff2\") format(\"woff2\"), url(\"/styles/fonts/inter/Inter-ExtraLightItalic.woff\") format(\"woff\")",
//        ),
//        dependencyTag = "Inter",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/inter/Inter-ExtraLightItalic.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'Inter'",
//            "font-style" to "normal",
//            "font-weight" to "300",
//            "font-display" to "swap",
//            "src" to "url(\"$SITE_PREFIX/styles/fonts/inter/Inter-Light.woff2\") format(\"woff2\"), url(\"/styles/fonts/inter/Inter-Light.woff\") format(\"woff\")",
//        ),
//        dependencyTag = "Inter",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/inter/Inter-Light.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'Inter'",
//            "font-style" to "italic",
//            "font-weight" to "300",
//            "font-display" to "swap",
//            "src" to "url(\"$SITE_PREFIX/styles/fonts/inter/Inter-LightItalic.woff2\") format(\"woff2\"), url(\"/styles/fonts/inter/Inter-LightItalic.woff\") format(\"woff\")",
//        ),
//        dependencyTag = "Inter",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/inter/Inter-LightItalic.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'Inter'",
//            "font-style" to "normal",
//            "font-weight" to "400",
//            "font-display" to "swap",
//            "src" to "url(\"$SITE_PREFIX/styles/fonts/inter/Inter-Regular.woff2\") format(\"woff2\"), url(\"/styles/fonts/inter/Inter-Regular.woff\") format(\"woff\")",
//        ),
//        dependencyTag = "Inter",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/inter/Inter-Regular.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'Inter'",
//            "font-style" to "italic",
//            "font-weight" to "400",
//            "font-display" to "swap",
//            "src" to "url(\"$SITE_PREFIX/styles/fonts/inter/Inter-Italic.woff2\") format(\"woff2\"), url(\"/styles/fonts/inter/Inter-Italic.woff\") format(\"woff\")",
//        ),
//        dependencyTag = "Inter",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/inter/Inter-Italic.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'Inter'",
//            "font-style" to "normal",
//            "font-weight" to "500",
//            "font-display" to "swap",
//            "src" to "url(\"$SITE_PREFIX/styles/fonts/inter/Inter-Medium.woff2\") format(\"woff2\"), url(\"/styles/fonts/inter/Inter-Medium.woff\") format(\"woff\")",
//        ),
//        dependencyTag = "Inter",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/inter/Inter-Medium.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'Inter'",
//            "font-style" to "italic",
//            "font-weight" to "500",
//            "font-display" to "swap",
//            "src" to "url(\"$SITE_PREFIX/styles/fonts/inter/Inter-MediumItalic.woff2\") format(\"woff2\"), url(\"/styles/fonts/inter/Inter-MediumItalic.woff\") format(\"woff\")",
//        ),
//        dependencyTag = "Inter",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/inter/Inter-MediumItalic.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'Inter'",
//            "font-style" to "normal",
//            "font-weight" to "600",
//            "font-display" to "swap",
//            "src" to "url(\"$SITE_PREFIX/styles/fonts/inter/Inter-SemiBold.woff2\") format(\"woff2\"), url(\"/styles/fonts/inter/Inter-SemiBold.woff\") format(\"woff\")",
//        ),
//        dependencyTag = "Inter",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/inter/Inter-SemiBold.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'Inter'",
//            "font-style" to "italic",
//            "font-weight" to "600",
//            "font-display" to "swap",
//            "src" to "url(\"$SITE_PREFIX/styles/fonts/inter/Inter-SemiBoldItalic.woff2\") format(\"woff2\"), url(\"/styles/fonts/inter/Inter-SemiBoldItalic.woff\") format(\"woff\")",
//        ),
//        dependencyTag = "Inter",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/inter/Inter-SemiBoldItalic.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'Inter'",
//            "font-style" to "normal",
//            "font-weight" to "700",
//            "font-display" to "swap",
//            "src" to "url(\"$SITE_PREFIX/styles/fonts/inter/Inter-Bold.woff2\") format(\"woff2\"), url(\"/styles/fonts/inter/Inter-Bold.woff\") format(\"woff\")",
//        ),
//        dependencyTag = "Inter",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/inter/Inter-Bold.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'Inter'",
//            "font-style" to "italic",
//            "font-weight" to "700",
//            "font-display" to "swap",
//            "src" to "url(\"$SITE_PREFIX/styles/fonts/inter/Inter-BoldItalic.woff2\") format(\"woff2\"), url(\"/styles/fonts/inter/Inter-BoldItalic.woff\") format(\"woff\")",
//        ),
//        dependencyTag = "Inter",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/inter/Inter-BoldItalic.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'Inter'",
//            "font-style" to "normal",
//            "font-weight" to "800",
//            "font-display" to "swap",
//            "src" to "url(\"$SITE_PREFIX/styles/fonts/inter/Inter-ExtraBold.woff2\") format(\"woff2\"), url(\"/styles/fonts/inter/Inter-ExtraBold.woff\") format(\"woff\")",
//        ),
//        dependencyTag = "Inter",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/inter/Inter-ExtraBold.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'Inter'",
//            "font-style" to "italic",
//            "font-weight" to "800",
//            "font-display" to "swap",
//            "src" to "url(\"$SITE_PREFIX/styles/fonts/inter/Inter-ExtraBoldItalic.woff2\") format(\"woff2\"), url(\"/styles/fonts/inter/Inter-ExtraBoldItalic.woff\") format(\"woff\")",
//        ),
//        dependencyTag = "Inter",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/inter/Inter-ExtraBoldItalic.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'Inter'",
//            "font-style" to "normal",
//            "font-weight" to "900",
//            "font-display" to "swap",
//            "src" to "url(\"$SITE_PREFIX/styles/fonts/inter/Inter-Black.woff2\") format(\"woff2\"), url(\"/styles/fonts/inter/Inter-Black.woff\") format(\"woff\")",
//        ),
//        dependencyTag = "Inter",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/inter/Inter-Black.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
//    CssDefinition(
//        query = "@font-face",
//        declarations = mapOf(
//            "font-family" to "'Inter'",
//            "font-style" to "italic",
//            "font-weight" to "900",
//            "font-display" to "swap",
//            "src" to "url(\"$SITE_PREFIX/styles/fonts/inter/Inter-BlackItalic.woff2\") format(\"woff2\"), url(\"/styles/fonts/inter/Inter-BlackItalic.woff\") format(\"woff\")",
//        ),
//        dependencyTag = "Inter",
//        preloadList = listOf(
//            Preload(
//                href = "$SITE_PREFIX/styles/fonts/inter/Inter-BlackItalic.woff2",
//                `as` = "font",
//                type = "font/woff2"
//            ),
//        ),
//    ),
    CssDefinition(
        query = "@font-face",
        declarations = mapOf(
            "font-family" to "'Inter'",
            "font-style" to "normal",
            "font-weight" to "100 900",
            "font-display" to "swap",
            "font-named-instance" to "'Regular'",
            "src" to "url(\"$SITE_PREFIX/styles/fonts/inter/Inter-roman.var.woff2\") format(\"woff2\")",
        ),
        dependencyTag = "Inter",
        preloadList = listOf(
            Preload(
                href = "$SITE_PREFIX/styles/fonts/inter/Inter-roman.var.woff2",
                `as` = "font",
                type = "font/woff2"
            ),
        ),
    ),
    CssDefinition(
        query = "@font-face",
        declarations = mapOf(
            "font-family" to "'Inter'",
            "font-style" to "italic",
            "font-weight" to "100 900",
            "font-display" to "swap",
            "font-named-instance" to "'Regular'",
            "src" to "url(\"$SITE_PREFIX/styles/fonts/inter/Inter-italic.var.woff2\") format(\"woff2\")",
        ),
        dependencyTag = "Inter",
        preloadList = listOf(
            Preload(
                href = "$SITE_PREFIX/styles/fonts/inter/Inter-italic.var.woff2",
                `as` = "font",
                type = "font/woff2"
            ),
        ),
    ),
)