package org.wfp.serviceprovision.model

import java.util.*

data class StorageServiceRequest(var serviceType:ServiceType=ServiceType.STORAGE,
                                 var storageCategoryType:StorageCategoryType=StorageCategoryType.OTHER,
                                 var location:String="",
                                 var country:String="",
                                 var fromDate:Date=Date(),
                                 var toDate:Date=Date()){
}