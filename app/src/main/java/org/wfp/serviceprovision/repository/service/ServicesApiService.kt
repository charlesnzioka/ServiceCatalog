package org.wfp.serviceprovision.repository.service

import io.reactivex.Single
import org.wfp.serviceprovision.constants.ApiEndpoints
import org.wfp.serviceprovision.model.ServiceModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ServicesApiService {

    @GET(ApiEndpoints.SERVICES_BY_COUNTRY_ENDPOINT)
    fun getServices(@Path("countryCode")countryCode:String): Single<List<ServiceModel>>
}