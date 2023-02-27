package pat.project.coursework.application

import android.app.Application
import pat.project.coursework.dependency.DepsMap
import pat.project.coursework.dependency.HasDependencies
import pat.project.coursework.di.DaggerAppComponent
import pat.project.coursework.router.Destinations
import javax.inject.Inject

class CourseWorkApplication : Application(), HasDependencies {
    @Inject
    override lateinit var depsMap: DepsMap

    @Inject
    override lateinit var depsNav: Destinations

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }
}