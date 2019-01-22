package org.wfp.serviceprovision.ui.storage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.storage_category_fragment.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.wfp.serviceprovision.R
import org.wfp.serviceprovision.model.StorageCategory
import org.wfp.serviceprovision.model.StorageCategoryType
import org.wfp.serviceprovision.ui.main.MainViewModel
import org.wfp.serviceprovision.ui.storage.adapters.StorageCategoryListAdapter

class StorageCategoryFragment :Fragment(), StorageCategoryItemClickListener {
    private var categories: ArrayList<StorageCategory> = ArrayList()
    private val viewModel by sharedViewModel<MainViewModel>()
    init {
        addCategories()
    }
    override fun onStorageItemClick(item: StorageCategory) {
        viewModel.storageRequestModel.storageCategoryType=item.id
        NavHostFragment.findNavController(this).navigate(R.id.action_choose_storage_location,null)
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
        storage_category_list.adapter= StorageCategoryListAdapter(this.context, categories, this)

    }

    private fun addCategories(){
        categories.add(StorageCategory(StorageCategoryType.FOOD, "Food"))
        categories.add(StorageCategory(StorageCategoryType.MEDICALS, "Medical Supplies"))
        categories.add(StorageCategory(StorageCategoryType.NONPERISHABLES, "Non Perishable Items"))
        categories.add(StorageCategory(StorageCategoryType.OTHER, "Other"))
    }
}

interface StorageCategoryItemClickListener{
    fun onStorageItemClick(item: StorageCategory)
}