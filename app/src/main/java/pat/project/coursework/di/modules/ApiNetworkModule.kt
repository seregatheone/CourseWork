package pat.project.coursework.di.modules

import dagger.Module
import dagger.Provides
import pat.project.coursework.BuildConfig
import pat.project.coursework.data.provider.NetworkProvider
import pat.project.coursework.network.api.CartApi
import pat.project.coursework.network.api.HomeApi
import pat.project.coursework.network.api.ProductDetailsApi
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
    fun providesHomeApi(
        provider: NetworkProvider,
    ): HomeApi = provider.provideRetrofit(HomeApi::class.java)

    @Provides
    fun providesCartApi(
        provider: NetworkProvider,
    ): CartApi = provider.provideRetrofit(CartApi::class.java)

    @Provides
    fun providesProductDetailsApi(
        provider: NetworkProvider,
    ): ProductDetailsApi = provider.provideRetrofit(ProductDetailsApi::class.java)


}
