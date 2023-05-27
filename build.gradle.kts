import org.jetbrains.kotlin.gradle.tasks.KaptGenerateStubs

plugins {
    id("com.android.application") version "8.0.1" apply false
    id("com.android.library") version "8.0.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.20" apply false
    id("com.google.dagger.hilt.android") version "2.46.1" apply false
}
buildscript {
    extra.apply {
        set("targetSdkVersionApp", 33)
        set("compileSdkVersionApp", 33)
        set("minSdkVersionApp", 23)
        set("versionCodeApp", 1)
    }
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.46.1")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
    }
}
allprojects {
    repositories {
        google()
        mavenCentral()
    }
    //https://stackoverflow.com/questions/76030538/android-agp-8-gradle-8-kotlin-1-8-causes-error-in-kapt
    tasks.withType(KaptGenerateStubs::class.java).configureEach {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}