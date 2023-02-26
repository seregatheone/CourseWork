package pat.project.coursework.ui.themes

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import pat.project.coursework.ui.themes.animations.LocalAnimationsProvider
import pat.project.coursework.ui.themes.animations.StandardAnimations
import pat.project.coursework.ui.themes.colors.AppColors
import pat.project.coursework.ui.themes.colors.LocalExtendedColors
import pat.project.coursework.ui.themes.colors.appColors
import pat.project.coursework.ui.themes.dimens.AppDimens
import pat.project.coursework.ui.themes.dimens.LocalAppDimens
import pat.project.coursework.ui.themes.dimens.appDimens
import pat.project.coursework.ui.themes.typography.AppTypography
import pat.project.coursework.ui.themes.typography.LocalAppTypography
import pat.project.coursework.ui.themes.typography.appTypography


object AppResources {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalExtendedColors.current

    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalAppTypography.current

    val dimens: AppDimens
        @Composable
        @ReadOnlyComposable
        get() = LocalAppDimens.current

    val animations: StandardAnimations
        @Composable
        @ReadOnlyComposable
        get() = LocalAnimationsProvider.current
}

@Composable
fun CourseWorkTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = true
        )
    }
    val dimensions: AppDimens = appDimens()
    val ourColors: AppColors = appColors(darkTheme)
    val appTypography: AppTypography = appTypography(dimensions)

    MaterialTheme(
        colorScheme = if(darkTheme){
            darkColorScheme().copy(surface = ourColors.BackgroundWhite)
        }else{
            lightColorScheme().copy(surface = ourColors.BackgroundWhite)
        }
    ) {
        CompositionLocalProvider(
            LocalExtendedColors provides ourColors,
            LocalAppTypography provides appTypography,
            LocalAppDimens provides dimensions,
            LocalAnimationsProvider provides StandardAnimations,
            content = content
        )

    }

}