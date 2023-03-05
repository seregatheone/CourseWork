package pat.project.coursework.di.modules

import dagger.Module
import dagger.Provides
import pat.project.coursework.BuildConfig
import pat.project.coursework.data.provider.NetworkProvider
import pat.project.coursework.network.api.HomeApi
import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class BackendCourseWork


@Module
class ApiNetworkModule {

    @Provides
    @BackendCourseWork
    fun providersUrlBackendAdvocall(): String = BuildConfig.BACKEND_COURSE_WORK

    @Provides
    fun providesNetworkProvider(
        @BackendCourseWork host: String,
    ): NetworkProvider = NetworkProvider(
        host
    )
    @Provides
    fun providesProfileApi(
        provider: NetworkProvider,
    ): HomeApi = provider.provideRetrofit(HomeApi::class.java)


}
