plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.evgenii.goncharov.ancient.egypt.ui_kit"
    compileSdk = rootProject.ext["compileSdkVersionApp"] as Int
    defaultConfig {
        minSdk = rootProject.ext["minSdkVersionApp"] as Int
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
    implementation(uiLibs.viewBindingPropertyDelegate)
    implementation(utilsLibs.glide)
}