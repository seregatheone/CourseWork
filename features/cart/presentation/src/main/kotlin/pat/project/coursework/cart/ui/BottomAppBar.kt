package pat.project.coursework.cart.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pat.project.coursework.features.cart.presentation.R
import pat.project.coursework.ui.components.buttons.ButtonBackgroundColors
import pat.project.coursework.ui.components.buttons.ButtonStyles
import pat.project.coursework.ui.components.buttons.CustomButton
import pat.project.coursework.ui.themes.AppResources


@Composable
fun BottomCartAppBar() = BottomAppBar(
    contentPadding = PaddingValues(top = 24.dp, bottom = 32.dp),
    backgroundColor = AppResources.colors.Blue,
    elevation = 1.dp,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CustomButton(
            onClick = {  },
            buttonStyle = ButtonStyles.CustomTextButton(
                buttonBackgroundColors = ButtonBackgroundColors.Orange,
                paddingValues = PaddingValues(horizontal = 120.dp, vertical = 14.dp),
                buttonText = stringResource(id = R.string.checkout),
                buttonTextStyle = AppResources.typography.bold.sp20,
                textColor = AppResources.colors.White
            )
        )

    }
}