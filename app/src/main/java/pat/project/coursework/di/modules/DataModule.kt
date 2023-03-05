package pat.project.coursework.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import pat.project.coursework.data.repository.HomeRepositoryImpl
import pat.project.coursework.network.api.HomeApi
import pat.project.coursework.repository.HomeRepository

@Module(includes = [ApiNetworkModule::class])
class DataModule {
    @Provides
    fun providesHomeRepository(
        api: HomeApi
    ): HomeRepository = HomeRepositoryImpl(
        api
    )
}
