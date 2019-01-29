package org.wfp.serviceprovision.repository.prefs

interface PreferencesHelper {
    fun getAccessToken():String?
    fun setAccessToken(token:String)
    fun setCurrentUserId(userId:String)
    fun deleteCurrentUser()
}