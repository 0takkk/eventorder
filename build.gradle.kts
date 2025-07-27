import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    val kotlinVersion = "2.2.0"
    id("idea")
    id("java")
    kotlin("jvm") version kotlinVersion
    kotlin("kapt") version kotlinVersion
}

group = "com.order"
version = "0.0.1-SNAPSHOT"

allprojects {
    apply(plugin = "java")
    apply(plugin = "kotlin")

    repositories {
        mavenCentral()
    }

    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(21)
        }
    }

    tasks.compileKotlin {
        compilerOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = JvmTarget.fromTarget("21")
        }
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    tasks.test {
        useJUnitPlatform()
    }
}
