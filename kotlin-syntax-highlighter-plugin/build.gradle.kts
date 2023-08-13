plugins {
    kotlin("jvm")
    `maven-publish`
}

group = "com.katalyst"
version = "1.0.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(project(":katalyst"))
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    repositories {
        /*maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/droidcrafts/katalyst")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
            }
        }*/
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