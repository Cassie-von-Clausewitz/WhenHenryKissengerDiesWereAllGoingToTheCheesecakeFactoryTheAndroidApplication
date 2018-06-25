package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.model

import java.io.Serializable

/**
 * Created by Alexander Melton on 6/19/2018.
 */
data class Dropoff(
        val day: String,
        val deliveries: List<Delivery>
): Serializable