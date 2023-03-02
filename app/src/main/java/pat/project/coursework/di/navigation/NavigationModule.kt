package pat.project.coursework.di.navigation

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import pat.project.coursework.dagger.FeatureEntryKey
import pat.project.coursework.home.HomeEntryImpl
import pat.project.coursework.homerouter.HomeEntry
import pat.project.coursework.router.FeatureEntry

@Module
interface NavigationModule {
    @Binds
    @IntoMap
    @FeatureEntryKey(HomeEntry::class)
    fun splashscreenEntry(entry: HomeEntryImpl): FeatureEntry
}