package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.repository.location

import com.google.android.gms.location.FusedLocationProviderClient
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Alexander Melton on 6/20/2018.
 */
@Singleton
class LocationService
@Inject constructor(fusedLocationProviderClient: FusedLocationProviderClient){
    private val locationApi by lazy { fusedLocationProviderClient.lastLocation }

    fun location() = locationApi
}