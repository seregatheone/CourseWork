package pat.project.coursework.repository

import pat.project.coursework.entity.home.ProductDetailedData
import pat.project.coursework.common.domain.entity.Entity

interface ProductDetailedRepository {
    suspend fun getHomeInfo(): Entity<ProductDetailedData>
}
