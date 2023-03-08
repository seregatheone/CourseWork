package pat.project.coursework.home.ui.category

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Modifier
import pat.project.coursework.home.ui.model.Category
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.QrCode
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pat.project.coursework.features.home.presentation.R
import pat.project.coursework.ui.themes.AppResources
import pat.project.coursework.ui.themes.ripple.NoRippleInteractionSource

@Composable
fun SelectCategory(
    modifier: Modifier = Modifier,
    categories: List<Category>,
    selectedCategory: Category?,
    onCategorySelected: (Category) -> Unit
) {
    var searchText by remember { mutableStateOf("") }
    var searchTextFocusedState by remember { mutableStateOf(false) }


    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.select_category),
                style = AppResources.typography.bold.sp25,
                color = AppResources.colors.Blue
            )
            Text(
                modifier = Modifier.padding(end = 12.dp),
                text = stringResource(id = R.string.view_all),
                style = AppResources.typography.regular.sp15,
                color = AppResources.colors.Orange
            )
        }

        val selectedIndex =
            if (selectedCategory != null) categories.indexOfFirst { it.categoryId == selectedCategory.categoryId }
            else 0
        ScrollableTabRow(
            modifier = Modifier.padding(top = 20.dp),
            selectedTabIndex = selectedIndex,
            edgePadding = 0.dp,
            divider = {},
            indicator = {}
        ) {
            categories.forEachIndexed { index, category ->
                Tab(
                    selected = index == selectedIndex,
                    onClick = { onCategorySelected(category) },
                    interactionSource = NoRippleInteractionSource(),
                    selectedContentColor = Color.Unspecified,
                    unselectedContentColor = Color.Unspecified
                ) {
                    CategoryItem(
                        category = category,
                        categorySelected = index == selectedIndex
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 28.dp)
        ) {
            SearchComponent(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .weight(1f),
                value = searchText,
                onTextChanged = { newValue: String ->
                    searchText = newValue
                },
                onClearSearchText = {
                    searchText = ""
                },
                searchIsFocused = searchTextFocusedState,
                onFocusChange = { newFocusState ->
                    searchTextFocusedState = newFocusState
                }
            )

            Surface(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .size(34.dp),
                shape = CircleShape,
                color = AppResources.colors.Orange
            ) {
                Icon(
                    modifier = Modifier
                        .size(34.dp)
                        .padding(6.dp),
                    imageVector = Icons.Outlined.QrCode,
                    contentDescription = stringResource(id = R.string.qrcode),
                    tint = AppResources.colors.White
                )
            }
        }
    }
}