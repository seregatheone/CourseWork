package pat.project.coursework.ui.themes.typography

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import pat.project.coursework.core.uiComponents.R
import pat.project.coursework.ui.themes.dimens.AppDimens


fun appTypography(dims: AppDimens): AppTypography = AppTypography(

    heavy = Heavy(
        sp30 = TextStyle(
            fontFamily = AppFontFamilies.MarkPro,
            fontWeight = FontWeight.W800,
            fontSize = dims.textSizes.textSize30
        )
    ),
    bold = Bold(
        sp12 = TextStyle(
            fontFamily = AppFontFamilies.MarkPro,
            fontWeight = FontWeight.W700,
            fontSize = dims.textSizes.textSize12
        ),
        sp15 = TextStyle(
            fontFamily = AppFontFamilies.MarkPro,
            fontWeight = FontWeight.W700,
            fontSize = dims.textSizes.textSize15
        ),
        sp16 = TextStyle(
            fontFamily = AppFontFamilies.MarkPro,
            fontWeight = FontWeight.W700,
            fontSize = dims.textSizes.textSize16
        ),
        sp25 = TextStyle(
            fontFamily = AppFontFamilies.MarkPro,
            fontWeight = FontWeight.W700,
            fontSize = dims.textSizes.textSize25
        )
    ),
    medium = Medium(

        sp12 = TextStyle(
            fontFamily = AppFontFamilies.MarkPro,
            fontWeight = FontWeight.W500,
            fontSize = dims.textSizes.textSize12
        ),
        sp15 = TextStyle(
            fontFamily = AppFontFamilies.MarkPro,
            fontWeight = FontWeight.W500,
            fontSize = dims.textSizes.textSize15
        ),
        sp18 = TextStyle(
            fontFamily = AppFontFamilies.MarkPro,
            fontWeight = FontWeight.W500,
            fontSize = dims.textSizes.textSize18
        ),
    ),

    regular = Regular(
        sp12 = TextStyle(
            fontFamily = AppFontFamilies.MarkPro,
            fontWeight = FontWeight.W400,
            fontSize = dims.textSizes.textSize12
        ),
        sp15 = TextStyle(
            fontFamily = AppFontFamilies.MarkPro,
            fontWeight = FontWeight.W400,
            fontSize = dims.textSizes.textSize15
        ),
        sp18 = TextStyle(
            fontFamily = AppFontFamilies.MarkPro,
            fontWeight = FontWeight.W400,
            fontSize = dims.textSizes.textSize18
        )
    )
)


@Immutable
object AppFontFamilies {
    @Stable
    val MarkPro = FontFamily(
        Font(resId = R.font.markpro_heavy, weight = FontWeight.W800, style = FontStyle.Normal),
        Font(resId = R.font.markpro_bold, weight = FontWeight.W700, style = FontStyle.Normal),
        Font(resId = R.font.markpro_medium, weight = FontWeight.W500, style = FontStyle.Normal),
        Font(resId = R.font.markpro_light, weight = FontWeight.W400, style = FontStyle.Normal),
    )
}