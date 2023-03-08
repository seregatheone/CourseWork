package pat.project.coursework.ui.components.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle

sealed class ButtonStyles{
    class CustomTextButton(
        val buttonBackgroundColors: ButtonBackgroundColors,
        val paddingValues: PaddingValues,
        val buttonTextStyle: TextStyle,
        val textColor : Color,
        val buttonText: String
    ) : ButtonStyles()

    class CustomIconButton(
        val buttonBackgroundColors: ButtonBackgroundColors,
        val buttonIcon: ImageVector
    ) : ButtonStyles()

    class FullCustomButton(
        val buttonBackgroundColors: ButtonBackgroundColors,
        val buttonContent: @Composable () -> Unit
    ) : ButtonStyles()
}

enum class ButtonBackgroundColors {
    BLUE, Orange, Transparent
}