package org.wfp.serviceprovision.ui.main

import org.wfp.serviceprovision.model.ServiceItem
import org.wfp.serviceprovision.repository.data.ServiceItemResult

interface HomeNavigation {
    fun navToStoragecategory()

    fun onServiceItemClick(item: ServiceItemResult)
}