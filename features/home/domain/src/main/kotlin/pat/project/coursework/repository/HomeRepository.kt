package pat.project.coursework.repository

import pat.project.coursework.entity.home.HomeDomainData
import pat.project.coursework.common.domain.entity.Entity

interface HomeRepository {
    suspend fun getHomeInfo(): Entity<HomeDomainData>
}
