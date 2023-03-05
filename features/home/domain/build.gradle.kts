plugins {
    id("com.android.library")
    id("kotlin-parcelize")
    kotlin("android")
}
@Suppress("UnstableApiUsage")
android {
    compileSdk = Dependencies.Config.compileSdk
    defaultConfig {
        minSdk = Dependencies.Config.minSdk
        targetSdk = Dependencies.Config.targetSdk
    }

}

dependencies {
    implementation(Dependencies.Core.Ktx.lib)
    api(project(":common:domain"))
}
