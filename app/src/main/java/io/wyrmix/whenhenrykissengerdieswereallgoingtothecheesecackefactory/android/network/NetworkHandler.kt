package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.android.network

import android.net.ConnectivityManager
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Alexander Melton on 6/19/2018.
 * Injectable class which returns information about the network connection state.
 */

@Singleton
class NetworkHandler
@Inject constructor(private val connectivityManager: ConnectivityManager) {
    val isConnected get() = connectivityManager.isDefaultNetworkActive
}