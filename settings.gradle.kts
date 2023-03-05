pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenLocal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "CourseWork"
include(
    ":app",

    ":data",
    ":domain",

    ":backend:coursework",
    ":backend:utils",

    ":core:dagger",
    ":core:dependency",
    ":core:uiComponents",

    ":common:router",
    ":common:domain",

    ":features:home:router",
    ":features:home:presentation",
    ":features:home:domain"
)