package pat.project.coursework.home.ui.bestseller

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import pat.project.coursework.features.home.presentation.R
import pat.project.coursework.home.ui.model.BestSellerDataModel
import pat.project.coursework.ui.themes.AppResources

@Composable
fun BestSellerItem(bestSellerDataModel: BestSellerDataModel) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(AppResources.colors.White)

    ) {
        Column() {
            Image(
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .size(200.dp),
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(bestSellerDataModel.pictureUrl)
                        .build(),
                    placeholder = ColorPainter(AppResources.colors.GreyLight),
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Column(modifier = Modifier.padding(start = 20.dp)) {
                Row(verticalAlignment = Alignment.Bottom) {
                    Text(
                        text = "$${bestSellerDataModel.priceWithoutDiscount}",
                        color = AppResources.colors.Blue,
                        style = AppResources.typography.bold.sp16
                    )
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = "$${bestSellerDataModel.discountPrice}",
                        color = AppResources.colors.GreyDust,
                        style = AppResources.typography.regular.sp12.copy(textDecoration = TextDecoration.LineThrough)
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 6.dp, bottom = 16.dp),
                    text = bestSellerDataModel.title,
                    color = AppResources.colors.Blue,
                    style = AppResources.typography.regular.sp12
                )
            }

        }

        Surface(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(12.dp)
                .size(26.dp),
            shape = CircleShape,
            shadowElevation = 1.dp,
            color = AppResources.colors.White
        ) {
            Icon(
                modifier = Modifier
                    .size(25.dp)
                    .padding(4.dp),
                imageVector = if (bestSellerDataModel.isFavorites) Icons.Outlined.Favorite
                else Icons.Outlined.FavoriteBorder,
                tint = AppResources.colors.Orange,
                contentDescription = stringResource(id = R.string.favorite_icon_description),
            )
        }

    }
}