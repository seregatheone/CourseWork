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
}

dependencies {
    api(project(":features:productsDetails:router"))
    implementation(project(":features:productsDetails:domain"))
    implementation(project(":common:router"))
    implementation(project(":core:uiComponents"))
    implementation(project(":core:dependency"))
    implementation(project(":core:dagger"))

    implementation(Dependencies.Accompanist.navigationAnimation)

    implementation(Dependencies.Accompanist.pager)
    implementation(Dependencies.Accompanist.flowRow)

    implementation(Dependencies.Coil.lib)

    implementation(Dependencies.Core.Ktx.lib)
    implementation(Dependencies.Compose.uiToolingPreview)
    implementation(Dependencies.Dagger.lib)
    kapt(Dependencies.Dagger.daggerCompiler)
    implementation(Dependencies.Navigation.navigation)

    implementation(Dependencies.MaterialDesign.matherialIcons)

}