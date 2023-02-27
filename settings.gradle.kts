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

    ":core:dagger",
    ":core:dependency",
    ":core:uiComponents",

    ":common:router",

    ":features:home:router",
    ":features:home:presentation"
)