enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("coreLibs") {
            from(files("gradle/core-libs.versions.toml"))
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
    }
}
rootProject.name = "AncientEgypt"
include(":app")
include(":ui-kit")
include(":ui-sandbox")
