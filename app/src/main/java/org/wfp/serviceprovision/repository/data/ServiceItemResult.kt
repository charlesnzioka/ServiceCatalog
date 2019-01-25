package org.wfp.serviceprovision.repository.data

data class ServiceItemResult(val name:String,
                             val description:String,
                             val country:List<String>,
                             val service_type:ServiceTypeResult,
                             val is_active:Boolean) {
}