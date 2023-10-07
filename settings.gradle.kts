enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    versionCatalogs {
        create("coreProjectLibs") {
            from(files("gradle/core-project-libs.versions.toml"))
        }
        create("uiLibs") {
            from(files("gradle/ui-libs.versions.toml"))
        }
        create("utilsLibs") {
            from(files("gradle/utils-libs.versions.toml"))
        }
        create("networkLibs") {
            from(files("gradle/network-libs.versions.toml"))
        }
        create("testingLibs") {
            from(files("gradle/testing-libs.versions.toml"))
        }
        create("qualityLibs") {
            from(files("gradle/quality-libs.versions.toml"))
        }
        create("androidLibs") {
            from(files("gradle/android-libs.versions.toml"))
        }
        create("libsProjectPlugins") {
            from(files("gradle/libs-project-plugins.versions.toml"))
        }
    }
}
rootProject.name = "AncientEgypt"
include(":app")
include(":ui-kit")
include(":ui-sandbox")
