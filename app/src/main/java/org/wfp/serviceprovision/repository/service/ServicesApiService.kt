package org.wfp.serviceprovision.repository.service

import io.reactivex.Single
import org.wfp.serviceprovision.constants.ApiEndpoints
import org.wfp.serviceprovision.repository.data.ServicesResult
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface ServicesApiService {
    @Headers("accept:application/json")
    @GET(ApiEndpoints.SERVICES_BY_COUNTRY_ENDPOINT)
    fun getServices(@Header("Authorization")token:String,@Path("countryCode")countryCode:String): Single<ServicesResult>
}