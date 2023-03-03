package pat.project.coursework.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pat.project.coursework.home.ui.category.SelectCategory
import pat.project.coursework.home.ui.category.model.Category
import pat.project.coursework.ui.themes.AppResources


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel
) {
    val categories = homeViewModel.categories.collectAsState()
    var selectedCategory by remember(categories) { mutableStateOf(categories.value.firstOrNull()) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { HomeAppBar() },
        bottomBar = {}
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(AppResources.colors.BackgroundWhite)
                .padding(
                    start = 12.dp,
                    end = 12.dp,
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                )
        ) {
            SelectCategory(
                categories.value,
                selectedCategory,
                onCategorySelected = { category: Category ->
                    selectedCategory = category
                }
            )
        }
    }

}
