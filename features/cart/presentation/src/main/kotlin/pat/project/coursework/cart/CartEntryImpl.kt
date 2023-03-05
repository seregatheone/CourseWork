package pat.project.coursework.cart

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import pat.project.coursework.router.Destinations
import javax.inject.Inject

class CartEntryImpl @Inject constructor() : CartEntry() {

    @Composable
    override fun Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {

    }
}