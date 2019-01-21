package org.wfp.serviceprovision

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.service_item.view.*
import org.wfp.serviceprovision.org.wfp.serviceprovision.model.StorageCategory

class StorageCategoryListAdapter(context: Context?, items: List<StorageCategory>, itemClickListener: StorageCategoryItemClickListener):RecyclerView.Adapter<CategoryViewHolder>(), View.OnClickListener {


    private var categoryItems: List<StorageCategory> = items
    private var context: Context? = context
    private val colors= arrayOf("#fd6925","#c5192d","#F7B825","#8AD220")
    private val categoryItemClickListener:StorageCategoryItemClickListener=itemClickListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.service_item, parent, false))
    }

    override fun getItemCount(): Int {
        return categoryItems.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder?.categoryHeader.text= categoryItems[position].category[0].toString().toUpperCase()
        holder?.categoryDescription.text= categoryItems[position].category
        val color = Color.parseColor(colors[position])
        holder.itemView.setBackgroundColor(color)
        holder.itemView.tag=categoryItems[position].id
        holder.itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        categoryItemClickListener.onStorageItemClick(categoryItems[(v?.tag as Long).toInt()-1])
    }
}

class CategoryViewHolder(view: View):RecyclerView.ViewHolder(view){
    val categoryDescription=view.service_item_desc
    val categoryHeader=view.service_item_header
}