package pat.project.coursework.data.mappers

import pat.project.coursework.entity.home.BestSellerDataModel
import pat.project.coursework.entity.home.HomeDomainData
import pat.project.coursework.entity.home.HotSalesDataModel
import pat.project.coursework.network.dto.home.HomeResponse

fun HomeResponse.HomeData.asDomainData(): HomeDomainData {
    return HomeDomainData(
        this.bestSeller.map { it.toDataModel() },
        this.homeStore.map { it.toDataModel() }
    )
}

fun HomeResponse.BestSeller.toDataModel(): BestSellerDataModel {
    return BestSellerDataModel(
        bestSellerId = this.id,
        isFavorites = this.isFavorites,
        title = this.title,
        priceWithoutDiscount = this.priceWithoutDiscount,
        discountPrice = this.discountPrice,
        pictureUrl = this.picture
    )

}

fun HomeResponse.HomeStore.toDataModel(): HotSalesDataModel {
    return HotSalesDataModel(
        id = this.id,
        isNew = this.isNew ?: false,
        title = this.title,
        subtitle = this.subtitle,
        pictureUrl = this.picture,
        isBought = this.isBuy
    )

}