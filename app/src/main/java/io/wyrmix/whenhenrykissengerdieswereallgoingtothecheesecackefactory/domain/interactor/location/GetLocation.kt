package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.domain.interactor.location

import android.location.Location
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.domain.interactor.UseCase
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.repository.location.LocationRepository
import javax.inject.Inject

/**
 * Created by Alexander Melton on 6/20/2018.
 */
class GetLocation
@Inject constructor(private val locationRepository: LocationRepository) : UseCase<Location, UseCase.None>() {

    override suspend fun run(params: None) = locationRepository.location()
}