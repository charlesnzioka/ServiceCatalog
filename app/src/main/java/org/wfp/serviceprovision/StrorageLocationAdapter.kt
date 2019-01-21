package org.wfp.serviceprovision

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.location_item.view.*

class StorageLocationAdapter(context: Context?, locations:List<String>, itemClickListener: StorageLocationItemClickListener) :RecyclerView.Adapter<StorageLocationViewHolder>(),View.OnClickListener{

    private val context: Context? =context
    private var locationItems: List<String> = locations
    private val clickListener:StorageLocationItemClickListener=itemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StorageLocationViewHolder {
        return StorageLocationViewHolder(LayoutInflater.from(context).inflate(R.layout.location_item, parent, false))
    }

    override fun getItemCount(): Int {
        return locationItems.size
    }

    override fun onBindViewHolder(holder: StorageLocationViewHolder, position: Int) {
        holder?.location.text= locationItems[position]
        holder.itemView.setOnClickListener(this)
        holder.itemView.tag=locationItems[position]
    }

    override fun onClick(v: View?) {
        clickListener.onStorageLocationItemClick(v?.tag.toString())
    }

}

class StorageLocationViewHolder(view: View):RecyclerView.ViewHolder(view){
    val location=view.location_name
}