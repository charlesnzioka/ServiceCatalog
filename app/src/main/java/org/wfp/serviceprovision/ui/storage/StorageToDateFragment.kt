package org.wfp.serviceprovision.ui.storage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.storage_to_date_fragment.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.wfp.serviceprovision.R
import org.wfp.serviceprovision.ui.main.MainViewModel
import java.util.*

class StorageToDateFragment:Fragment(),CalendarView.OnDateChangeListener {
    private val viewModel by sharedViewModel<MainViewModel>()
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View?  {
        super.onCreate(savedInstanceState)
        return inflater.inflate(R.layout.storage_to_date_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        storage_to_date.minDate= Calendar.getInstance().timeInMillis
        storage_to_date.setOnDateChangeListener(this)
    }

    override fun onSelectedDayChange(view: CalendarView, year: Int, month: Int, dayOfMonth: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}