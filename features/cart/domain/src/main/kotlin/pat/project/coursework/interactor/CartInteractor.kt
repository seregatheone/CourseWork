package pat.project.coursework.interactor


import pat.project.coursework.common.domain.entity.Entity
import pat.project.coursework.entity.CartData


interface CartInteractor {
    suspend fun getCartInfo(): Entity<CartData>
}
