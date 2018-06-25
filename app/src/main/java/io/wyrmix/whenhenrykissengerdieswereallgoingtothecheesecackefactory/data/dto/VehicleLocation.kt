package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.dto

import com.squareup.moshi.Json

data class VehicleLocation(
        @Json(name = "Bearing") val bearing: Int,
        @Json(name = "BlockNumber") val blockNumber: Int,
        @Json(name = "Direction") val heading: Heading,
        @Json(name = "LocationTime") val locationTime: String,
        @Json(name = "Route") val route: Int,
        @Json(name = "Speed") val speed: Double,
        @Json(name = "Terminal") val terminal: String,
        @Json(name = "VehicleLatitude") val latitude: Double,
        @Json(name = "VehicleLongitude") val longitude: Double
)