package org.wfp.serviceprovision

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.storage_from_date_fragment.*
import java.util.*

class StorageFromDateFragment:Fragment(), CalendarView.OnDateChangeListener {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View?  {
        super.onCreate(savedInstanceState)
        return inflater.inflate(R.layout.storage_from_date_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        storage_from_date.minDate=Calendar.getInstance().timeInMillis
        storage_from_date.setOnDateChangeListener(this)
    }

    override fun onSelectedDayChange(view: CalendarView, year: Int, month: Int, dayOfMonth: Int) {
        NavHostFragment.findNavController(this).navigate(R.id.action_choose_storage_to_date,null)
    }

}