package pat.project.coursework.interactor

import pat.project.coursework.entity.home.HomeDomainData
import pat.project.coursework.common.domain.entity.Entity


interface HomeInteractor {
    suspend fun getHomeInfo(): Entity<HomeDomainData>
}
