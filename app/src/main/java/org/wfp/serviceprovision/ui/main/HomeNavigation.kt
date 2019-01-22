package org.wfp.serviceprovision.ui.main

import org.wfp.serviceprovision.model.ServiceItem

interface HomeNavigation {
    fun navToStoragecategory()

    fun onServiceItemClick(item: ServiceItem)
}