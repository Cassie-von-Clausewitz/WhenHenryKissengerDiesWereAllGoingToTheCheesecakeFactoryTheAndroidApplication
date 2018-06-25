package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.ui.main

import android.arch.lifecycle.ViewModel
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.NexTripEndpoint
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.dto.Route
import kotlinx.coroutines.experimental.Deferred
import javax.inject.Inject

class MainViewModel @Inject constructor(private val nexTripEndpoint: NexTripEndpoint): ViewModel() {
    val text = "GANG WEED"

    fun getRoutes(): Deferred<List<Route>> = nexTripEndpoint.getRoutes()
}
