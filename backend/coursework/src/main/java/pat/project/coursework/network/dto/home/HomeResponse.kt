package pat.project.coursework.network.dto.home

import com.google.gson.annotations.SerializedName

class HomeResponse {

    data class HomeData(
        @SerializedName("best_seller")
        val bestSeller: List<BestSeller>,
        @SerializedName("home_store")
        val homeStore: List<HomeStore>
    )

    data class BestSeller(
        @SerializedName("discount_price")
        val discountPrice: Int,
        @SerializedName("id")
        val id: Int,
        @SerializedName("is_favorites")
        val isFavorites: Boolean,
        @SerializedName("picture")
        val picture: String,
        @SerializedName("price_without_discount")
        val priceWithoutDiscount: Int,
        @SerializedName("title")
        val title: String
    )
    data class HomeStore(
        @SerializedName("id")
        val id: Int,
        @SerializedName("is_buy")
        val isBuy: Boolean,
        @SerializedName("is_new")
        val isNew: Boolean? = false,
        @SerializedName("picture")
        val picture: String,
        @SerializedName("subtitle")
        val subtitle: String,
        @SerializedName("title")
        val title: String
    )
}