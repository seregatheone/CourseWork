package pat.project.coursework.cart.di

import dagger.Component
import pat.project.coursework.cart.ui.CartViewModel
import pat.project.coursework.dagger.FeatureScoped
import pat.project.coursework.dependency.Dependencies
import pat.project.coursework.interactor.CartInteractor


@FeatureScoped
@Component(
    dependencies = [CartDeps::class]
)
interface CartComponent {
    @Component.Builder
    interface Builder {
        fun cartDeps(deps: CartDeps): Builder
        fun build(): CartComponent
    }
    val cartViewModel: CartViewModel
}

interface CartDeps : Dependencies {
    val cartInteractor : CartInteractor
}
