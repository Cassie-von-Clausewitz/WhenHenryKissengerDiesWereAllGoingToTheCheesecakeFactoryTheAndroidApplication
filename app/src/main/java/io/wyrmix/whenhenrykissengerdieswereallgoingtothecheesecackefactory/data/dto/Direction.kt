package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.dto

import com.squareup.moshi.Json

data class Direction(
        @Json(name = "Text") val description: String,
        @Json(name = "Value") val heading: Heading
)
