package org.wfp.serviceprovision.model

data class ServiceModel(val name:String,
                   val description:String,
                   val country:List<String>,
                   val serviceType:ServiceType,
                   val isActive:Boolean) {
}