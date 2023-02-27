plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}
@Suppress("UnstableApiUsage")
android {
    compileSdk = Dependencies.Config.compileSdk
    defaultConfig {
        minSdk = Dependencies.Config.minSdk
        targetSdk = Dependencies.Config.targetSdk
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Config.kotlinCompilerExtensionVersion
    }
    lint {
        warningsAsErrors = true
        abortOnError = true
    }
}

dependencies {
    api (project(":features:home:router"))
    implementation(project(":common:router"))
    implementation (project(":core:uiComponents"))
    implementation (project(":core:dependency"))
    implementation (project(":core:dagger"))

    implementation (Dependencies.Accompanist.navigationAnimation)

    implementation(Dependencies.Coil.lib)

    implementation (Dependencies.Accompanist.pager)

    implementation (Dependencies.Core.Ktx.lib)
    implementation (Dependencies.Compose.uiToolingPreview)
    implementation (Dependencies.Dagger.lib)
    kapt (Dependencies.Dagger.daggerCompiler)
    implementation(Dependencies.Navigation.navigation)

    implementation(Dependencies.MaterialDesign.matherialIcons)

}