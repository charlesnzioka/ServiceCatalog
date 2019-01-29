package org.wfp.serviceprovision.ui.main.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.service_item.view.*
import org.wfp.serviceprovision.R
import org.wfp.serviceprovision.model.ServiceItem
import org.wfp.serviceprovision.model.ServiceModel
import org.wfp.serviceprovision.repository.data.ServiceItemResult
import org.wfp.serviceprovision.ui.main.ServiceViewHolder

class StorageItemsAdapter(context: Context?,
                          items: List<ServiceItemResult>,
                          itemClickListener:(ServiceItemResult)->Unit)
    :RecyclerView.Adapter<StorageItemViewHolder>(){
    private var storageItems: List<ServiceItemResult> = items
    private var context: Context? = context
    private val clickListener=itemClickListener

    private val VIEW_TYPE_STORAGE = 1
    private val VIEW_TYPE_EMPTY = 2
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StorageItemViewHolder {
        when (viewType){
            VIEW_TYPE_EMPTY-> return StorageItemViewHolder(LayoutInflater.from(context).inflate(R.layout.empty_storage_item, parent, false))
            else ->return StorageItemViewHolder(LayoutInflater.from(context).inflate(R.layout.storage_item, parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        if(storageItems.isEmpty()){
            return VIEW_TYPE_EMPTY
        }
        return VIEW_TYPE_STORAGE
    }

    override fun getItemCount(): Int {
        if(storageItems.isEmpty()){
            return 1
        }
       return storageItems.size
    }

    fun getActualItemCount():Int{
        return storageItems.size
    }

    override fun onBindViewHolder(holder: StorageItemViewHolder, position: Int) {
        if(getItemViewType(position)!=VIEW_TYPE_EMPTY)
            holder.bind(storageItems[position],clickListener)
    }
}

class StorageItemViewHolder(view: View): RecyclerView.ViewHolder(view){

    fun bind(item: ServiceItemResult, clickListener:(ServiceItemResult)->Unit){

    }

}