package pat.project.coursework.home.ui.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import pat.project.coursework.home.ui.bottomsheet.FilterOptions

object FilterOptionsMock {
    val filterOptions = listOf(
        FilterOptions(
            stateTitle = "Brand",
            variants = listOf(
                "Sumsung",
                "Iphone",
                "Xiaomi"
            )
        ),
        FilterOptions(
            stateTitle = "Price",
            variants = listOf(
                "$300 - $500",
                "$500 - $800",
                "$800 - $1200"
            )
        ),
        FilterOptions(
            stateTitle = "Size",
            variants = listOf(
                "4.5 to 5.5 inches",
                "5.5 to 6.5 inches",
                "6.5 to 7.5 inches"
            )
        )
    )
}