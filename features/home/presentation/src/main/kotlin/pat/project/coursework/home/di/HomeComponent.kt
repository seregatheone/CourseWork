package pat.project.coursework.home.di

import dagger.Component
import pat.project.coursework.dagger.FeatureScoped
import pat.project.coursework.dependency.Dependencies
import pat.project.coursework.home.ui.HomeViewModel

@FeatureScoped
@Component(
    dependencies = [HomeDeps::class]
)
interface HomeComponent {
    @Component.Builder
    interface Builder {
        fun homeDeps(deps: HomeDeps): Builder
        fun build(): HomeComponent
    }
    val homeViewModel: HomeViewModel
}

interface HomeDeps : Dependencies {
}
