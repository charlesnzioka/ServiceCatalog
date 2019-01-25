package org.wfp.serviceprovision.repository.data

data class LoginResult(val email:String,
                       val first_name:String,
                       val last_name:String,
                       val phone:String,
                       val country:String,
                       val token:String) {
}