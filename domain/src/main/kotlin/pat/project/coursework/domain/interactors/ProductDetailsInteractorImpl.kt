package pat.project.coursework.domain.interactors

import pat.project.coursework.common.domain.entity.Entity
import pat.project.coursework.entity.home.ProductDetailedData
import pat.project.coursework.interactor.ProductDetailedInteractor
import pat.project.coursework.repository.ProductDetailedRepository

class ProductDetailsInteractorImpl(
    private val repository: ProductDetailedRepository
) : ProductDetailedInteractor {

    override suspend fun getHomeInfo(): Entity<ProductDetailedData> {
        return repository.getHomeInfo()
    }
}
