package pat.project.coursework.repository

import pat.project.coursework.entity.home.PhoneDetailedData
import pat.project.coursework.common.domain.entity.Entity

interface PhoneDetailedRepository {
    suspend fun getHomeInfo(): Entity<PhoneDetailedData>
}
