package org.wfp.serviceprovision

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.wfp.serviceprovision.modules.appModule
import org.wfp.serviceprovision.modules.viewModelModule

class ServiceProvisionApp:Application() {

    override fun onCreate() {
        super.onCreate()

        //start koin
        startKoin(this, listOf(appModule, viewModelModule))
    }
}