package pat.project.coursework.di.navigation

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pat.project.coursework.cart.CartEntry
import pat.project.coursework.cart.CartEntryImpl
import pat.project.coursework.dagger.FeatureEntryKey
import pat.project.coursework.detailsrouter.ProductsDetailsEntry
import pat.project.coursework.home.HomeEntryImpl
import pat.project.coursework.homerouter.HomeEntry
import pat.project.coursework.productsdetailes.ProductsDetailsEntryImpl
import pat.project.coursework.router.FeatureEntry

@Module
interface NavigationModule {
    @Binds
    @IntoMap
    @FeatureEntryKey(HomeEntry::class)
    fun homeEntry(entry: HomeEntryImpl): FeatureEntry

    @Binds
    @IntoMap
    @FeatureEntryKey(ProductsDetailsEntry::class)
    fun productsDetailsEntry(entry: ProductsDetailsEntryImpl): FeatureEntry

    @Binds
    @IntoMap
    @FeatureEntryKey(CartEntry::class)
    fun cartEntry(entry: CartEntryImpl): FeatureEntry
}