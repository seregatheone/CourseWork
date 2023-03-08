package pat.project.coursework.homerouter

import pat.project.coursework.router.ComposableFeatureEntry

abstract class HomeEntry : ComposableFeatureEntry {

    final override val featureRoute = "home"

    fun destination(): String = featureRoute

}