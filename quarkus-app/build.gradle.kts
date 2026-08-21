plugins {
    kotlin("jvm")
    id("io.quarkus")
}

group = "com.example"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(enforcedPlatform(libs.quarkus.platform))
    implementation(project(":shared-lib"))
    implementation(libs.quarkus.kotlin)
    implementation(libs.quarkus.rest)
    implementation(libs.kotlin.stdlib)
}

kotlin {
    jvmToolchain(25)
}
