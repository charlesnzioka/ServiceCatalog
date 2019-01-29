package org.wfp.serviceprovision.ui.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.wfp.serviceprovision.R
import org.wfp.serviceprovision.repository.data.ServiceItemResult

class LogisticsItemsAdapter (context: Context?,
                             items: List<ServiceItemResult>,
                             itemClickListener:(ServiceItemResult)->Unit)
    : RecyclerView.Adapter<LogisticsItemViewHolder>(){
    private var logisticsItems: List<ServiceItemResult> = items
    private var context: Context? = context
    private val clickListener=itemClickListener

    private val VIEW_TYPE_STORAGE = 1
    private val VIEW_TYPE_EMPTY = 2
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogisticsItemViewHolder {
        when (viewType){
            VIEW_TYPE_EMPTY-> return LogisticsItemViewHolder(LayoutInflater.from(context).inflate(R.layout.empty_storage_item, parent, false))
            else ->return LogisticsItemViewHolder(LayoutInflater.from(context).inflate(R.layout.storage_item, parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        if(logisticsItems.isEmpty()){
            return VIEW_TYPE_EMPTY
        }
        return VIEW_TYPE_STORAGE
    }

    override fun getItemCount(): Int {
        if(logisticsItems.isEmpty()){
            return 1
        }
        return logisticsItems.size
    }

    override fun onBindViewHolder(holder: LogisticsItemViewHolder, position: Int) {
        if(getItemViewType(position)!=VIEW_TYPE_EMPTY)
            holder.bind(logisticsItems[position],clickListener)
    }

    fun getActualItemCount():Int{
        return logisticsItems.size
    }
}

class LogisticsItemViewHolder(view: View): RecyclerView.ViewHolder(view){

    fun bind(item: ServiceItemResult, clickListener:(ServiceItemResult)->Unit){

    }

}