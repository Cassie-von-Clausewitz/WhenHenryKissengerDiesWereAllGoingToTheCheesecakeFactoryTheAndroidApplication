package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.dto

import com.squareup.moshi.Json

data class Stop(
        @Json(name = "Text") val intersection: String,
        @Json(name = "Value") val stopId: String,
        val latitude: Double = 0.0,
        val longitude: Double = 0.0
)