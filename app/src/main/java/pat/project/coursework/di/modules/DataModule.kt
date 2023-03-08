package pat.project.coursework.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import pat.project.coursework.data.repository.CartRepositoryImpl
import pat.project.coursework.data.repository.HomeRepositoryImpl
import pat.project.coursework.data.repository.ProductDetailsRepositoryImpl
import pat.project.coursework.domain.interactors.ProductDetailsInteractorImpl
import pat.project.coursework.network.api.CartApi
import pat.project.coursework.network.api.HomeApi
import pat.project.coursework.network.api.ProductDetailsApi
import pat.project.coursework.repository.CartRepository
import pat.project.coursework.repository.HomeRepository
import pat.project.coursework.repository.ProductDetailedRepository

@Module(includes = [ApiNetworkModule::class])
class DataModule {
    @Provides
    fun providesHomeRepository(
        api: HomeApi
    ): HomeRepository = HomeRepositoryImpl(
        api
    )

    @Provides
    fun providesCartRepository(
        api: CartApi
    ): CartRepository = CartRepositoryImpl(
        api
    )

    @Provides
    fun providesProductDetailsRepository(
        api: ProductDetailsApi
    ): ProductDetailedRepository = ProductDetailsRepositoryImpl(
        api
    )
}
