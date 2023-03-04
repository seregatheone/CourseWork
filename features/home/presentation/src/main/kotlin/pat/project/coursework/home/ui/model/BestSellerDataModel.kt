package pat.project.coursework.home.ui.model

data class BestSellerDataModel(
    val bestSellerId : Int,
    val isFavorites : Boolean,
    val title : String,
    val priceWithoutDiscount : Int,
    val discountPrice : Int,
    val pictureUrl : String
    )