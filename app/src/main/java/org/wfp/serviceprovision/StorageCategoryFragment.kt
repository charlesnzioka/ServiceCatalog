package org.wfp.serviceprovision

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.storage_category_fragment.*
import org.wfp.serviceprovision.org.wfp.serviceprovision.model.StorageCategory

class StorageCategoryFragment :Fragment(), StorageCategoryItemClickListener{
    private var categories: ArrayList<StorageCategory> = ArrayList()
    init {
        addCategories()
    }
    override fun onStorageItemClick(item: StorageCategory) {
        when(item.id){
            1L,2L,3L,4L->{
                NavHostFragment.findNavController(this).navigate(R.id.action_choose_storage_location,null)
            }
        }
    }



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        //setHasOptionsMenu(true)
        return inflater.inflate(R.layout.storage_category_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        storage_category_list.layoutManager= GridLayoutManager(this.context,2)
        storage_category_list.adapter=StorageCategoryListAdapter(this.context,categories,this)

    }

    private fun addCategories(){
        categories.add(StorageCategory(1L,"Food"))
        categories.add(StorageCategory(2L,"Medical Supplies"))
        categories.add(StorageCategory(3L,"Non Perishable Items"))
        categories.add(StorageCategory(4L,"Other"))
    }
}

interface StorageCategoryItemClickListener{
    fun onStorageItemClick(item:StorageCategory)
}