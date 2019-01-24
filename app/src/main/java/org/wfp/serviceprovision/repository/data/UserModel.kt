package org.wfp.serviceprovision.repository.data

data class UserModel(val email:String,
                     val first_name:String,
                     val last_name:String,
                     val phone:String,
                     val organization:String,
                     val country:String) {
}