package org.wfp.serviceprovision.ui.main

import androidx.lifecycle.MutableLiveData
import org.wfp.serviceprovision.model.ServiceItem
import org.wfp.serviceprovision.model.StorageServiceRequest
import org.wfp.serviceprovision.repository.service.ServiceRepository
import org.wfp.serviceprovision.ui.SingleLiveEvent
import org.wfp.serviceprovision.ui.base.AbstractViewModel

class MainViewModel(val serviceRepo: ServiceRepository):AbstractViewModel() {
    var storageRequestModel:StorageServiceRequest=StorageServiceRequest()
    val serviceEvent = SingleLiveEvent<ServiceEvent>()
    val uiData = MutableLiveData<ServiceUIModel>()

    fun createNewStorageRequest(country:String){
        storageRequestModel= StorageServiceRequest(country = country)
    }

    fun getAllServicesForCountry(country:String){
        launch{
            serviceEvent.value = ServiceEvent(isLoading = true)

            serviceRepo.searchService(country)
                    .subscribe({
                        serviceEvent.postValue(ServiceEvent(isSuccess = true))
                    },
                    {err->
                        serviceEvent.postValue(ServiceEvent(error = err))
                    })
        }


        //return serviceRepo.getAllServicesForCountry(country)
    }
}
data class ServiceUIModel(val items:List<ServiceItem>?= listOf())
data class ServiceEvent(val isLoading: Boolean = false, val isSuccess: Boolean = false, val error: Throwable? = null)