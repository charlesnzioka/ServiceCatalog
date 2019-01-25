package org.wfp.serviceprovision.repository.prefs

import android.content.Context
import android.content.SharedPreferences
import org.wfp.serviceprovision.constants.AppPreferences

class AppPreferencesHelper (context: Context) :PreferencesHelper{
    var mPrefs:SharedPreferences=context.getSharedPreferences(AppPreferences.APP_PREF_NAME,Context.MODE_PRIVATE)

    override fun getAccessToken(): String? {
        return mPrefs.getString(AppPreferences.PREF_KEY_ACCESS_TOKEN,null)
    }

    override fun setAccessToken(token: String) {
        mPrefs.edit().putString(AppPreferences.PREF_KEY_ACCESS_TOKEN,token).apply()
    }

    override fun setCurrentUserId(userId: String) {
        mPrefs.edit().putString(AppPreferences.PREF_KEY_CURRENT_USER_ID,userId).apply()
    }

}