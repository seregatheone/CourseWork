package pat.project.coursework.productsdetailes.di

import dagger.Component
import pat.project.coursework.dagger.FeatureScoped
import pat.project.coursework.dependency.Dependencies
import pat.project.coursework.productsdetailes.ui.ProductsDetailsViewModel

@FeatureScoped
@Component(
    dependencies = [ProductsDetailsDeps::class]
)
interface ProductsDetailsComponent {
    @Component.Builder
    interface Builder {
        fun productsDetailsDeps(deps: ProductsDetailsDeps): Builder
        fun build(): ProductsDetailsComponent
    }
    val productsDetailsViewModel: ProductsDetailsViewModel
}

interface ProductsDetailsDeps : Dependencies {
}
