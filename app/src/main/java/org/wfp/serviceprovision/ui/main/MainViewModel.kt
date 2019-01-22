package org.wfp.serviceprovision.ui.main

import androidx.lifecycle.ViewModel
import org.wfp.serviceprovision.model.ServiceItem
import org.wfp.serviceprovision.model.StorageServiceRequest
import org.wfp.serviceprovision.services.ServiceRepository

class MainViewModel(val serviceRepo: ServiceRepository):ViewModel() {
    var storageRequestModel:StorageServiceRequest=StorageServiceRequest()

    fun createNewStorageRequest(country:String){
        storageRequestModel= StorageServiceRequest(country = country)
    }

    fun getAllServicesForCountry(country:String):List<ServiceItem >{
        return serviceRepo.getAllServicesForCountry(country)
    }
}