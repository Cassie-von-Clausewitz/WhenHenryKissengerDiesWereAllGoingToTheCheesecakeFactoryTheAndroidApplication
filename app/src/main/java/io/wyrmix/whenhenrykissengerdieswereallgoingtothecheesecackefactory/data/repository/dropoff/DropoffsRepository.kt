package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.repository.dropoff

import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.android.network.NetworkHandler
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.functional.Either
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.model.Dropoff
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.repository.Repository
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.domain.exceptions.Failure
import javax.inject.Inject

/**
 * Created by Alexander Melton on 6/19/2018.
 */
interface DropoffsRepository: Repository {
    fun dropoffs(): Either<Failure, List<Dropoff>>

    class Network
    @Inject constructor(private val networkHandler: NetworkHandler,
                        private val service: DropoffService): DropoffsRepository {
        override fun dropoffs(): Either<Failure, List<Dropoff>> {
            return when(networkHandler.isConnected) {
                true -> request(service.dropoffs(), { it.dropoffs }, DropoffsEntity())
                else -> Either.Left(Failure.NetworkConnection())
            }
        }

    }
}