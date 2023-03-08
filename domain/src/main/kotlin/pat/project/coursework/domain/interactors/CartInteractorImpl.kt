package pat.project.coursework.domain.interactors

import pat.project.coursework.entity.home.HomeDomainData
import pat.project.coursework.interactor.HomeInteractor
import pat.project.coursework.repository.HomeRepository
import pat.project.coursework.common.domain.entity.Entity
import pat.project.coursework.entity.CartData
import pat.project.coursework.interactor.CartInteractor
import pat.project.coursework.repository.CartRepository

class CartInteractorImpl(
    private val repository: CartRepository
) : CartInteractor {

    override suspend fun getCartInfo(): Entity<CartData> {
        return repository.getCartInfo()
    }
}
