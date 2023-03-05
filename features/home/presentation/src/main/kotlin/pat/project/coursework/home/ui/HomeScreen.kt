package pat.project.coursework.home.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import pat.project.coursework.home.ui.appbars.BottomNavigationBar
import pat.project.coursework.home.ui.bestseller.BestSellersLayout
import pat.project.coursework.home.ui.bottomsheet.FilterOptions
import pat.project.coursework.home.ui.bottomsheet.ModalBottomSheet
import pat.project.coursework.home.ui.category.SelectCategory
import pat.project.coursework.home.ui.model.Category
import pat.project.coursework.home.ui.hotsales.HotSales
import pat.project.coursework.home.ui.model.FilterOptionsMock
import pat.project.coursework.ui.themes.AppResources


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    navigateToCart: () -> Unit,
    navigateToProductsDetails: () -> Unit
) {
    val categories = homeViewModel.categories.collectAsState()
    var selectedCategory by remember(categories) { mutableStateOf(categories.value.firstOrNull()) }

    val hotSalesItemsList by homeViewModel.hotSales.collectAsState()

    val bestSellersItemsList by homeViewModel.bestSellers.collectAsState()

    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded }
    )

    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = Unit) {
        homeViewModel.makeRequestForData()
    }

    BackHandler(sheetState.isVisible) {
        scope.launch { sheetState.hide() }
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        sheetContent = {
            ModalBottomSheet(
                filterOptions = FilterOptionsMock.filterOptions,
                hideBottomSheet = { scope.launch { sheetState.hide() } }
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .background(AppResources.colors.BackgroundWhite)
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(AppResources.colors.White),
            topBar = {
                HomeAppBar(
                    openFilterBottomSheet = { scope.launch { sheetState.show() } }
                )
            },
            bottomBar = {
                BottomNavigationBar(
                    navigateToCart = navigateToProductsDetails
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(AppResources.colors.BackgroundWhite)
                    .verticalScroll(rememberScrollState())
                    .padding(
                        start = 12.dp,
                        end = 12.dp,
                        top = paddingValues.calculateTopPadding(),
                        bottom = paddingValues.calculateBottomPadding()
                    )
            ) {
                SelectCategory(
                    modifier = Modifier,
                    categories.value,
                    selectedCategory,
                    onCategorySelected = { category: Category ->
                        selectedCategory = category
                    }
                )

                HotSales(
                    modifier = Modifier,
                    hotSalesItemsList,
                    navigateToProductsDetails = navigateToProductsDetails
                )

                BestSellersLayout(
                    modifier = Modifier,
                    bestSellerList = bestSellersItemsList,
                    navigateToProductsDetails = navigateToProductsDetails
                )

            }
        }
    }

}
