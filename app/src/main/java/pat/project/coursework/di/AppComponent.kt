package pat.project.coursework.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import pat.project.coursework.application.CourseWorkApplication
import pat.project.coursework.di.featuresdeps.FeatureDepsModule
import pat.project.coursework.di.navigation.NavigationModule
import pat.project.coursework.home.di.HomeDeps
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope

@AppScope
@Component(
    modules = [
        AppModule::class,
        FeatureDepsModule::class,
        NavigationModule::class,
    ]
)
interface AppComponent :
    HomeDeps
{
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(application: CourseWorkApplication)
}

@Module
class AppModule {
    @AppScope
    @Provides
    fun provideContext(
        application: Application
    ): Context = application.applicationContext
}
