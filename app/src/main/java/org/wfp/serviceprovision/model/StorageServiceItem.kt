package org.wfp.serviceprovision.model

import org.wfp.serviceprovision.repository.data.ServiceItemResult

data class StorageServiceItem(val itemType:ServiceItemType, val storageItem: ServiceItemResult?) {
}