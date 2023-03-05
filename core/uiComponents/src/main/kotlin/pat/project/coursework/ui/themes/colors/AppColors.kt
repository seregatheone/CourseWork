package pat.project.coursework.ui.themes.colors

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


@Immutable
sealed class AppColors(
    val Orange: Color,
    val Blue: Color,
    val BackgroundWhite: Color,
    val WhiteTransparent25: Color,
    val White: Color,
    val GreyDust: Color,
    val GreyDustLight: Color,
    val GreyLight: Color,
    val GreyMedium: Color,
    val GreyDark: Color
) {
    class LightThemeAppColors : AppColors(
        Orange = ProjectOrange,
        Blue = ProjectBlue,
        BackgroundWhite = ProjectBackgroundWhite,
        White = ProjectWhite,
        WhiteTransparent25 = ProjectWhiteTransparent40,
        GreyDust = ProjectGreyDust,
        GreyDustLight = ProjectGreyDustLight,
        GreyLight = ProjectGreyLight,
        GreyMedium = ProjectGreyMedium,
        GreyDark = ProjectGrayDark
    )

    class DarkThemeAppColors : AppColors(
        Orange = ProjectOrange,
        Blue = ProjectBlue,
        BackgroundWhite = ProjectBackgroundWhite,
        White = ProjectWhite,
        WhiteTransparent25 = ProjectWhiteTransparent40,
        GreyDust = ProjectGreyDust,
        GreyDustLight = ProjectGreyDustLight,
        GreyLight = ProjectGreyLight,
        GreyMedium = ProjectGreyMedium,
        GreyDark = ProjectGrayDark
    )
}

fun appColors(darkTheme: Boolean): AppColors = when (darkTheme) {
    true -> AppColors.DarkThemeAppColors()
    false -> AppColors.LightThemeAppColors()
}

val LocalExtendedColors = staticCompositionLocalOf<AppColors> {
    error("No AppColors provided")
}