package pat.project.coursework.repository


import pat.project.coursework.common.domain.entity.Entity
import pat.project.coursework.entity.CartData

interface CartRepository {
    suspend fun getCartInfo(): Entity<CartData>
}
