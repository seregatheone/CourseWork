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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
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
import pat.project.coursework.productsdetailes.ui.models.color.ColorItem
import pat.project.coursework.productsdetailes.ui.models.color.ColorItemUi
import pat.project.coursework.productsdetailes.ui.models.memory.MemoryItem
import pat.project.coursework.productsdetailes.ui.models.memory.MemoryItemUi
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
        TabItems.Shop(),
        TabItems.Details(),
        TabItems.Features()
    )
    var selectedTabItem by remember { mutableStateOf(0) }

    val phoneDetailedData = productsDetailsViewModel.phoneDetailedData.collectAsState()

    LaunchedEffect(key1 = Unit) {
        productsDetailsViewModel.requestData()
    }

    val productProperties by remember(phoneDetailedData.value) {
        mutableStateOf(
            listOf(
                PropertyItem(
                    propertyTitle = phoneDetailedData.value.cPU,
                    propertyIcon = Icons.Outlined.Memory
                ),
                PropertyItem(
                    propertyTitle = phoneDetailedData.value.camera,
                    propertyIcon = Icons.Outlined.PhotoCamera
                ),
                PropertyItem(
                    propertyTitle = phoneDetailedData.value.ssd,
                    propertyIcon = Icons.Outlined.Storage
                ),
                PropertyItem(
                    propertyTitle = phoneDetailedData.value.sd,
                    propertyIcon = Icons.Outlined.SdStorage
                )
            )
        )
    }

    var selectedColor by remember {
        mutableStateOf(0)
    }

    var selectedMemory by remember {
        mutableStateOf(0)
    }


    val colorsList by remember(phoneDetailedData.value, selectedColor) {
        mutableStateOf(
            phoneDetailedData.value.color.mapIndexed { ind, value ->
                ColorItem(
                    selectedColor == ind,
                    Color(value.toColorInt())
                )
            }

        )
    }

    val memoryList by remember(phoneDetailedData.value, selectedMemory) {
        mutableStateOf(
            phoneDetailedData.value.capacity.mapIndexed { ind, value ->
                MemoryItem(
                    selectedMemory == ind,
                    value
                )
            }

        )
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
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

        val photos = phoneDetailedData.value.images
        HorizontalPager(
            count = photos.size,
            itemSpacing = 24.dp,
            verticalAlignment = Alignment.CenterVertically,
        ) { currentImage ->
            Image(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(350.dp)
                    .shadow(3.dp, shape = RoundedCornerShape(12.dp)),
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(photos[currentImage])
                        .build(),
                    placeholder = ColorPainter(AppResources.colors.GreyLight),
                ),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
            )
        }
        Surface(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxSize()
                .shadow(4.dp, shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
            color = AppResources.colors.White,
        ) {
            Column(modifier = Modifier.padding(start = 30.dp, end = 30.dp, top = 24.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column() {
                        Text(
                            text = phoneDetailedData.value.title,
                            style = AppResources.typography.medium.sp24.copy(
                                color = AppResources.colors.Blue
                            )
                        )
                        CustomRatingBar(
                            modifier = Modifier.padding(top = 6.dp),
                            starWidth = 18.dp,
                            starHeight = 18.dp,
                            endPadding = 8.dp,
                            rating = phoneDetailedData.value.rating
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
                    modifier = Modifier.padding(top = 24.dp),
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
                FlowRow(
                    modifier = Modifier.padding(top = 18.dp)
                ) {
                    //тут плохой вариант реализации бэкенда и api
                    productProperties.forEach { propertyItem ->
                        PropertyItemUi(propertyItem = propertyItem)
                    }
                }
                Text(
                    modifier = Modifier.padding(top = 12.dp, start = 12.dp, bottom = 12.dp),
                    text = stringResource(id = R.string.select_color_and_capacity),
                    style = AppResources.typography.medium.sp15.copy(color = AppResources.colors.Blue)
                )

                FlowRow(
                    modifier = Modifier.padding(bottom = 12.dp)
                ) {
                    colorsList.forEachIndexed { index, colorItem ->
                        ColorItemUi(
                            modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                            colorItem = colorItem,
                            onColorSelected = {
                                selectedColor = index
                            }
                        )
                    }
                    memoryList.forEachIndexed { index, memoryItem ->
                        MemoryItemUi(
                            modifier = Modifier.padding(start = 12.dp),
                            memoryItem = memoryItem,
                            onMemoryItemSelected = {
                                selectedMemory = index
                            }
                        )
                    }
                }

                CustomButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, bottom = 24.dp),
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
                                text = "$${phoneDetailedData.value.price}",
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