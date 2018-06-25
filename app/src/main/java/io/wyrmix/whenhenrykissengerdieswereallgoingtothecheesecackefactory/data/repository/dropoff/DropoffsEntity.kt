package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.repository.dropoff

import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.model.Dropoff
import java.io.Serializable

/**
 * Created by Alexander Melton on 6/19/2018.
 */
data class DropoffsEntity(
        val dropoffs: List<Dropoff> = emptyList()
): Serializable