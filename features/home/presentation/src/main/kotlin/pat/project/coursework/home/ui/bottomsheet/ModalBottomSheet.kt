package pat.project.coursework.home.ui.bottomsheet

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pat.project.coursework.features.home.presentation.R
import pat.project.coursework.ui.components.buttons.ButtonBackgroundColors
import pat.project.coursework.ui.components.buttons.ButtonStyles
import pat.project.coursework.ui.components.buttons.CustomButton
import pat.project.coursework.ui.themes.AppResources

@Composable
fun ModalBottomSheet(
    filterOptions: List<FilterOptions>,
    hideBottomSheet: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 40.dp,
                top = 20.dp,
                end = 20.dp,
                bottom = 40.dp
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomButton(
                onClick = { hideBottomSheet() },
                buttonStyle = ButtonStyles.CustomIconButton(
                    buttonBackgroundColors = ButtonBackgroundColors.BLUE,
                    buttonIcon = Icons.Outlined.Close
                )
            )
            Text(
                text = stringResource(id = R.string.filter_params),
                style = AppResources.typography.medium.sp18,
                color = AppResources.colors.Blue
            )
            CustomButton(
                modifier = Modifier,
                onClick = { hideBottomSheet() },
                buttonStyle = ButtonStyles.CustomTextButton(
                    buttonBackgroundColors = ButtonBackgroundColors.Orange,
                    buttonTextStyle = AppResources.typography.medium.sp18,
                    buttonText = stringResource(id = R.string.filter_done),
                    paddingValues = PaddingValues(vertical = 7.dp, horizontal = 16.dp)
                ),
            )
        }
        LazyColumn(
            modifier = Modifier
                .padding(top = 16.dp)
                .sizeIn(maxHeight = 400.dp)
        ) {
            items(filterOptions.size) { currentOption ->
                FilterOptionsItem(filterOption = filterOptions[currentOption])
            }
        }
    }
}