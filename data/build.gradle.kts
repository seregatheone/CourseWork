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
    implementation(Dependencies.Core.Ktx.lib)
    implementation(Dependencies.Network.Retrofit.lib)
    implementation(Dependencies.Network.Gson.lib)
    implementation(Dependencies.Network.Logging.lib)
    api(project(":backend:utils"))
    api(project(":backend:coursework"))
    implementation(project(":common:domain"))
    implementation(project(":features:home:domain"))

}
