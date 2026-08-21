plugins {
    kotlin("jvm")
}

group = "com.example"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.stdlib)
}

kotlin {
    jvmToolchain(25)
}
