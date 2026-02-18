import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

compose.resources {
    generateResClass = never
}

kotlin {
    androidLibrary {
        namespace = "v.company.common.mvi.impl"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        compilerOptions{
            jvmTarget.set(JvmTarget.JVM_21)
        }

    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(projects.common.logger)
            implementation(projects.common.utils)
            implementation(projects.common.mvi.mviGeneral)

            implementation(libs.kotlinx.coroutines.core)

            implementation(libs.compose.runtime)

            implementation(libs.koin.core)

            implementation(libs.voyager.koin)
            implementation(libs.voyager.screenModel)
        }
        iosMain.dependencies {
            implementation(libs.touchlab.stately.common)
            implementation(libs.compose.runtime.saveable)
        }
    }
}
