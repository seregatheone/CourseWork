package pat.project.coursework.home.ui.category

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pat.project.coursework.features.home.presentation.R
import pat.project.coursework.home.ui.model.CategoriesStyles
import pat.project.coursework.home.ui.model.Category
import pat.project.coursework.ui.themes.AppResources

@Composable
fun CategoryItem(
    category: Category,
    categorySelected: Boolean
) {
    val categoriesStyle: CategoriesStyles = if (categorySelected) {
        CategoriesStyles.Active(
            backgroundColor = AppResources.colors.Orange,
            iconColor = AppResources.colors.White,
            textColor = AppResources.colors.Orange
        )
    } else {
        CategoriesStyles.InActive(
            backgroundColor = AppResources.colors.White,
            iconColor = AppResources.colors.GreyLight,
            textColor = AppResources.colors.Blue
        )
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier.padding(bottom = 8.dp),
        ) {
            Surface(
                modifier = Modifier.size(72.dp),
                shape = CircleShape,
                color = categoriesStyle.backgroundColor
            ) {}
            Icon(
                modifier = Modifier
                    .size(72.dp)
                    .padding(16.dp)
                    .align(Alignment.Center),
                imageVector = category.vectorAsset,
                contentDescription = stringResource(id = R.string.select_category_icon),
                tint = categoriesStyle.iconColor
            )
        }
        Text(
            text = category.title,
            style = AppResources.typography.medium.sp15,
            color = categoriesStyle.textColor
        )
    }
}

