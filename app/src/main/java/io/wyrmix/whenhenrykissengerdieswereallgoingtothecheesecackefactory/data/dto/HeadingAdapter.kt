package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.dto

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.ToJson

class HeadingAdapter {
    @ToJson
    fun toJson(heading: Heading): String {
        return heading.ordinal.toString()
    }

    @FromJson
    fun fromJson(heading: String): Heading {
        if (heading.length != 1) throw JsonDataException("Unknown heading: $heading")

        val ordinal = heading[0]
        return when (ordinal) {
            '1' -> Heading.SOUTH
            '2' -> Heading.EAST
            '3' -> Heading.WEST
            '4' -> Heading.NORTH
            else -> throw JsonDataException("Unknown heading: $heading")
        }
    }
}