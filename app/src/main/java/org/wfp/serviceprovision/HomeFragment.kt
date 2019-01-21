package org.wfp.serviceprovision

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.home_fragment.*
import org.wfp.serviceprovision.org.wfp.serviceprovision.model.ServiceItem


class HomeFragment:Fragment(), ServiceItemClickListener {
    private val services: ArrayList<ServiceItem> = ArrayList()
    init {
        addServices()
    }
    override fun onServiceItemClick(item: ServiceItem) {
        when (item.id){
            1L,2L,4L->{
                Toast.makeText(this.context,"To be implemented",Toast.LENGTH_LONG).show()
            }

            3L->{
                findNavController(this).navigate(R.id.choose_storage_category,null)
            }

        }
    }



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

        //addServices()
        services_list.layoutManager=GridLayoutManager(this.context,2)
        services_list.adapter=ServicesListAdapter(
                this.context,
                services,this
        )

    }

    private fun addServices(){
        services.add(ServiceItem(1L,"IM & Coordination"))
        services.add(ServiceItem(2L,"Procurement"))
        services.add(ServiceItem(3L,"Storage"))
        services.add(ServiceItem(4L,"Transportation"))
    }


}

interface ServiceItemClickListener{
    fun onServiceItemClick(item:ServiceItem)
}