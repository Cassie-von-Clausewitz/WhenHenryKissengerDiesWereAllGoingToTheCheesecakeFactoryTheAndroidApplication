package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.extensions

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.location.Location
import java.util.*

/**
 * Created by Alexander Melton on 6/20/2018.
 */

fun Location.address(context: Context): Address = Geocoder(context , Locale.getDefault()).getFromLocation(latitude, longitude, 1).first()
