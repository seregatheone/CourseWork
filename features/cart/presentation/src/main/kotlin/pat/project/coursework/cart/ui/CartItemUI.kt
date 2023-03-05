package pat.project.coursework.cart.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import pat.project.coursework.entity.CartItems
import pat.project.coursework.ui.themes.AppResources

@Composable
fun CartItemUI(cartItem: CartItems) {
    Row() {
        Image(
            modifier = Modifier
                .size(90.dp),
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(cartItem.pictureUrl)
                    .build(),
                placeholder = ColorPainter(AppResources.colors.GreyLight),
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }

}