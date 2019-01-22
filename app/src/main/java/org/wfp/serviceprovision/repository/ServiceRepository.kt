package org.wfp.serviceprovision.repository

import io.reactivex.Single
import org.wfp.serviceprovision.model.ServiceModel

interface ServiceRepository {
    fun searchService(countryCode:String): Single<List<ServiceModel>>
}

class ServiceRepositoryImpl(private val serviceDatasource: ServiceDataSource) : ServiceRepository {
    val serviceCache = arrayListOf<ServiceModel>()
    override fun searchService(countryCode: String): Single<List<ServiceModel>> =serviceDatasource.getServices(countryCode)
            .doOnSuccess {
                serviceCache.clear()
                serviceCache.addAll(it)
            }
}