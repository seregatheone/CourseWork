package pat.project.coursework.network.api

import pat.project.coursework.network.dto.productDetails.ProductDetailsResponse
import retrofit2.http.GET


interface ProductDetailsApi {
    @GET("v3/6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getProductDetailsData() : ProductDetailsResponse.ProductDetailsPageResponse
}