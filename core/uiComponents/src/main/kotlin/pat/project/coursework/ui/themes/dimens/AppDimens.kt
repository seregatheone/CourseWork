package pat.project.coursework.ui.themes.dimens


import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

val LocalAppDimens = staticCompositionLocalOf<AppDimens> {
    error("No AppDims provided")
}

// Если с дизайном будут несостыковки, то нужно будет ввести больше параметров таких как letterSpacings и lineHeights

fun appDimens() = AppDimens(
    textSizes = regularTextSizes,
//    letterSpacings = regularLetterSpacings,
//    lineHeights = regularLineHeights,
)

@Immutable
data class AppDimens(
    val textSizes: TextSizes,
//    val letterSpacings : LetterSpacing,
//    val lineHeights : LineHeight,
)

data class TextSizes(
    val textSize30: TextUnit,
    val textSize25: TextUnit,
    val textSize15: TextUnit,
)

//data class LetterSpacing(
//    val letterSpacingSize48: TextUnit,
//)
//
//data class LineHeight(
//    val lineHeightSize48: TextUnit,

//)


internal val regularTextSizes = TextSizes(
    textSize30 = 30.sp,
    textSize25 = 25.sp,
    textSize15 = 15.sp

)

//internal val regularLetterSpacings = LetterSpacing(
//    letterSpacingSize48 = 0.5.sp,
//    letterSpacingSize008 = 0.08.sp
//)
//
//internal val regularLineHeights = LineHeight(
//    lineHeightSize48 = 48.sp,

//)

