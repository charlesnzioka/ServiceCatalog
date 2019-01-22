package org.wfp.serviceprovision.ui.main

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.wfp.serviceprovision.R
import org.wfp.serviceprovision.model.ServiceItem
import org.wfp.serviceprovision.model.ServiceType


class HomeFragment:Fragment(), HomeNavigation {
    private val viewModel by sharedViewModel<MainViewModel>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        //setHasOptionsMenu(true)
        return inflater.inflate(R.layout.home_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        services_list.layoutManager= GridLayoutManager(this.context,2)
        services_list.adapter= ServicesListAdapter(
                this.context,
                viewModel.getAllServicesForCountry("Ethiopia"), {item:ServiceItem->onServiceItemClick(item)}
        )

    }

    override fun onServiceItemClick(item: ServiceItem) {
        when (item.id){
            ServiceType.IM_COORDINATION,ServiceType.PROCUREMENT,ServiceType.TRANSPORT->{
                Toast.makeText(this.context,"To be implemented",Toast.LENGTH_LONG).show()
            }

            ServiceType.STORAGE->{
                //TODO: For the time being the only country supported is ehtiopia
                viewModel.createNewStorageRequest("Ethiopia")
                navToStoragecategory()
            }

        }
    }

    override fun navToStoragecategory() {
        findNavController(this).navigate(R.id.choose_storage_category,null)
    }
}