plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.evgenii.goncharov.ancient.egypt.ui_sandbox"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.evgenii.goncharov.ancient.egypt.ui_sandbox"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
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