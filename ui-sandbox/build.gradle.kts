plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.evgenii.goncharov.ancient.egypt.ui_sandbox"
    compileSdk = rootProject.ext["compileSdkVersionApp"] as Int
    defaultConfig {
        applicationId = "com.evgenii.goncharov.ancient.egypt.ui_sandbox"
        minSdk = rootProject.ext["minSdkVersionApp"] as Int
        targetSdk = rootProject.ext["targetSdkVersionApp"] as Int
        versionCode = rootProject.ext["versionCodeApp"] as Int
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    android {
        viewBinding.enable = true
    }
}

dependencies {
    implementation(coreProjectLibs.core.ktx)
    implementation(uiLibs.app.compat)
    implementation(uiLibs.material)

    implementation(project(":ui-kit"))

    testImplementation(testingLibs.junit)
    androidTestImplementation(testingLibs.junit.androidx)
    androidTestImplementation(testingLibs.espresso)
}