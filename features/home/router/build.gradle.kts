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
    lint {
        warningsAsErrors = true
        abortOnError = true
    }
}

dependencies {
    implementation(project(":common:router"))
}
