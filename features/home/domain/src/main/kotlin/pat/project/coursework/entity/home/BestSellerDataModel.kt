package pat.project.coursework.entity.home

data class BestSellerDataModel(
    val bestSellerId : Int,
    val isFavorites : Boolean,
    val title : String,
    val priceWithoutDiscount : Int,
    val discountPrice : Int,
    val pictureUrl : String
    )