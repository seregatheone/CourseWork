package pat.project.coursework

import android.app.Activity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import pat.project.coursework.cart.CartEntry
import pat.project.coursework.dependency.destinationsProvider
import pat.project.coursework.dependency.findDestinations
import pat.project.coursework.detailsrouter.ProductsDetailsEntry
import pat.project.coursework.homerouter.HomeEntry
import pat.project.coursework.ui.themes.AppResources

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation() {
    val navController = rememberAnimatedNavController()
    val context = (LocalContext.current as Activity)

    val homeScreen = context.findDestinations<HomeEntry>()
    val cartScreen = context.findDestinations<CartEntry>()
    val productsDetailsScreen = context.findDestinations<ProductsDetailsEntry>()

    val standardEnterTransaction = AppResources.animations.standardEnterTransaction
    val standardExitTransition = AppResources.animations.standardExitTransition
    val standardPopEnterTransition = AppResources.animations.standardPopEnterTransition

    Box(
        Modifier
            .fillMaxSize()
            .background(AppResources.colors.BackgroundWhite)
    ) {
        AnimatedNavHost(navController, startDestination = homeScreen.destination()) {
            with(homeScreen) {
                animatedComposable(
                    navController,
                    context.destinationsProvider,
                    enterTransition = { standardEnterTransaction },
                    exitTransition = { standardExitTransition },
                    popEnterTransition = { standardPopEnterTransition }
                )
            }

            with(cartScreen) {
                animatedComposable(
                    navController,
                    context.destinationsProvider,
                    enterTransition = { standardEnterTransaction },
                    exitTransition = { standardExitTransition },
                    popEnterTransition = { standardPopEnterTransition }
                )
            }

            with(productsDetailsScreen) {
                animatedComposable(
                    navController,
                    context.destinationsProvider,
                    enterTransition = { standardEnterTransaction },
                    exitTransition = { standardExitTransition },
                    popEnterTransition = { standardPopEnterTransition }
                )
            }

        }
    }
}
