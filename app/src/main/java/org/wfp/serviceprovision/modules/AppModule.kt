package org.wfp.serviceprovision.modules

import org.koin.dsl.module.module
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import org.wfp.serviceprovision.constants.Network


val appModule = module {

    // single instance of HelloRepository
    //single<HelloRepository> { HelloRepositoryImpl() }

    // Simple Presenter Factory
    //factory { MySimplePresenter(get()) }

}