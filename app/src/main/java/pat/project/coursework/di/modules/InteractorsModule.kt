package pat.project.coursework.di.modules

import dagger.Module
import dagger.Provides
import pat.project.coursework.domain.interactors.CartInteractorImpl
import pat.project.coursework.domain.interactors.HomeInteractorImpl
import pat.project.coursework.domain.interactors.ProductDetailsInteractorImpl
import pat.project.coursework.interactor.CartInteractor
import pat.project.coursework.interactor.HomeInteractor
import pat.project.coursework.interactor.ProductDetailedInteractor
import pat.project.coursework.repository.CartRepository
import pat.project.coursework.repository.HomeRepository
import pat.project.coursework.repository.ProductDetailedRepository

@Module
class InteractorsModule {
    @Provides
    fun providesHomeInteractor(
        homeRepository: HomeRepository
    ): HomeInteractor = HomeInteractorImpl(
        homeRepository
    )

    @Provides
    fun providesCartInteractor(
        cartRepository: CartRepository
    ): CartInteractor = CartInteractorImpl(
        cartRepository
    )

    @Provides
    fun providesProductDetailsInteractor(
        productDetailedRepository: ProductDetailedRepository
    ): ProductDetailedInteractor = ProductDetailsInteractorImpl(
        productDetailedRepository
    )
}
