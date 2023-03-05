package pat.project.coursework.detailsrouter

import pat.project.coursework.router.ComposableFeatureEntry

abstract class ProductsDetailsEntry : ComposableFeatureEntry {

    final override val featureRoute = "productDetails"

    fun destination(): String = featureRoute

}