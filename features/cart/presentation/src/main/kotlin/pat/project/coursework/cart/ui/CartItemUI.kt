package pat.project.coursework.cart.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Remove
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
    Row(
        modifier = Modifier
            .padding(start = 12.dp, top = 32.dp, bottom = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(90.dp)
                .clip(RoundedCornerShape(12.dp)),
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(cartItem.pictureUrl)
                    .build(),
                placeholder = ColorPainter(AppResources.colors.GreyLight),
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 24.dp)
        ) {
            Text(
                text = cartItem.title,
                style = AppResources.typography.medium.sp20.copy(
                    color = AppResources.colors.White
                )
            )
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = "$${cartItem.price}.00",
                style = AppResources.typography.medium.sp20.copy(
                    color = AppResources.colors.Orange
                )
            )
        }

        Surface(
            shape = RoundedCornerShape(26.dp),
            color = AppResources.colors.GreyDarkLight
        ) {
            Column(
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 4.dp, end = 4.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier.size(
                        16.dp
                    ),
                    imageVector = Icons.Rounded.Remove,
                    tint = AppResources.colors.White,
                    contentDescription = null
                )

                Text(
                    text = "1",
                    style = AppResources.typography.medium.sp20.copy(
                        color = AppResources.colors.White
                    )
                )

                Icon(
                    modifier = Modifier.size(
                        16.dp
                    ),
                    imageVector = Icons.Rounded.Add,
                    tint = AppResources.colors.White,
                    contentDescription = null
                )

            }

        }

        Icon(
            modifier = Modifier
                .padding(start = 12.dp)
                .size(
                    24.dp
                ),
            imageVector = Icons.Outlined.Delete,
            tint = AppResources.colors.GreyDarkDark,
            contentDescription = null
        )
    }

}