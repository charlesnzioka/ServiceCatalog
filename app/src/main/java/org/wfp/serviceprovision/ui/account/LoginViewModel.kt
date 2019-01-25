package org.wfp.serviceprovision.ui.account

import androidx.lifecycle.MutableLiveData
import org.wfp.serviceprovision.repository.account.AccountRepository
import org.wfp.serviceprovision.repository.data.LoginModel
import org.wfp.serviceprovision.repository.data.LoginResult
import org.wfp.serviceprovision.repository.prefs.AppPreferencesHelper
import org.wfp.serviceprovision.ui.SingleLiveEvent
import org.wfp.serviceprovision.ui.base.AbstractViewModel
import java.util.regex.Pattern

class LoginViewModel(val accountRepo: AccountRepository,
                     val appPreferencesHelper: AppPreferencesHelper):AbstractViewModel() {
    val loginEvent = SingleLiveEvent<LoginEvent>()
    val uiData = MutableLiveData<LoginUIModel>()
    fun login(email:String,password: String){
        launch{
            loginEvent.value = LoginEvent(isLoading = true)
            accountRepo.login(LoginModel(email=email,username=email,password = password)).subscribe({
                loginEvent.postValue(LoginEvent(isSuccess = true,result = it))
            },{
                err->loginEvent.postValue(LoginEvent(error = err))
            })
        }
    }

    fun validEmailAndPassword(email:String,password:String):Boolean{
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        val pattern:Pattern=Pattern.compile(emailPattern)
        if(!pattern.matcher(email).matches()){
            loginEvent.postValue(LoginEvent(error=Throwable("Invalid email address")))
            return false
        }
        if(password==null || password.isEmpty()){
            loginEvent.postValue(LoginEvent(error=Throwable("Invalid password")))
            return false
        }
        return true
    }

    fun addCurrentUserToPreferences(currentUser:LoginResult){
        appPreferencesHelper.setAccessToken(currentUser.token)
        appPreferencesHelper.setCurrentUserId(currentUser.email)
    }

    fun getCurrentUser():String?{
        return appPreferencesHelper.getAccessToken()
    }
}

data class LoginUIModel(val email:String, val password:String)
data class LoginEvent(val isLoading: Boolean = false, val isSuccess: Boolean = false, val error: Throwable? = null,val result: LoginResult?=null)
//https://github.com/Ekito/koin-samples/blob/master/samples/android-weatherapp-mvvm/app/src/main/kotlin/org/koin/sampleapp/view/search/SearchViewModel.kt