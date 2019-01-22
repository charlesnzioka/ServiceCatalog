package org.wfp.serviceprovision.repository

import io.reactivex.Single
import org.wfp.serviceprovision.model.ServiceModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceDataSource {

    @GET("/services/{countryCode}")
    fun getServices(@Path("countryCode")countryCode:String): Single<List<ServiceModel>>
}