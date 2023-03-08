package pat.project.coursework.interactor

import pat.project.coursework.entity.home.ProductDetailedData
import pat.project.coursework.common.domain.entity.Entity


interface ProductDetailedInteractor {
    suspend fun getProductDetailedInfo(): Entity<ProductDetailedData>
}
