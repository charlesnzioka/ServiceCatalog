package org.wfp.serviceprovision.repository.account

import com.auth0.android.jwt.JWT
import io.reactivex.Single
import org.wfp.serviceprovision.repository.data.LoginModel
import org.wfp.serviceprovision.repository.data.LoginResult
import org.wfp.serviceprovision.repository.prefs.AppPreferencesHelper

class AccountRepositoryImpl(private val accountApiService:AccountApiService,private val appPreferencesHelper: AppPreferencesHelper):AccountRepository{
    override fun isUserTokenExpired():Boolean {
        var jwt:JWT= JWT(appPreferencesHelper.getAccessToken()!!)
        return jwt.isExpired(10)
    }

    override fun login(loginModel:LoginModel): Single<LoginResult> =accountApiService.login(loginModel)
}