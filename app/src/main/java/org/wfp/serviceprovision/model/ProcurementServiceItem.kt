package org.wfp.serviceprovision.model

import org.wfp.serviceprovision.repository.data.ServiceItemResult

data class ProcurementServiceItem(val itemType:ServiceItemType, val procurementItem: ServiceItemResult?) {
}