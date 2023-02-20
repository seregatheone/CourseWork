package pat.project.coursework.dependency

import pat.project.coursework.router.Destinations


interface Dependencies

typealias DepsMap = Map<Class<out Dependencies>, @JvmSuppressWildcards Dependencies>

interface HasDependencies {
    val depsMap: DepsMap
    val depsNav: Destinations
}

//val LocalProvider = compositionLocalOf<DepsMap> { error("No app provider found!") }