package pat.project.coursework.home

import android.app.Activity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import pat.project.coursework.cart.CartEntry
import pat.project.coursework.dependency.findDependencies
import pat.project.coursework.dependency.injectedViewModel
import pat.project.coursework.detailsrouter.ProductsDetailsEntry
import pat.project.coursework.home.di.DaggerHomeComponent
import pat.project.coursework.home.ui.HomeScreen
import pat.project.coursework.homerouter.HomeEntry
import pat.project.coursework.router.Destinations
import pat.project.coursework.router.find
import pat.project.coursework.ui.themes.colors.LocalExtendedColors
import javax.inject.Inject

class HomeEntryImpl @Inject constructor() : HomeEntry() {

    @Composable
    override fun Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {

        val context = LocalContext.current
        val viewModel = injectedViewModel {
            DaggerHomeComponent.builder()
                .homeDeps((context as Activity).findDependencies())
                .build()
                .homeViewModel
        }

        val navigateToCart = {
            val destination = destinations
                .find<CartEntry>()
                .destination()
            navController.navigate(destination)
        }

        val navigateToProductDetails = {
            val destination = destinations
                .find<ProductsDetailsEntry>()
                .destination()
            navController.navigate(destination)
        }

        HomeScreen(
            homeViewModel = viewModel,
            navigateToCart = navigateToCart,
            navigateToProductsDetails = navigateToProductDetails
        )

    }
}