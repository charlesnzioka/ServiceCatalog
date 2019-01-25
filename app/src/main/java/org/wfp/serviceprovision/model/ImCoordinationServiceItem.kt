package org.wfp.serviceprovision.model

import org.wfp.serviceprovision.repository.data.ServiceItemResult

data class ImCoordinationServiceItem(val itemType:ServiceItemType, val imCoordinationServiceItem: ServiceItemResult?) {
}