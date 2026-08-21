plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "quarkus-isolated-projects-reproducer"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }

    versionCatalogs {
        create("libs") {
            val kotlinVersion = "2.4.0"
            val quarkusVersion = "3.39.0"

            version("kotlin", kotlinVersion)
            version("quarkus", quarkusVersion)

            library("quarkus-platform", "io.quarkus.platform:quarkus-bom:$quarkusVersion")
            library("quarkus-kotlin", "io.quarkus:quarkus-kotlin:$quarkusVersion")
            library("quarkus-rest", "io.quarkus:quarkus-rest:$quarkusVersion")
            library("kotlin-stdlib", "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
        }
    }
}

include("shared-lib", "quarkus-app")
