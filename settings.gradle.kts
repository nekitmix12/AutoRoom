@file:Suppress("UnstableApiUsage")


rootProject.name = "AutoRoom"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

// APP
include(":app")

// COMMON
include(":common:mvi:mvi-general")
include(":common:mvi:mvi-koin-voyager")
include(":common:logger")
include(":common:utils")

// CORE
include(":core:network")
include(":core:database")
include(":core:resources")