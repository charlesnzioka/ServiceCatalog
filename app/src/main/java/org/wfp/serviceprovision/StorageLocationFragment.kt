package org.wfp.serviceprovision

import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.storage_location_fragment.*
import androidx.recyclerview.widget.DividerItemDecoration



class StorageLocationFragment:Fragment(),StorageLocationItemClickListener {


    private var locations=ArrayList<String>()

    init {
        locations= arrayListOf<String>("Addis Ababa","Gondar","Mek'ele","Adama","Hawassa","Bahir Dar",
                "Dire Dawa" ,"Dessie","Jimma","Shashamane")
        locations.sort()
    }
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        //setHasOptionsMenu(true)
        return inflater.inflate(R.layout.storage_location_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        storage_locations_list.layoutManager= LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
        val decoration = DividerItemDecoration(this.context, HORIZONTAL)
        storage_locations_list.addItemDecoration(decoration)
        storage_locations_list.adapter=StorageLocationAdapter(this.context,locations,this)
    }


    override fun onStorageLocationItemClick(item: String) {
        NavHostFragment.findNavController(this).navigate(R.id.action_choose_storage_from_date,null)
    }
}


interface StorageLocationItemClickListener{
    fun onStorageLocationItemClick(item: String)
}