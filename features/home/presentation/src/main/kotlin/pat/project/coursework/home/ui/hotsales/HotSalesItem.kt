package pat.project.coursework.home.ui.hotsales

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import pat.project.coursework.features.home.presentation.R
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import pat.project.coursework.home.ui.model.HotSalesDataModel
import pat.project.coursework.ui.themes.AppResources

@Composable
fun HotSalesItem(hotSalesDataModel: HotSalesDataModel) {
    Box(modifier = Modifier.clip(shape = RoundedCornerShape(12.dp))) {
        Image(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(hotSalesDataModel.pictureUrl)
                    .build(),
                placeholder = ColorPainter(AppResources.colors.GreyLight),
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Box(
            modifier = Modifier
                .height(200.dp)
                .padding(
                    start = 24.dp,
                    top = 14.dp,
                    bottom = 26.dp
                )
        ) {
            if (hotSalesDataModel.isNew) {
                Surface(
                    modifier = Modifier
                        .size(27.dp)
                        .align(Alignment.TopStart),
                    color = AppResources.colors.Orange,
                    shape = CircleShape
                ) {
                    Icon(
                        modifier = Modifier
                            .size(27.dp)
                            .padding(3.dp),
                        painter = painterResource(id = R.drawable.new_icon),
                        contentDescription = stringResource(id = R.string.new_marker_text),
                        tint = AppResources.colors.White
                    )
                }
            }

            Column(modifier = Modifier.align(Alignment.CenterStart)) {

                Text(
                    modifier = Modifier.padding(bottom = 5.dp),
                    text = hotSalesDataModel.title,
                    style = AppResources.typography.bold.sp25.copy(
                        color = AppResources.colors.White
                    )
                )
                Text(
                    text = hotSalesDataModel.subtitle,
                    style = AppResources.typography.regular.sp12.copy(
                        color = AppResources.colors.White
                    )
                )

            }

            Row(
                modifier = Modifier
                    .clickable(true) {}
                    .align(Alignment.BottomStart)
                    .clip(shape = RoundedCornerShape(6.dp))
                    .background(AppResources.colors.White)
                    .size(width = 100.dp, height = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                BasicText(
                    modifier = Modifier,
                    style = AppResources.typography.bold.sp12.copy(
                        color = AppResources.colors.Blue
                    ),
                    text = stringResource(id = R.string.buy_now_text)
                )
            }

        }


    }
}