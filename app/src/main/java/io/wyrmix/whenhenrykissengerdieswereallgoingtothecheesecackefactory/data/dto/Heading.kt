package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.dto

enum class Heading {
    SOUTH, EAST, WEST, NORTH;

    companion object {
        fun fromInt(ordinal: Int): Heading {
            return when(ordinal) {
                1 -> SOUTH
                2 -> EAST
                3 -> WEST
                4 -> NORTH
                else -> throw RuntimeException("Unknown heading $ordinal")
            }
        }
    }
}