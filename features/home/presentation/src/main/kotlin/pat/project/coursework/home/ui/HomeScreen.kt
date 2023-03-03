package pat.project.coursework.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pat.project.coursework.home.ui.bestseller.BestSellersLayout
import pat.project.coursework.home.ui.category.SelectCategory
import pat.project.coursework.home.ui.model.Category
import pat.project.coursework.home.ui.hotsales.HotSales
import pat.project.coursework.home.ui.model.BestSellersMock
import pat.project.coursework.ui.themes.AppResources


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel
) {
    val categories = homeViewModel.categories.collectAsState()
    var selectedCategory by remember(categories) { mutableStateOf(categories.value.firstOrNull()) }

    val hotSalesItemsList by homeViewModel.hotSales.collectAsState()

    val bestSellersItemsList by homeViewModel.bestSellers.collectAsState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { HomeAppBar() },
        bottomBar = {}
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .background(AppResources.colors.BackgroundWhite)
                .padding(
                    start = 12.dp,
                    end = 12.dp,
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
        ) {
            item {
                SelectCategory(
                    categories.value,
                    selectedCategory,
                    onCategorySelected = { category: Category ->
                        selectedCategory = category
                    }
                )
            }
            item {
                HotSales(hotSalesItemsList)
            }
            item {
                BestSellersLayout(bestSellerList = bestSellersItemsList)
            }
        }
    }

}
