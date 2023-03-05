package pat.project.coursework.entity

data class CartData(
    val cartItem: List<CartItems>,
    val delivery: String,
    val id: String,
    val total: Int
)