package pat.project.coursework.ui.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import pat.project.coursework.ui.themes.AppResources


@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonStyle: ButtonStyles
) {
    when (buttonStyle) {
        is ButtonStyles.CustomIconButton -> {
            Icon(
                modifier = Modifier
                    .size(37.dp)
                    .background(
                        shape = RoundedCornerShape(10.dp),
                        color = selectColor(buttonStyle.buttonBackgroundColors)
                    )
                    .padding(6.dp)
                    .clickable(true, onClick = onClick),
                imageVector = buttonStyle.buttonIcon,
                tint = AppResources.colors.White,
                contentDescription = null
            )
        }
        is ButtonStyles.CustomTextButton -> {
            BasicText(
                modifier = modifier
                    .background(
                        shape = RoundedCornerShape(10.dp),
                        color = selectColor(buttonStyle.buttonBackgroundColors)
                    )
                    .padding(paddingValues = buttonStyle.paddingValues)
                    .clickable(true, onClick = onClick),
                text = buttonStyle.buttonText,
                style = buttonStyle.buttonTextStyle.copy(
                    color = buttonStyle.textColor
                ),
            )
        }

        is ButtonStyles.FullCustomButton -> {
            Button(
                modifier = modifier.height(48.dp),
                onClick = { onClick() },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = selectColor(buttonStyle.buttonBackgroundColors),
                    contentColor = AppResources.colors.White
                )
            ) {
                buttonStyle.buttonContent()
            }
        }
    }
}

@Composable
fun selectColor(buttonBackgroundColors: ButtonBackgroundColors): Color {
    return when (buttonBackgroundColors) {
        ButtonBackgroundColors.Orange -> AppResources.colors.Orange
        ButtonBackgroundColors.BLUE -> AppResources.colors.Blue
        ButtonBackgroundColors.Transparent -> Color.Transparent
    }
}