package org.wfp.serviceprovision.repository.service

import io.reactivex.Single
import org.wfp.serviceprovision.model.ServiceModel

class ServiceRepositoryImpl(private val servicesApiService: ServicesApiService) : ServiceRepository {
    val serviceCache = arrayListOf<ServiceModel>()
    override fun searchService(countryCode: String): Single<List<ServiceModel>> =servicesApiService.getServices(countryCode)
            .doOnSuccess {
                serviceCache.clear()
                serviceCache.addAll(it)
            }
}