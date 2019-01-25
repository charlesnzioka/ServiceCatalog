package org.wfp.serviceprovision.repository.service

import io.reactivex.Single
import org.wfp.serviceprovision.repository.data.ServicesResult

interface ServiceRepository {
    fun searchService(countryCode:String): Single<ServicesResult>
}
