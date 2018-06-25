package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.dto

import com.squareup.moshi.Json

data class Route(
        @Json(name = "Description") val description: String,
        @Json(name = "ProviderID") val providerId: Int,
        @Json(name = "Route") val route: Int
)