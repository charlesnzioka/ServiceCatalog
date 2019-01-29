package org.wfp.serviceprovision.ui.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.wfp.serviceprovision.R
import org.wfp.serviceprovision.repository.data.ServiceItemResult

class IMCoordinationItemsAdapter (context: Context?,
                                  items: List<ServiceItemResult>,
                                  itemClickListener:(ServiceItemResult)->Unit)
    : RecyclerView.Adapter<ImCoordinationItemViewHolder>(){
    private var imCoordinationItems: List<ServiceItemResult> = items
    private var context: Context? = context
    private val clickListener=itemClickListener

    private val VIEW_TYPE_STORAGE = 1
    private val VIEW_TYPE_EMPTY = 2
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImCoordinationItemViewHolder {
        when (viewType){
            VIEW_TYPE_EMPTY-> return ImCoordinationItemViewHolder(LayoutInflater.from(context).inflate(R.layout.empty_storage_item, parent, false))
            else ->return ImCoordinationItemViewHolder(LayoutInflater.from(context).inflate(R.layout.storage_item, parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        if(imCoordinationItems.isEmpty()){
            return VIEW_TYPE_EMPTY
        }
        return VIEW_TYPE_STORAGE
    }

    override fun getItemCount(): Int {
        if(imCoordinationItems.isEmpty()){
            return 1
        }
        return imCoordinationItems.size
    }

    override fun onBindViewHolder(holder: ImCoordinationItemViewHolder, position: Int) {
        if(getItemViewType(position)!=VIEW_TYPE_EMPTY)
            holder.bind(imCoordinationItems[position],clickListener)
    }

    fun getActualItemCount():Int{
        return imCoordinationItems.size
    }
}

class ImCoordinationItemViewHolder(view: View): RecyclerView.ViewHolder(view){

    fun bind(item: ServiceItemResult, clickListener:(ServiceItemResult)->Unit){

    }

}