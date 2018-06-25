package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data

import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.dto.*
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface NexTripEndpoint {
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @GET("Providers")
    fun getProviders() : Deferred<List<Provider>>

    @Headers(
            "Accept: application/json",
            "Content-Type: application/json"
    )
    @GET("Routes")
    fun getRoutes() : Deferred<List<Route>>

    @Headers(
            "Accept: application/json",
            "Content-Type: application/json"
    )
    @GET("Directions/{route}")
    fun getDirections(@Path("route") routeId: Int) : Deferred<List<Direction>>

    @Headers(
            "Accept: application/json",
            "Content-Type: application/json"
    )
    @GET("Stops/{route}/{direction}")
    fun getStops(
            @Path("route") routeId: Int,
            @Path("direction") direction: Int
    ) : Deferred<List<Stop>>

    @Headers(
            "Accept: application/json",
            "Content-Type: application/json"
    )
    @GET("{route}/{direction}/{stop}")
    fun getScheduledDepartures(
            @Path("route") routeId: Int,
            @Path("direction") direction: Int,
            @Path("stop") stop: String
    ) : Deferred<List<Departure>>

    @Headers(
            "Accept: application/json",
            "Content-Type: application/json"
    )
    @GET("VehicleLocations/{route}")
    fun getVehicleLocations(@Path("route") routeId: Int) : Deferred<List<VehicleLocation>>
}