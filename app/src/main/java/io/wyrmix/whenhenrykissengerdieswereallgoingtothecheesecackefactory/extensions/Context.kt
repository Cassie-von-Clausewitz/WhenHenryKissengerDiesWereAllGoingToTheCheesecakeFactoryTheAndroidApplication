package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Created by Alexander Melton on 6/19/2018.
 */

val Context.networkInfo: NetworkInfo? get() =
    (this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo