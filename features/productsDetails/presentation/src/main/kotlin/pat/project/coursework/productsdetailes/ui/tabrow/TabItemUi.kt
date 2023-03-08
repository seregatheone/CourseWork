package pat.project.coursework.productsdetailes.ui.tabrow

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pat.project.coursework.ui.themes.AppResources
import pat.project.coursework.ui.themes.ripple.NoRippleInteractionSource

@Composable
fun TabItemUi(
    isSelected: Boolean,
    tabItems: TabItems,
    onTabClicked: () -> Unit
) {
    Tab(
        modifier = Modifier.padding(bottom = 6.dp),
        selected = isSelected,
        onClick = { onTabClicked() },
        interactionSource = NoRippleInteractionSource()
    ) {
        Text(
            text = tabItems.tabItemTitle,
            style = if (isSelected) AppResources.typography.bold.sp20.copy(color = AppResources.colors.Blue)
            else AppResources.typography.medium.sp20.copy(color = AppResources.colors.GreyLight)
        )
    }
}