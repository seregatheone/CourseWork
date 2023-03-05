package pat.project.coursework.domain.interactors

import pat.project.coursework.entity.home.HomeDomainData
import pat.project.coursework.interactor.HomeInteractor
import pat.project.coursework.repository.HomeRepository
import pat.project.coursework.common.domain.entity.Entity

class HomeInteractorImpl(
    private val repository: HomeRepository
) : HomeInteractor {
    override suspend fun getHomeInfo(): Entity<HomeDomainData> {
        return repository.getHomeInfo()
    }
}
