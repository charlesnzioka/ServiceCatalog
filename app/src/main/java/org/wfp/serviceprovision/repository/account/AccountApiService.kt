package org.wfp.serviceprovision.repository.account

import io.reactivex.Single
import org.wfp.serviceprovision.constants.ApiEndpoints
import org.wfp.serviceprovision.repository.data.LoginModel
import org.wfp.serviceprovision.repository.data.LoginResult
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AccountApiService {

    @Headers("Content-Type: application/json","accept:application/json")
    @POST(ApiEndpoints.LOGIN_ENDPOINT)
    fun login(@Body loginModel: LoginModel): Single<LoginResult>
}