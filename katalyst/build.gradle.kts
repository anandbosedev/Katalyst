import org.intellij.markdown.html.URI
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    kotlin("jvm")
    id("org.jetbrains.dokka")
    `maven-publish`
}

group = "com.katalyst"
version = "1.0.0-SNAPSHOT"

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
    withJavadocJar()
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk9:1.6.4")
    testImplementation(kotlin("test"))
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/droidcrafts/katalyst")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
            }
        }
        maven {
            name = "LocalPackages"
            url = uri(layout.buildDirectory.dir("repos/maven"))
        }
    }
    publications {
        register<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

tasks.withType<DokkaTask>().configureEach {
    dokkaSourceSets {
        configureEach {
            includes.from("Module.md")
            sourceLink {
                remoteUrl.set(URI("https://github.com/droidcrafts/Katalyst/blob/main/katalyst").toURL())
                localDirectory.set(projectDir)
            }
        }
    }
}