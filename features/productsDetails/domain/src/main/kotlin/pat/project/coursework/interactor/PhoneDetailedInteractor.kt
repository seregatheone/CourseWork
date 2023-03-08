package pat.project.coursework.interactor

import pat.project.coursework.entity.home.PhoneDetailedData
import pat.project.coursework.common.domain.entity.Entity


interface PhoneDetailedInteractor {
    suspend fun getHomeInfo(): Entity<PhoneDetailedData>
}
