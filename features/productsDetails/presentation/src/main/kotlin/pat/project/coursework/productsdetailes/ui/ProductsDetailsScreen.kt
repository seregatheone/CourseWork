package pat.project.coursework.productsdetailes.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import pat.project.coursework.ui.components.buttons.ButtonBackgroundColors
import pat.project.coursework.ui.components.buttons.ButtonStyles
import pat.project.coursework.ui.components.buttons.CustomButton
import pat.project.coursework.ui.themes.AppResources
import pat.project.coursework.features.productsDetails.presentation.R
import pat.project.coursework.productsdetailes.ui.properties.PropertyItem
import pat.project.coursework.productsdetailes.ui.properties.PropertyItemUi
import pat.project.coursework.productsdetailes.ui.ratingbar.CustomRatingBar
import pat.project.coursework.productsdetailes.ui.tabrow.TabItemUi
import pat.project.coursework.productsdetailes.ui.tabrow.TabItems

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProductsDetailsScreen(
    productsDetailsViewModel: ProductsDetailsViewModel,
    navigateBack: () -> Unit
) {

    val tabItems = listOf(
        TabItems.Details(),
        TabItems.Shop(),
        TabItems.Features()
    )
    var selectedTabItem by remember { mutableStateOf(0) }

    val phoneDetailedData = productsDetailsViewModel.phoneDetailedData.collectAsState()

    val productProperties by remember(phoneDetailedData) {
        mutableStateOf(
            if (phoneDetailedData.value == null) emptyList()
            else listOf(
                PropertyItem(
                    propertyTitle = phoneDetailedData.value?.cPU ?: "",
                    propertyIcon = Icons.Outlined.Memory
                ),
                PropertyItem(
                    propertyTitle = phoneDetailedData.value?.camera ?: "",
                    propertyIcon = Icons.Outlined.PhotoCamera
                ),
                PropertyItem(
                    propertyTitle = phoneDetailedData.value?.ssd ?: "",
                    propertyIcon = Icons.Outlined.Storage
                ),
                PropertyItem(
                    propertyTitle = phoneDetailedData.value?.sd ?: "",
                    propertyIcon = Icons.Outlined.SdStorage
                )
            )
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppResources.colors.BackgroundWhite)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomButton(
                onClick = {
                    navigateBack()
                },
                buttonStyle = ButtonStyles.CustomIconButton(
                    buttonBackgroundColors = ButtonBackgroundColors.BLUE,
                    buttonIcon = Icons.Outlined.ArrowBackIos
                )
            )

            Text(
                text = stringResource(id = R.string.product_details),
                style = AppResources.typography.medium.sp18.copy(color = AppResources.colors.Blue)
            )

            CustomButton(
                onClick = {}, buttonStyle =
                ButtonStyles.CustomIconButton(
                    buttonBackgroundColors = ButtonBackgroundColors.Orange,
                    buttonIcon = Icons.Outlined.ShoppingBag
                )
            )
        }

        val photos = phoneDetailedData.value?.images ?: emptyList()
        HorizontalPager(count = photos.size) { currentImage ->
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(photos[currentImage])
                        .build(),
                    placeholder = ColorPainter(AppResources.colors.GreyLight),
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }
        Surface(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            color = AppResources.colors.White,
            shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
        ) {
            Column(modifier = Modifier.padding(horizontal = 30.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 37.dp, vertical = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column() {
                        Text(
                            text = phoneDetailedData.value?.title ?: "",
                            style = AppResources.typography.medium.sp24.copy(
                                color = AppResources.colors.Blue
                            )
                        )
                        CustomRatingBar(
                            modifier = Modifier.padding(top = 6.dp),
                            starWidth = 18.dp,
                            starHeight = 18.dp,
                            endPadding = 8.dp,
                            rating = phoneDetailedData.value?.rating ?: 0f
                        )
                    }
                    CustomButton(
                        onClick = { },
                        buttonStyle = ButtonStyles.CustomIconButton(
                            buttonBackgroundColors = ButtonBackgroundColors.BLUE,
                            buttonIcon = Icons.Outlined.FavoriteBorder
                        )
                    )
                }
                TabRow(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    selectedTabIndex = selectedTabItem,
                    backgroundColor = AppResources.colors.White,
                    indicator = {
                        TabRowDefaults.Indicator(
                            modifier = Modifier
                                .tabIndicatorOffset(it[selectedTabItem])
                                .clip(RoundedCornerShape(3.dp)),
                            color = AppResources.colors.Orange,
                            height = 3.dp
                        )
                    },
                    divider = {
                    }
                ) {
                    tabItems.forEachIndexed { index, currentTab ->
                        TabItemUi(
                            isSelected = selectedTabItem == index,
                            tabItems = currentTab,
                            onTabClicked = {
                                selectedTabItem = index
                            }
                        )
                    }

                }
                FlowRow() {
                    //тут плохой вариант реализации бэкенда и api
                    productProperties.forEach { propertyItem ->
                        PropertyItemUi(propertyItem = propertyItem)
                    }
                }
                Text(
                    modifier = Modifier.padding(top = 24.dp),
                    text = stringResource(id = R.string.select_color_and_capacity),
                    style = AppResources.typography.medium.sp15.copy(color = AppResources.colors.Blue)
                )

                FlowRow() {

                }

                CustomButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    onClick = { },
                    buttonStyle = ButtonStyles.FullCustomButton(
                        buttonBackgroundColors = ButtonBackgroundColors.Orange,
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = stringResource(id = R.string.add_to_cart),
                                style = AppResources.typography.bold.sp20.copy(
                                    color = AppResources.colors.White
                                )
                            )
                            Text(
                                text = "$${phoneDetailedData.value?.price ?: 0}",
                                style = AppResources.typography.bold.sp20.copy(
                                    color = AppResources.colors.White
                                )
                            )
                        }
                    }
                )
            }
        }
    }
}