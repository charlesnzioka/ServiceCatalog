package org.wfp.serviceprovision.modules

import android.app.Application
import org.koin.dsl.module.module
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.wfp.serviceprovision.constants.Network
import org.wfp.serviceprovision.repository.prefs.AppPreferencesHelper
import org.wfp.serviceprovision.repository.prefs.PreferencesHelper


val appModule = module {
    single{androidApplication()}
    single{ AppPreferencesHelper(get()) }
}