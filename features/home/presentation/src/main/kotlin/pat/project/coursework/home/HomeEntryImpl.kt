package pat.project.coursework.home

import android.app.Activity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import pat.project.coursework.dependency.findDependencies
import pat.project.coursework.dependency.injectedViewModel
import pat.project.coursework.home.ui.HomeScreen
import pat.project.coursework.homerouter.HomeEntry
import pat.project.coursework.router.Destinations
import javax.inject.Inject

class HomeEntryImpl @Inject constructor() : HomeEntry() {

    @OptIn(ExperimentalAnimationApi::class, ExperimentalPagerApi::class)
    @Composable
    override fun Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {

        val context = LocalContext.current
//        val viewModel = injectedViewModel {
//            DaggerHomeComponent.builder()
//                .onBoardingDeps((context as Activity).findDependencies())
//                .build()
//                .onBoardingViewModel
//        }
//        HomeScreen(
//            homeViewModel = viewModel
//        )

    }
}