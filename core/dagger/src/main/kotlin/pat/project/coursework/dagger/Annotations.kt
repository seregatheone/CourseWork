package pat.project.coursework.dagger


import dagger.MapKey
import pat.project.coursework.router.FeatureEntry
import pat.project.coursework.dependency.Dependencies
import javax.inject.Scope
import kotlin.reflect.KClass

@MapKey
annotation class DependenciesKey(val value: KClass<out Dependencies>)

@MapKey
annotation class FeatureEntryKey(val value: KClass<out FeatureEntry>)




@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FeatureScoped

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SubfeatureScoped