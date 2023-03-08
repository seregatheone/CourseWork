package pat.project.coursework.productsdetailes.ui.properties

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pat.project.coursework.ui.themes.AppResources

@Composable
fun PropertyItemUi(propertyItem: PropertyItem) {
    Column(modifier = Modifier.padding(6.dp)) {
        Icon(
            modifier = Modifier.size(30.dp),
            imageVector = propertyItem.propertyIcon,
            contentDescription = null,
            tint = AppResources.colors.GreyLight
        )
        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = propertyItem.propertyTitle,
            style = AppResources.typography.regular.sp12.copy(color = AppResources.colors.GreyLight)
        )

    }
}