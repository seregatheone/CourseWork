package pat.project.coursework.ui.themes.typography

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle

data class AppTypography(
    val heavy : Heavy,
    val bold : Bold,
    val medium : Medium,
    val regular : Regular
)

data class Heavy(
    val sp30 : TextStyle
)

data class Bold(
    val sp12 : TextStyle,
    val sp16 : TextStyle,
    val sp25 : TextStyle
)

data class Medium(
    val sp12 : TextStyle,
    val sp15 : TextStyle,
)

data class Regular(
    val sp12 : TextStyle,
    val sp15 : TextStyle
)

val LocalAppTypography = staticCompositionLocalOf<AppTypography> {
    error("No AppTypography provided")
}