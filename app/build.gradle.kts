plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.evgenii.goncharov.ancient.egypt"
    compileSdk = rootProject.ext["compileSdkVersionApp"] as Int

    defaultConfig {
        applicationId = "com.evgenii.goncharov.ancient.egypt"
        minSdk = rootProject.ext["minSdkVersionApp"] as Int
        targetSdk = rootProject.ext["targetSdkVersionApp"] as Int
        versionCode = rootProject.ext["versionCodeApp"] as Int
        versionName = getVersionName()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    android {
        viewBinding.enable = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    //ui
    implementation(uiLibs.app.compat)
    implementation(uiLibs.material)
    implementation(uiLibs.constraint.layout)
    implementation(uiLibs.recycler.view)
    implementation(uiLibs.recycler.view.adapter)
    implementation(uiLibs.viewBindingPropertyDelegate)
    implementation(uiLibs.exoplayer)

    //core
    implementation(coreProjectLibs.dagger.hilt)
    kapt(coreProjectLibs.dagger.hilt.compiler)
    implementation(coreProjectLibs.navigation.fragment.ktx)
    implementation(coreProjectLibs.navigation.ui.ktx)
    implementation(coreProjectLibs.room)
    implementation(coreProjectLibs.room.ktx)
    kapt(coreProjectLibs.room.compiler)
    implementation(coreProjectLibs.core.ktx)

    implementation(project(":ui-kit"))
}

//TODO написать к релизу
fun getVersionName(): String = "1.0"
