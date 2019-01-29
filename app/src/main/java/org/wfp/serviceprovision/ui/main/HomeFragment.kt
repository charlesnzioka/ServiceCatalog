package org.wfp.serviceprovision.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.ActivityNavigator
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.im_coordination_mini_layout.*
import kotlinx.android.synthetic.main.logistics_mini_layout.*
import kotlinx.android.synthetic.main.procurement_mini_layout.*
import kotlinx.android.synthetic.main.storage_mini_layout.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.wfp.serviceprovision.R
import org.wfp.serviceprovision.model.ServiceItem
import org.wfp.serviceprovision.model.ServiceType
import org.wfp.serviceprovision.repository.data.ServiceItemResult
import org.wfp.serviceprovision.ui.account.AccountActivity
import org.wfp.serviceprovision.ui.main.adapters.IMCoordinationItemsAdapter
import org.wfp.serviceprovision.ui.main.adapters.LogisticsItemsAdapter
import org.wfp.serviceprovision.ui.main.adapters.ProcurementItemsAdapter
import org.wfp.serviceprovision.ui.main.adapters.StorageItemsAdapter


class HomeFragment:Fragment(), HomeNavigation {


    private val viewModel by sharedViewModel<MainViewModel>()
    private lateinit var storageAdapter:StorageItemsAdapter
    private lateinit var procurementAdapter:ProcurementItemsAdapter
    private lateinit var imCoordinationAdapter:IMCoordinationItemsAdapter
    private lateinit var logisticsAdapter:LogisticsItemsAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        if(viewModel.isAccountExpired()){
            viewModel.resetCredentials()
            navigateToLoginPage()
        }
        return inflater.inflate(R.layout.home_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        storage_list.layoutManager= LinearLayoutManager(this.context)
        procurement_list.layoutManager=LinearLayoutManager(this.context)
        logistics_list.layoutManager=LinearLayoutManager(this.context)
        im_coordination_list.layoutManager=LinearLayoutManager(this.context)

        //Hard coded to ethiopia for the moment
        viewModel.getAllServicesForCountry("ET")
        viewModel.serviceEvent.observe(this, Observer { serviceEvent->
            if(!serviceEvent.isLoading && serviceEvent.error!=null){
                Toast.makeText(this.activity, serviceEvent.error.message,Toast.LENGTH_LONG).show()
            }
            else if(!serviceEvent.isLoading && serviceEvent.result!=null && serviceEvent.isSuccess){
                //load the service list to ui
                initAdapters()
                storage_list.adapter=storageAdapter
                procurement_list.adapter=procurementAdapter
                logistics_list.adapter=logisticsAdapter
                im_coordination_list.adapter=imCoordinationAdapter
                showOnlySegmentsWithData()
            }
        })
        /*services_list.adapter= ServicesListAdapter(
                this.context,
                viewModel.getAllServicesForCountry("KE"), {item:ServiceItem->onServiceItemClick(item)}
        )*/

    }


    private fun initAdapters(){
        storageAdapter=StorageItemsAdapter(this.activity, viewModel.getStorageServiceItems()) { item: ServiceItemResult ->onServiceItemClick(item)}
        procurementAdapter=ProcurementItemsAdapter(this.activity, viewModel.getProcurementServiceItems()) { item: ServiceItemResult ->onServiceItemClick(item)}
        logisticsAdapter=LogisticsItemsAdapter(this.activity, viewModel.getLogisticsServiceItems()) { item: ServiceItemResult ->onServiceItemClick(item)}
        imCoordinationAdapter=IMCoordinationItemsAdapter(this.activity, viewModel.getImCoordinationServiceItems()) { item: ServiceItemResult ->onServiceItemClick(item)}

    }

    fun showOnlySegmentsWithData(){
        if(storageAdapter.getActualItemCount()==0)
            storage_seg.visibility=View.GONE
        else
            storage_seg.visibility=View.VISIBLE
        if(procurementAdapter.getActualItemCount()==0)
            procurement_seg.visibility=View.GONE
        else
            procurement_seg.visibility=View.VISIBLE
        if(logisticsAdapter.getActualItemCount()==0)
            logistics_seg.visibility=View.GONE
        else
            logistics_seg.visibility=View.VISIBLE

        if(imCoordinationAdapter.getActualItemCount()==0)
            im_coord_seg.visibility=View.GONE
        else
            im_coord_seg.visibility=View.VISIBLE
    }


    override fun onServiceItemClick(item: ServiceItemResult) {
        when (item.service_type.name){
            "Storage"->{
                viewModel.createNewStorageRequest("Ethiopia")
                navToStoragecategory()
            }
            "IM &Coordination"->{

            }
            "Procurement"->{

            }
            "Logistics"->{

            }
        }
    }

    override fun navToStoragecategory() {
        findNavController(this).navigate(R.id.choose_storage_category,null)
    }

    private fun navigateToLoginPage(){
        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }
        var navigator= ActivityNavigator(this.context!!)
        var dest=navigator.createDestination()
        dest.intent = Intent(this.context,AccountActivity::class.java)
        navigator.navigate(dest,null,options,null)
        this.activity?.finish()
    }
}