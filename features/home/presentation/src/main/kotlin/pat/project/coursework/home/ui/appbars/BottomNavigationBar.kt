package pat.project.coursework.home.ui.appbars

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pat.project.coursework.features.home.presentation.R
import pat.project.coursework.ui.themes.AppResources

@Composable
fun BottomNavigationBar() = BottomAppBar(
    modifier = Modifier.clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
    backgroundColor = AppResources.colors.Blue,
    contentColor = AppResources.colors.White,
    contentPadding = PaddingValues(vertical = 4.dp)
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Surface(
                modifier = Modifier.size(8.dp),
                shape = CircleShape,
                color = AppResources.colors.White
            ) {}
            Text(
                modifier = Modifier.padding(start = 4.dp),
                text = stringResource(id = R.string.explorer),
                style = AppResources.typography.bold.sp15,
                color = AppResources.colors.White
            )
        }

        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = Icons.Outlined.ShoppingBag,
            tint = AppResources.colors.White,
            contentDescription = null)

        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = Icons.Outlined.FavoriteBorder,
            tint = AppResources.colors.White,
            contentDescription = null)

        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = Icons.Outlined.Person,
            tint = AppResources.colors.White,
            contentDescription = null)


    }
}