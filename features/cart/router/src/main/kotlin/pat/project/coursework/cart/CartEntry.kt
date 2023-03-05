package pat.project.coursework.cart

import pat.project.coursework.router.ComposableFeatureEntry

abstract class CartEntry : ComposableFeatureEntry {

    final override val featureRoute = "cart"

    fun destination(): String = featureRoute

}