package pat.project.coursework.productsdetailes.ui.models.memory

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pat.project.coursework.ui.components.buttons.ButtonBackgroundColors
import pat.project.coursework.ui.components.buttons.ButtonStyles
import pat.project.coursework.ui.components.buttons.CustomButton
import pat.project.coursework.ui.themes.AppResources

@Composable
fun MemoryItemUi(
    memoryItem: MemoryItem,
    onMemoryItemSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    CustomButton(
        modifier = modifier,
        onClick = { onMemoryItemSelected() },
        buttonStyle = ButtonStyles.CustomTextButton(
            buttonText = memoryItem.size+" GB",
            buttonBackgroundColors = if (memoryItem.isSelected) ButtonBackgroundColors.Orange else ButtonBackgroundColors.Transparent,
            textColor = if (memoryItem.isSelected) AppResources.colors.White else AppResources.colors.MemoryGrey,
            buttonTextStyle = AppResources.typography.bold.sp15,
            paddingValues = PaddingValues(vertical = 6.dp, horizontal = 15.dp)
        )
    )
}