package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.orders

import android.databinding.BindingAdapter
import android.view.View
import com.airbnb.lottie.LottieAnimationView
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.model.Dropoff
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.orders.recycler.OrdersAdapter
import java.util.*

/**
 * Created by Alexander Melton on 6/20/2018.
 */
data class OrdersView(
        var topAddressLine: String = String(),
        var bottomAddressLine: String = String(),
        var dropoffs: List<Dropoff> = emptyList(),
        var adapter: OrdersAdapter = OrdersAdapter(),
        var selectedDay: Calendar = Calendar.getInstance()
){
    fun isEmpty(): Int{
        return if(adapter.itemCount > 0) View.GONE
        else View.VISIBLE
    }
}

@BindingAdapter("animateOnUpdate")
fun animateOnUpdate(view: LottieAnimationView, any: Any) = view.playAnimation()