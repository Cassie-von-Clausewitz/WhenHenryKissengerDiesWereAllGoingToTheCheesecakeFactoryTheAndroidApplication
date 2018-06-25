package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.model

import java.io.Serializable

/**
 * Created by Alexander Melton on 6/19/2018.
 */
data class Delivery(
        val deliveryId: Number,
        val storeId: Number,
        val restaurantName: String,
        val logoUrl: String,
        val cutoff: String,
        val dropoff: String,
        val soldout: Boolean,
        val sellingOut: Boolean,
        val isPastCutoff: Boolean,
        val isOrderPlaced: Boolean
): Serializable