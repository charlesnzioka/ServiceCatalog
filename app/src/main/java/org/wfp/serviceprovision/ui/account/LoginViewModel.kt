package org.wfp.serviceprovision.ui.account

import androidx.lifecycle.MutableLiveData
import org.wfp.serviceprovision.repository.account.AccountRepository
import org.wfp.serviceprovision.repository.data.LoginModel
import org.wfp.serviceprovision.ui.SingleLiveEvent
import org.wfp.serviceprovision.ui.base.AbstractViewModel

class LoginViewModel(val accountRepo: AccountRepository):AbstractViewModel() {
    val loginEvent = SingleLiveEvent<LoginEvent>()
    val uiData = MutableLiveData<LoginUIModel>()
    fun login(email:String,password: String){
        launch{
            loginEvent.value = LoginEvent(isLoading = true)
            accountRepo.login(LoginModel(email=email,username=email,password = password)).subscribe({
                loginEvent.postValue(LoginEvent(isSuccess = true))
            },{
                err->loginEvent.postValue(LoginEvent(error = err))
            })
        }
    }
}

data class LoginUIModel(val email:String, val password:String)
data class LoginEvent(val isLoading: Boolean = false, val isSuccess: Boolean = false, val error: Throwable? = null)
//https://github.com/Ekito/koin-samples/blob/master/samples/android-weatherapp-mvvm/app/src/main/kotlin/org/koin/sampleapp/view/search/SearchViewModel.kt