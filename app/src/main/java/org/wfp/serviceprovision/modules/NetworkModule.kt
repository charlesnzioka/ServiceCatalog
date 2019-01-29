package org.wfp.serviceprovision.modules

import com.google.gson.GsonBuilder
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import org.wfp.serviceprovision.constants.Network
import org.wfp.serviceprovision.repository.account.AccountApiService
import org.wfp.serviceprovision.repository.account.AccountRepository
import org.wfp.serviceprovision.repository.account.AccountRepositoryImpl
import org.wfp.serviceprovision.repository.service.ServiceRepository
import org.wfp.serviceprovision.repository.service.ServiceRepositoryImpl
import org.wfp.serviceprovision.repository.service.ServicesApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val remoteDatasourceModule = module {
    // provided web components
    single { createOkHttpClient() }
    // Fill property
    single { createWebService<ServicesApiService>(get(), Network.BASE_URL) }

    single { createWebService<AccountApiService>(get(), Network.BASE_URL) }

    single<ServiceRepository>{ ServiceRepositoryImpl(get(),get()) }

    single<AccountRepository>{ AccountRepositoryImpl(get(),get()) }
}

fun createOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
            .connectTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS).build()
}


inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
    val retrofit = Retrofit.Builder().baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(okHttpClient)
            .build()
    return retrofit.create(T::class.java)
}