package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.orders.recycler

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.model.Delivery

/**
 * Created by Alexander Melton on 6/21/2018.
 */
class OrdersViewHolder constructor(val binding: ItemOrderBinding): RecyclerView.ViewHolder(binding.root)

@BindingAdapter("restaurantImage")
fun loadImage(view: ImageView, imageUrl: String) {
//    Picasso.get().load(imageUrl).into(view)
}

@BindingAdapter("orderStatus")
fun loadOrderStatus(view: TextView, delivery: Delivery){
    when{
        delivery.isPastCutoff -> view.text = "Cut-Off time has passed"
        delivery.soldout -> view.text = "This place has sold out"
        delivery.sellingOut -> view.text = "This place is selling out fast!"
        delivery.isOrderPlaced -> view.text = "An order here has already been placed"
        else -> view.visibility = View.GONE
    }
}