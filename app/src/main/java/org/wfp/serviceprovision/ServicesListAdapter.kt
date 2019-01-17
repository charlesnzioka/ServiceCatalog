package org.wfp.serviceprovision

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.service_item.view.*
import org.wfp.serviceprovision.org.wfp.serviceprovision.model.ServiceItem
import java.util.*

class ServicesListAdapter(context: Context?, items: List<ServiceItem>) :RecyclerView.Adapter<ServiceViewHolder>() {
    private var serviceItems: List<ServiceItem> = items
    private var context: Context? = context
    private val colors= arrayOf("#fd6925","#c5192d","#F7B825","#8AD220")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        return ServiceViewHolder(LayoutInflater.from(context).inflate(R.layout.service_item, parent, false))
    }

    override fun getItemCount(): Int {
        return serviceItems.size
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder?.serviceHeader.text= serviceItems[position].name[0].toString().toUpperCase()
        holder?.serviceDescription.text= serviceItems[position].name
        val color = Color.parseColor(colors[position])
        holder.itemView.setBackgroundColor(color)
    }
}

class ServiceViewHolder(view:View):RecyclerView.ViewHolder(view){
    val serviceDescription=view.service_item_desc
    val serviceHeader=view.service_item_header
}