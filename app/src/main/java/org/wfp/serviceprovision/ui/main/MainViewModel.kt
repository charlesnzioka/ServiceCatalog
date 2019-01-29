package org.wfp.serviceprovision.ui.main

import androidx.lifecycle.MutableLiveData
import org.wfp.serviceprovision.model.ServiceItem
import org.wfp.serviceprovision.model.ServiceModel
import org.wfp.serviceprovision.model.StorageServiceRequest
import org.wfp.serviceprovision.repository.account.AccountRepository
import org.wfp.serviceprovision.repository.account.AccountRepositoryImpl
import org.wfp.serviceprovision.repository.data.ServiceItemResult
import org.wfp.serviceprovision.repository.data.ServicesResult
import org.wfp.serviceprovision.repository.prefs.AppPreferencesHelper
import org.wfp.serviceprovision.repository.service.ServiceRepository
import org.wfp.serviceprovision.ui.SingleLiveEvent
import org.wfp.serviceprovision.ui.base.AbstractViewModel

class MainViewModel(val serviceRepo: ServiceRepository, val accountRepo: AccountRepository, val appPreferencesHelper: AppPreferencesHelper):AbstractViewModel() {
    var storageRequestModel:StorageServiceRequest=StorageServiceRequest()
    val serviceEvent = SingleLiveEvent<ServiceEvent>()
    val uiData = MutableLiveData<ServiceUIModel>()
    var services= listOf<ServiceItemResult>()

    fun createNewStorageRequest(country:String){
        storageRequestModel= StorageServiceRequest(country = country)
    }

    fun getAllServicesForCountry(country:String){
        launch{
            serviceEvent.value = ServiceEvent(isLoading = true)

            serviceRepo.searchService(country)
                    .subscribe({
                        serviceEvent.postValue(ServiceEvent(isSuccess = true,result = it))
                        this.services=it.services
                        //uiData.postValue(ServiceUIModel(it.services))
                        //uiData..items=it.services
                    },
                    {err->
                        serviceEvent.postValue(ServiceEvent(error = err))
                    })
        }

    }
    fun getStorageServiceItems():List<ServiceItemResult>{
        var items=services.filter { x->x.service_type.name.equals("Storage",true) }
        if(items!=null)
            return items
        return listOf()
    }

    fun getProcurementServiceItems():List<ServiceItemResult>{
         var items=services.filter { x->x.service_type.name.equals("Procurement",true) }
        if(items!=null)
            return items
        return listOf()
    }

    fun getImCoordinationServiceItems():List<ServiceItemResult>{
        var items= services.filter { x->x.service_type.name.equals("IM & Coordination",true) }
        if(items!=null)
            return items
        return listOf()
    }

    fun getLogisticsServiceItems():List<ServiceItemResult>{
        var items= services.filter { x->x.service_type.name.equals("Logistics",true) }
        if(items!=null)
            return items
        return listOf()
    }

    fun isAccountExpired():Boolean{
        return accountRepo.isUserTokenExpired()
    }

    fun resetCredentials(){
        appPreferencesHelper.deleteCurrentUser()
    }
}
data class ServiceUIModel(var items:List<ServiceItemResult>?= listOf())
data class ServiceEvent(val isLoading: Boolean = false, val isSuccess: Boolean = false, val error: Throwable? = null,val result:ServicesResult?=null)