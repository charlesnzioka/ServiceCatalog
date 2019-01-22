package org.wfp.serviceprovision.services

import org.wfp.serviceprovision.model.ServiceItem
import org.wfp.serviceprovision.model.ServiceType

class ServiceRepository {
    fun getAllServicesForCountry(country:String):List<ServiceItem>{
        //Hard coded for now
        var services: ArrayList<ServiceItem> = ArrayList()
        services.add(ServiceItem(ServiceType.IM_COORDINATION, "IM & Coordination"))
        services.add(ServiceItem(ServiceType.PROCUREMENT, "Procurement"))
        services.add(ServiceItem(ServiceType.STORAGE, "Storage"))
        services.add(ServiceItem(ServiceType.TRANSPORT, "Transportation"))
        return services
    }
}