import org.gradle.api.JavaVersion

object Dependencies {
    object Kotlin {
        private const val version = "1.6.20"
        const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }
    object Compose {
        private const val version = "1.1.1"
        private const val versionActivity = "1.3.1"
        private const val versionNav = "2.5.1"
        const val navLib = "androidx.navigation:navigation-compose:$versionNav"
        const val ui = "androidx.compose.ui:ui:$version"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
        const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
        const val activity = "androidx.activity:activity-compose:$versionActivity"

        private const val androidxWindowVersion = "1.0.0"
        const val androidxWindow = "androidx.window:window:$androidxWindowVersion"

    }

    object Config {
        const val id = "pat.project.coursework"
        const val minSdk = 26
        const val targetSdk = 33
        const val versionCode = 1
        const val compileSdk = 33
        const val kotlinCompilerExtensionVersion = "1.2.0-alpha08"
        val jvmTarget = JavaVersion.VERSION_1_8.toString()
        val jVersion = JavaVersion.VERSION_1_8
    }

    object Gradle {
        private const val version = "7.3.1"
        const val plugin = "com.android.tools.build:gradle:$version"
    }

    object MaterialDesign {
        private const val version_2 = ""
        private const val version_3 = "1.0.1"
        const val plugin_2 = ""
        const val plugin_3 = "androidx.compose.material3:material3:$version_3"
        const val matherialIcons = "androidx.compose.material:material-icons-extended:$version_3"
    }

    object Dagger {
        private const val version = "2.43.2"
        const val lib = "com.google.dagger:dagger:$version"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:$version"
    }

    object Accompanist {
        private const val version = "0.27.0"

        const val pager = "com.google.accompanist:accompanist-pager:$version"
        const val systemUiController =
            "com.google.accompanist:accompanist-systemuicontroller:$version"
        const val navigationAnimation = "com.google.accompanist:accompanist-navigation-animation:$version"
    }

    object Navigation {
        private const val version = "2.5.3"
        const val navigation = "androidx.navigation:navigation-compose:$version"

        private const val version_hilt = "1.0.0"
        const val havigationHilt = "androidx.hilt:hilt-navigation-compose:$version_hilt"
    }

    object Core {
        object Ktx {
            private const val version = "1.8.0"
            const val lib = "androidx.core:core-ktx:$version"
        }

        object Lifecycle {
            private const val version = "2.5.1"
            const val libRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${version}"
            const val libCommon = "androidx.lifecycle:lifecycle-common:${version}"
            const val libCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
        }

    }

    object AppCompat {
        private const val version = "1.5.1"
        const val lib = "androidx.appcompat:appcompat:$version"
    }

    object Network {
        object Retrofit {
            private const val versionRetrofit = "2.9.0"

            const val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:${versionRetrofit}"
            const val lib = "com.squareup.retrofit2:retrofit:$versionRetrofit"
        }


        object Moshi {
            private const val moshiVersion = "1.14.0"
            const val moshi = "com.squareup.moshi:moshi-kotlin:$moshiVersion"
            const val moshiAdapter = "com.squareup.moshi:moshi-adapters:$moshiVersion"
        }

        object Logging {
            private const val version = "4.10.0"
            const val lib = "com.squareup.okhttp3:logging-interceptor:$version"
        }
    }

    object Coroutines {
        private const val version = "1.3.9"
        const val lib = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object Splashscreen{
        private const val version = "1.0.0"
        const val lib = "androidx.core:core-splashscreen:$version"
    }

}