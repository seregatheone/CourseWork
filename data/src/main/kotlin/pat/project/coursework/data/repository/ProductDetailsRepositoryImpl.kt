package pat.project.coursework.data.repository


import pat.project.coursework.common.domain.entity.Entity
import pat.project.coursework.data.base.BaseRepository
import pat.project.coursework.data.mappers.asDomainData
import pat.project.coursework.entity.home.ProductDetailedData
import pat.project.coursework.network.api.ProductDetailsApi
import pat.project.coursework.network.utils.models.ResponseStatus
import pat.project.coursework.repository.ProductDetailedRepository


class ProductDetailsRepositoryImpl(
    private val api: ProductDetailsApi
) : ProductDetailedRepository, BaseRepository() {

    override suspend fun getHomeInfo(): Entity<ProductDetailedData> {
        return when (
            val resp = safeApiSuspendResult {
                api.getProductDetailsData()
            }
        ) {
            is ResponseStatus.Success -> {
                Entity.Success(resp.data!!.asDomainData())
            }
            is ResponseStatus.Error -> {
                Entity.Error(resp.exception.message ?: "")
            }
        }
    }


}
