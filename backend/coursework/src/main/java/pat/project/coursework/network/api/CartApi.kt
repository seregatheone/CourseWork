package pat.project.coursework.network.api

import pat.project.coursework.network.dto.cart.CartResponse
import retrofit2.http.GET


interface CartApi {
    @GET("v3/53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getCartData() : CartResponse.CartPageResponse

}