package pat.project.coursework.data.repository


import pat.project.coursework.common.domain.entity.Entity
import pat.project.coursework.data.base.BaseRepository
import pat.project.coursework.data.mappers.asDomainData
import pat.project.coursework.entity.CartData
import pat.project.coursework.entity.home.HomeDomainData
import pat.project.coursework.network.api.CartApi
import pat.project.coursework.network.api.HomeApi
import pat.project.coursework.network.utils.models.ResponseStatus
import pat.project.coursework.repository.CartRepository
import pat.project.coursework.repository.HomeRepository


class CartRepositoryImpl(
    private val api: CartApi
) : CartRepository, BaseRepository() {

    override suspend fun getCartInfo(): Entity<CartData> {
        return when (
            val resp = safeApiSuspendResult {
                api.getCartData()
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
