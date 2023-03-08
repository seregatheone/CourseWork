package pat.project.coursework.network.dto.cart


import com.google.gson.annotations.SerializedName

class CartResponse{

    data class CartPageResponse(
        @SerializedName("basket")
        val basket: List<Basket>,
        @SerializedName("delivery")
        val delivery: String,
        @SerializedName("id")
        val id: String,
        @SerializedName("total")
        val total: Int
    )

    data class Basket(
        @SerializedName("id")
        val id: Int,
        @SerializedName("images")
        val images: String,
        @SerializedName("price")
        val price: Int,
        @SerializedName("title")
        val title: String
    )
}
