package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.dto

import com.squareup.moshi.Json

data class Departure(
        @Json(name = "Actual") val isLiveUpdating: Boolean,
        @Json(name = "BlockNumber") val blockNumber: Int,
        @Json(name = "DepartureText") val departureText: String,
        @Json(name = "DepartureTime") val departureTime: String,
        @Json(name = "Description") val description: String,
        @Json(name = "Gate") val gate: String,
        @Json(name = "Route") val route: String,
        @Json(name = "RouteDirection") val routeDirection: String,
        @Json(name = "Terminal") val terminal: String,
        @Json(name = "VehicleLatitude") val vehicleLatitude: Double,
        @Json(name = "VehicleLongitude") val vehicleLongitude: Double
)