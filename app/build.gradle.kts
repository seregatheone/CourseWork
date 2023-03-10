plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

@Suppress("UnstableApiUsage")
android {
    namespace = Dependencies.Config.id
    compileSdk = Dependencies.Config.compileSdk

    defaultConfig {
        applicationId = Dependencies.Config.id
        minSdk = Dependencies.Config.minSdk
        targetSdk = Dependencies.Config.targetSdk
        versionCode = Dependencies.Config.versionCode
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField(
            CourseWorkClient.DefauleSettings.TYPE_STRING,
            CourseWorkClient.DefauleSettings.CONFIG_FIELD_MOCK,
            CourseWorkClient.DefauleSettings.COURSE_WORK_BACKEND
        )
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = Dependencies.Config.jVersion
        targetCompatibility = Dependencies.Config.jVersion
    }
    kotlinOptions {
        jvmTarget = Dependencies.Config.jvmTarget
        freeCompilerArgs += listOf("-opt-in=androidx.compose.material3.ExperimentalMaterial3Api")
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Config.kotlinCompilerExtensionVersion
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))

    implementation(project(":core:uiComponents"))
    implementation(project(":core:dagger"))
    implementation(project(":core:dependency"))

    implementation(project(":common:router"))

    implementation(project(":features:home:presentation"))
    implementation(project(":features:cart:presentation"))
    implementation(project(":features:productsDetails:presentation"))

    implementation(Dependencies.Core.Ktx.lib)
    implementation(Dependencies.MaterialDesign.plugin_3)
    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.uiToolingPreview)

    debugImplementation(Dependencies.Compose.uiTooling)
    implementation(Dependencies.Navigation.navigation)
    implementation(Dependencies.Dagger.lib)
    kapt(Dependencies.Dagger.daggerCompiler)

    implementation(Dependencies.Accompanist.systemUiController)
    implementation(Dependencies.Accompanist.navigationAnimation)

    implementation(Dependencies.Splashscreen.lib)
}