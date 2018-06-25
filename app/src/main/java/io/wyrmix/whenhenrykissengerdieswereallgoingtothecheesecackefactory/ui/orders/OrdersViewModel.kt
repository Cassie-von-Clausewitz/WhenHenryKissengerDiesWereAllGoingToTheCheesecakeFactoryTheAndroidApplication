package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.orders

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.location.Address
import drivechain.logger.Logger
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.model.Dropoff
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.domain.exceptions.Failure
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.domain.interactor.UseCase
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.domain.interactor.dropoff.GetDropoffs
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.domain.interactor.location.GetLocation
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.extensions.address
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.base.BaseViewModel
import java.util.*
import javax.inject.Inject

/**
 * Created by Alexander Melton on 6/18/2018.
 */
class OrdersViewModel @Inject internal constructor(
        private val getDropoffs: GetDropoffs,
        private val getLocation: GetLocation,
        private val logger: Logger
): BaseViewModel(){

    var viewmodeldata: MutableLiveData<OrdersView> = MutableLiveData()

    init {
        viewmodeldata.value = OrdersView()
    }

    fun getDropOffs(){
        getDropoffs.execute({
            it.either(::handleFailure, ::handleDropOffs)
        }, UseCase.None())
    }

    fun getLocation(context: Context){
        getLocation.execute({
            it.either(::handleLocationFailure, {location ->  handleLocation(location.address(context))})
        }, UseCase.None())
    }

    fun selectDay(date: Calendar){
        this.viewmodeldata.value = this.viewmodeldata.value?.apply {
            this.selectedDay = date
            this.adapter.swapData(dropoffs.firstOrNull {
                it.day == date.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault())
            }?.deliveries)
        }
    }

    private fun handleDropOffs(dropoffs: List<Dropoff>){
        this.viewmodeldata.value = this.viewmodeldata.value?.apply {
            this.dropoffs = dropoffs
            this.adapter.swapData(dropoffs.firstOrNull {
                it.day == this.selectedDay.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault())
            }?.deliveries)
        }
    }

    private fun handleLocation(address: Address){
        logger.debug("ADDRESS IS $address")
        this.viewmodeldata.value = this.viewmodeldata.value?.apply {
            if(address.maxAddressLineIndex == 0) this.topAddressLine = address.getAddressLine(0)
            if(address.maxAddressLineIndex > 0) this.bottomAddressLine = address.getAddressLine(1)
            //Fills in county if there isn't a second address line
            else this.bottomAddressLine = address.subAdminArea
        }
    }

    private fun handleLocationFailure(failure: Failure){
        this.viewmodeldata.value = this.viewmodeldata.value.apply {
            this?.topAddressLine = "Unfortunately location services are unavailable"
            this?.bottomAddressLine = "Please check your network"
        }
    }
}