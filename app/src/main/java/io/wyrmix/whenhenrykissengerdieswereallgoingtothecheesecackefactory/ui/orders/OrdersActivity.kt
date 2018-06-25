package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.orders

import android.Manifest
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.databinding.DataBindingUtil
import android.graphics.drawable.InsetDrawable
import android.support.v7.widget.LinearLayoutManager
import java.util.*
import javax.inject.Inject
import devs.mulham.horizontalcalendar.HorizontalCalendar
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.android.view.decorators.DividerItemDecorator
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.R
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.di.ActivityComponent
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.base.BaseActivity


/**
 * Created by Alexander Melton on 6/18/2018.
 */
class OrdersActivity: BaseActivity(){

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var ordersViewModel: OrdersViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ordersViewModel = ViewModelProviders.of(this, viewModelFactory).get(OrdersViewModel::class.java)
        val binding: ActivityOrdersBinding = DataBindingUtil.setContentView(this, R.layout.activity_orders)
        recyclerView = binding.dropoffRecyclerView

        setupRecyclerView()
        checkForLocationPermission()
        buildCalendar()

        ordersViewModel.viewmodeldata.observe(this, Observer { binding.viewmodel = it })
        ordersViewModel.getDropOffs()
    }

    fun buildCalendar(){
        /* starts before 1 month from now */
        val startDate = Calendar.getInstance()
        startDate.add(Calendar.MONTH, -1)

        /* ends after 1 month from now */
        val endDate = Calendar.getInstance()
        endDate.add(Calendar.MONTH, 1)

        val horizontalCalendar = HorizontalCalendar.Builder(this, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build()

        horizontalCalendar.calendarListener = object : HorizontalCalendarListener() {
            override fun onDateSelected(date: Calendar, position: Int) {
                ordersViewModel.selectDay(date)
            }
        }

    }

    fun setupRecyclerView(){
        recyclerView.adapter = ordersViewModel.viewmodeldata.value?.adapter
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val spacer =  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 120f, resources.displayMetrics)
        val inset = InsetDrawable(getDrawable(R.drawable.divider), spacer.toInt(), 0, 0, 0)
        val divider = DividerItemDecorator(inset)
        recyclerView.addItemDecoration(divider)
    }

    fun checkForLocationPermission(){
        if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    0)
        } else {
            // Permission has already been granted
            ordersViewModel.getLocation(this)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            0 -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // permission was granted
                    ordersViewModel.getLocation(this)
                } else {
                    // permission denied
                }
                return
            }
        }
    }

    override fun injectSelf(component: ActivityComponent) = component.inject(this)
}