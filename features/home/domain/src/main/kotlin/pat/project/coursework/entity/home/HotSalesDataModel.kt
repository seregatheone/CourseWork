package pat.project.coursework.entity.home

data class HotSalesDataModel(
    val id : Int,
    val isNew : Boolean,
    val title: String,
    val subtitle: String,
    val pictureUrl: String,
    val isBought : Boolean
)