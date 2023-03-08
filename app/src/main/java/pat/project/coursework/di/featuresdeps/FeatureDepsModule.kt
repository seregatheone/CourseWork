package pat.project.coursework.di.featuresdeps


import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pat.project.coursework.cart.di.CartDeps
import pat.project.coursework.dagger.DependenciesKey
import pat.project.coursework.dependency.Dependencies
import pat.project.coursework.di.AppComponent
import pat.project.coursework.home.di.HomeDeps
import pat.project.coursework.productsdetailes.di.ProductsDetailsDeps

@Module
interface FeatureDepsModule {
    @Binds
    @IntoMap
    @DependenciesKey(HomeDeps::class)
    fun bindHomeDeps(impl: AppComponent): Dependencies

    @Binds
    @IntoMap
    @DependenciesKey(CartDeps::class)
    fun bindCartDeps(impl: AppComponent): Dependencies

    @Binds
    @IntoMap
    @DependenciesKey(ProductsDetailsDeps::class)
    fun bindProductsDetailsDeps(impl: AppComponent): Dependencies
}