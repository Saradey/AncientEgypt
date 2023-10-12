import org.jetbrains.kotlin.gradle.tasks.KaptGenerateStubs
plugins {
    alias(coreProjectLibs.plugins.dagger.hilt.plugin) apply false

    alias(libsProjectPlugins.plugins.project.android.application) apply false
    alias(libsProjectPlugins.plugins.project.android.library) apply false

    alias(libsProjectPlugins.plugins.jetbrains.kotlin) apply false
    alias(libsProjectPlugins.plugins.jetbrains.kotlin.parcelize) apply false
    alias(libsProjectPlugins.plugins.jetbrains.kotlin.serialization) apply false
}
buildscript {
    extra.apply {
        set("targetSdkVersionApp", 33)
        set("compileSdkVersionApp", 33)
        set("minSdkVersionApp", 23)
        set("versionCodeApp", 1)
    }
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.47")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10")
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