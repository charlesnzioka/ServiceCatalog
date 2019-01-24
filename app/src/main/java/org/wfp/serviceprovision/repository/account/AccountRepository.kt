package org.wfp.serviceprovision.repository.account

import io.reactivex.Single
import org.wfp.serviceprovision.repository.data.LoginModel
import org.wfp.serviceprovision.repository.data.LoginResult

interface AccountRepository {
    fun login(loginModel:LoginModel): Single<LoginResult>
}