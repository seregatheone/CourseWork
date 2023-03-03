package pat.project.coursework.home.ui.model

data class HotSalesDataModel(
    val id : Int,
    val isNew : Boolean,
    val title: String,
    val subtitle: String,
    val pictureUrl: String,
    val isBought : Boolean
)