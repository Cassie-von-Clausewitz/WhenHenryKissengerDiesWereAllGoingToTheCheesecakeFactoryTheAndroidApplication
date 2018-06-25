package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.dto

import com.squareup.moshi.Json

data class Provider(
        @Json(name = "Text") val title: String,
        @Json(name = "Value") val providerId: Int
)
