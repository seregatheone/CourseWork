package pat.project.coursework.productsdetailes

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import pat.project.coursework.dependency.findDependencies
import pat.project.coursework.dependency.injectedViewModel
import pat.project.coursework.detailsrouter.ProductsDetailsEntry
import pat.project.coursework.productsdetailes.di.DaggerProductsDetailsComponent
import pat.project.coursework.productsdetailes.ui.ProductsDetailsScreen
import pat.project.coursework.router.Destinations
import javax.inject.Inject

class ProductsDetailsEntryImpl @Inject constructor() : ProductsDetailsEntry() {

    @Composable
    override fun Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        val context = LocalContext.current
        val viewModel = injectedViewModel {
            DaggerProductsDetailsComponent.builder()
//                .productsDetailsDeps((context as Activity).findDependencies())
                .build()
                .productsDetailsViewModel
        }

        ProductsDetailsScreen(productsDetailsViewModel = viewModel)
    }
}