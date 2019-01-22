package org.wfp.serviceprovision.ui.main

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.service_item.view.*
import org.wfp.serviceprovision.R
import org.wfp.serviceprovision.model.ServiceItem

class ServicesListAdapter(context: Context?, items: List<ServiceItem>,itemClickListener:(ServiceItem)->Unit) :RecyclerView.Adapter<ServiceViewHolder>() {

    private var serviceItems: List<ServiceItem> = items
    private var context: Context? = context
    private val clickListener=itemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        return ServiceViewHolder(LayoutInflater.from(context).inflate(R.layout.service_item, parent, false))
    }

    override fun getItemCount(): Int {
        return serviceItems.size
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.bind(serviceItems[position],clickListener)
    }
}

class ServiceViewHolder(view:View):RecyclerView.ViewHolder(view){
    private val colors= arrayOf("#fd6925","#c5192d","#F7B825","#8AD220")

    fun bind(item:ServiceItem,clickListener:(ServiceItem)->Unit){
        itemView.service_item_desc.text= item.name
        itemView.service_item_header.text= item.name[0].toString().toUpperCase()
        val color = Color.parseColor(colors[item.id.ordinal])
        itemView.service_item_header.setTextColor(color)
        itemView.setOnClickListener{clickListener(item)}
    }

}

