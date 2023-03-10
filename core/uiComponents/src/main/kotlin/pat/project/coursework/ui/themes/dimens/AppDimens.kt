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
    val textSize12: TextUnit,
    val textSize15: TextUnit,
    val textSize16: TextUnit,
    val textSize18: TextUnit,
    val textSize20: TextUnit,
    val textSize24: TextUnit,
    val textSize25: TextUnit,
    val textSize30: TextUnit,
    val textSize35: TextUnit,
)

//data class LetterSpacing(
//    val letterSpacingSize48: TextUnit,
//)
//
//data class LineHeight(
//    val lineHeightSize48: TextUnit,

//)


internal val regularTextSizes = TextSizes(
    textSize12 = 12.sp,
    textSize15 = 15.sp,
    textSize16 = 16.sp,
    textSize18 = 18.sp,
    textSize20 = 20.sp,
    textSize25 = 25.sp,
    textSize24 = 24.sp,
    textSize30 = 30.sp,
    textSize35 = 35.sp
)

//internal val regularLetterSpacings = LetterSpacing(
//    letterSpacingSize48 = 0.5.sp,
//    letterSpacingSize008 = 0.08.sp
//)
//
//internal val regularLineHeights = LineHeight(
//    lineHeightSize48 = 48.sp,

//)

