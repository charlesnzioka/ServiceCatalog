package org.wfp.serviceprovision.repository.account

import io.reactivex.Single
import org.wfp.serviceprovision.repository.data.LoginModel
import org.wfp.serviceprovision.repository.data.LoginResult

class AccountRepositoryImpl(private val accountApiService:AccountApiService):AccountRepository{
    override fun login(loginModel:LoginModel): Single<LoginResult> =accountApiService.login(loginModel)
}