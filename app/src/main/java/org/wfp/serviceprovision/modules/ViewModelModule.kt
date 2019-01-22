package org.wfp.serviceprovision.modules

import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import org.wfp.serviceprovision.services.ServiceRepository
import org.wfp.serviceprovision.ui.main.MainViewModel

val viewModelModule = module {

    single{ServiceRepository()}
    viewModel {MainViewModel(get())}
}