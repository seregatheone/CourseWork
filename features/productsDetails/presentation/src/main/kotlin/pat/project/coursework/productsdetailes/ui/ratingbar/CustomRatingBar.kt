package pat.project.coursework.productsdetailes.ui.ratingbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import pat.project.coursework.features.productsDetails.presentation.R

@Composable
fun CustomRatingBar(
    modifier: Modifier = Modifier,
    starWidth: Dp,
    starHeight: Dp,
    endPadding: Dp,
    rating: Float
) {
    val ratingFull = ImageVector.vectorResource(id = R.drawable.star_icon)
    val totalWidth = starWidth * 5 + endPadding * 4

    val space = LocalDensity.current.run { endPadding.toPx() }


    val imagePainterFull = rememberVectorPainter(image = ratingFull)

    Box(
        modifier
            .width(totalWidth)
            .height(starHeight)
            .drawBehind {
                drawRating(
                    rating,
                    imagePainterFull = imagePainterFull,
                    starWidthDp = starWidth,
                    starHeightDp = starHeight,
                    space
                )
            })

}

private fun DrawScope.drawRating(
    rating: Float,
    imagePainterFull: VectorPainter,
    starWidthDp: Dp,
    starHeightDp: Dp,
    space: Float
) {

    val totalCount = 5

    val reminder = rating - rating.toInt()
    val ratingInt = (rating - reminder).toInt()


    val starWidthPx = starWidthDp.toPx()
    val starHeightPx = starHeightDp.toPx()


    drawWithLayer {
        for (i in 0 until totalCount) {
            val start = starWidthPx * i + space * i
            // Destination
            with(imagePainterFull) {
                translate(
                    left = start,
                    top = 0f
                ) {
                    draw(
                        size = Size(starWidthPx, starHeightPx)
                    )
                }

            }
        }

        val end = starWidthPx * totalCount + space * (totalCount - 1)
        val start = rating * starWidthPx + ratingInt * space
        val size = end - start

        // Source
        drawRect(
            Color.Transparent,
            topLeft = Offset(start, 0f),
            size = Size(size, height = starHeightPx),
            blendMode = BlendMode.SrcIn
        )
    }
}

private fun DrawScope.drawWithLayer(block: DrawScope.() -> Unit) {
    with(drawContext.canvas.nativeCanvas) {
        val checkPoint = saveLayer(null, null)
        block()
        restoreToCount(checkPoint)
    }
}