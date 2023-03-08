package pat.project.coursework.data.mappers

import pat.project.coursework.entity.CartData
import pat.project.coursework.entity.CartItems
import pat.project.coursework.entity.home.BestSellerDataModel
import pat.project.coursework.entity.home.HomeDomainData
import pat.project.coursework.network.dto.cart.CartResponse
import pat.project.coursework.network.dto.home.HomeResponse


fun CartResponse.CartPageResponse.asDomainData(): CartData {
    return CartData(
        cartItem = this.basket.map { it.toDataModel() },
        delivery = this.delivery,
        id = this.id,
        total = this.total,
    )
}

fun CartResponse.Basket.toDataModel(): CartItems {
    return CartItems(
        id = this.id,
        title = this.title,
        pictureUrl = this.images,
        price = this.price,
    )

}
