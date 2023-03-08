package pat.project.coursework.productsdetailes.ui.models.color

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import pat.project.coursework.ui.themes.AppResources

@Composable
fun ColorItemUi(
    colorItem: ColorItem,
    onColorSelected: () -> Unit,
    modifier : Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .size(40.dp)
            .clickable(
                true,
                onClick = onColorSelected
            ),
        color = colorItem.color,
        shape = CircleShape
    ) {
        if (colorItem.isSelected) {
            Icon(
                modifier = Modifier
                    .size(40.dp)
                    .padding(6.dp),
                imageVector = Icons.Rounded.Check,
                tint = AppResources.colors.White,
                contentDescription = null
            )
        }
    }
}