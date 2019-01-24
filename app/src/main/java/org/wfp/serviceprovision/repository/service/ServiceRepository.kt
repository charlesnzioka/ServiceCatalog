package org.wfp.serviceprovision.repository.service

import io.reactivex.Single
import org.wfp.serviceprovision.model.ServiceModel

interface ServiceRepository {
    fun searchService(countryCode:String): Single<List<ServiceModel>>
}
