package pat.project.coursework.network.api

import pat.project.coursework.network.dto.home.HomeResponse
import retrofit2.http.GET

interface HomeApi {
    @GET("v3/654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getHomePageData(): HomeResponse.HomeData
}