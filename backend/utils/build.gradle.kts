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
}

dependencies {
    implementation(Dependencies.Network.Gson.lib)
    implementation(Dependencies.Core.Ktx.lib)
    implementation(Dependencies.Coroutines.lib)
}