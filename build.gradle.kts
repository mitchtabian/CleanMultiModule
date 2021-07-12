// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.1.0-alpha03")

        val kotlin = "1.5.10"
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin")

        val hilt = "2.37"
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hilt")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}