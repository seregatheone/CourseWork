package pat.project.coursework.data.repository


import pat.project.coursework.common.domain.entity.Entity
import pat.project.coursework.data.base.BaseRepository
import pat.project.coursework.data.mappers.addresses.asDomainData
import pat.project.coursework.entity.home.HomeDomainData
import pat.project.coursework.network.api.HomeApi
import pat.project.coursework.network.utils.models.ResponseStatus
import pat.project.coursework.repository.HomeRepository


class HomeRepositoryImpl(
    private val api: HomeApi
) : HomeRepository, BaseRepository() {
    override suspend fun getHomeInfo(): Entity<HomeDomainData> {
        return when (
            val resp = safeApiSuspendResult {
                api.getHomePageData()
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
