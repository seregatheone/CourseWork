package pat.project.coursework.di.modules

import dagger.Module
import dagger.Provides
import pat.project.coursework.domain.interactors.HomeInteractorImpl
import pat.project.coursework.interactor.HomeInteractor
import pat.project.coursework.repository.HomeRepository

@Module
class InteractorsModule {
    @Provides
    fun providesHomeInteractor(
        homeRepository: HomeRepository
    ): HomeInteractor = HomeInteractorImpl(
        homeRepository
    )
}
