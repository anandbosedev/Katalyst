# Responsive image plugin for Katalyst

`responsive-image` is a Katalyst plugin which generates multiple images from 
the source image with specified formats and scaled sizes, and wraps them in `<picture>`
tag with different `<srcset>` entries.

> Note: `responsive-image` plugin requires `ImageMagick` (version 7.x.x) binaries in the `PATH`
> environment variable. If `ImageMagick` is not found in the path, `responsive-image`
> plugin will not scale the images, it falls back to `<img src="..." />` tag with
> the provided image.

Here is an example usage of `responsive-image` plugin:

```kotlin
responsiveImage(
    src = "/image.png", // The image should be at least 3x of 192x192 size
    width = 192,
    height = 192,
    scaleModes = listOf(1f, 2f, 3f),
    imageFormats = listOf(
        ResponsiveImageFormat.AVIF,
        ResponsiveImageFormat.PNG,
        ResponsiveImageFormat.WEBP,
    ),
    customAttributes = mapOf(
        "style" to "display: block; margin: 3em auto 1em auto;"
    ),
)
```