plugins {
    kotlin("jvm")
    application
}

group = "com.katalyst.app"
version = "1.0.0"

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("com.katalyst.site.MainKt")
    applicationName = "katalyst-site"
}

dependencies {
    implementation(project(":katalyst"))
    implementation(project(":kotlin-syntax-highlighter-plugin"))
    implementation(project(":responsive-image"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk9:1.6.4")
    testImplementation(kotlin("test"))
}