package pat.project.coursework.home.ui.category.model

import androidx.compose.ui.graphics.Color

sealed class CategoriesStyles {
    abstract val backgroundColor: Color
    abstract val iconColor: Color
    abstract val textColor: Color

    class Active(
        override val backgroundColor: Color,
        override val iconColor: Color,
        override val textColor: Color
    ) : CategoriesStyles()

    class InActive(
        override val backgroundColor: Color,
        override val iconColor: Color,
        override val textColor: Color
    ) : CategoriesStyles()

}