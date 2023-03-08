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
    implementation(project(":common:domain"))
    api(project(":features:home:domain"))
    api(project(":features:cart:domain"))
    api(project(":features:productsDetails:domain"))

}
