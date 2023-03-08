package pat.project.coursework.data.mappers

import pat.project.coursework.entity.home.ProductDetailedData
import pat.project.coursework.network.dto.productDetails.ProductDetailsResponse


fun ProductDetailsResponse.ProductDetailsPageResponse.asDomainData(): ProductDetailedData {
    return ProductDetailedData(
        cPU = this.cPU,
        camera = this.camera,
        capacity = this.capacity,
        color = this.color,
        id = this.id,
        images = this.images,
        isFavorites = this.isFavorites,
        price = this.price,
        rating = this.rating,
        sd = this.sd,
        ssd = this.ssd,
        title = this.title,
    )
}