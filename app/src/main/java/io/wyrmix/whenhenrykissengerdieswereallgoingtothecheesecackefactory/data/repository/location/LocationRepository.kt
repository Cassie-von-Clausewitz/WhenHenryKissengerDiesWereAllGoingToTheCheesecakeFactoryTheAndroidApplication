package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.repository.location

import android.location.Location
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.android.network.NetworkHandler
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.functional.Either
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.repository.Repository
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.domain.exceptions.Failure
import javax.inject.Inject

/**
 * Created by Alexander Melton on 6/20/2018.
 */
interface LocationRepository: Repository {
    suspend fun location(): Either<Failure, Location>

    class Network
    @Inject constructor(private val networkHandler: NetworkHandler, private var locationService: LocationService): LocationRepository {
        override suspend fun location(): Either<Failure, Location> {
            return when(networkHandler.isConnected){
                true -> request(locationService.location(), { it }, Location(""))
                else -> Either.Left(Failure.NetworkConnection())
            }
        }
    }
}