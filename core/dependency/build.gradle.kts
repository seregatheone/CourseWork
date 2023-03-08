plugins {
    id("com.android.library")
    kotlin("android")
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
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Core.Lifecycle.libCompose)
    implementation(Dependencies.Core.Ktx.lib)
    implementation(project(":common:router"))
}
