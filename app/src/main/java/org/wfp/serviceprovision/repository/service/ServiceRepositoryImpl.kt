package org.wfp.serviceprovision.repository.service

import io.reactivex.Single
import org.wfp.serviceprovision.repository.data.ServicesResult
import org.wfp.serviceprovision.repository.prefs.AppPreferencesHelper

class ServiceRepositoryImpl(private val servicesApiService: ServicesApiService,private val appPreferencesHelper: AppPreferencesHelper) : ServiceRepository {
    override fun searchService(countryCode: String): Single<ServicesResult> {

        return servicesApiService.getServices("JWT "+appPreferencesHelper.getAccessToken()!!,countryCode)
    }
}