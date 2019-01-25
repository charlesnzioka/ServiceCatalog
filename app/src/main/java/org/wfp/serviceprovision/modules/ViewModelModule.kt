package org.wfp.serviceprovision.modules

import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import org.wfp.serviceprovision.repository.prefs.AppPreferencesHelper
import org.wfp.serviceprovision.repository.prefs.PreferencesHelper
import org.wfp.serviceprovision.ui.account.LoginViewModel
import org.wfp.serviceprovision.ui.main.MainViewModel

val viewModelModule = module {

    viewModel {MainViewModel(get())}
    viewModel { LoginViewModel(get(),get()) }
}