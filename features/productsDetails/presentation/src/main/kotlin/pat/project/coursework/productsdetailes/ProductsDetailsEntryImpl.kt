package pat.project.coursework.productsdetailes

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import pat.project.coursework.detailsrouter.ProductsDetailsEntry
import pat.project.coursework.router.Destinations
import javax.inject.Inject

class ProductsDetailsEntryImpl @Inject constructor() : ProductsDetailsEntry() {

    @Composable
    override fun Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {

    }
}