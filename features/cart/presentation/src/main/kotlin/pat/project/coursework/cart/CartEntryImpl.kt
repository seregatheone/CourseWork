package pat.project.coursework.cart

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import pat.project.coursework.dependency.findDependencies
import pat.project.coursework.dependency.injectedViewModel
import pat.project.coursework.router.Destinations
import javax.inject.Inject

class CartEntryImpl @Inject constructor() : CartEntry() {

    @Composable
    override fun Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        val context = LocalContext.current
//        val viewModel = injectedViewModel {
//            DaggerHomeComponent.builder()
//                .homeDeps((context as Activity).findDependencies())
//                .build()
//                .homeViewModel
//        }
    }
}