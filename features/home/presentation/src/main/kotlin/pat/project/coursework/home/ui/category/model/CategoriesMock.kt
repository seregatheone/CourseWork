package pat.project.coursework.home.ui.category.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*

object CategoriesMock {
    val categories = listOf(
        Category("1", Icons.Outlined.Smartphone, "Phones"),
        Category("2", Icons.Outlined.Computer, "Computer"),
        Category("3", Icons.Outlined.Monitor, "Health"),
        Category("4", Icons.Outlined.Book, "Books"),
        Category("5", Icons.Outlined.Camera, "Cameras"),
        Category("6", Icons.Outlined.Print, "Printers"),
        Category("7", Icons.Outlined.FlightTakeoff, "Flights"),
        Category("8", Icons.Outlined.Commute, "Transport"),
    )
}