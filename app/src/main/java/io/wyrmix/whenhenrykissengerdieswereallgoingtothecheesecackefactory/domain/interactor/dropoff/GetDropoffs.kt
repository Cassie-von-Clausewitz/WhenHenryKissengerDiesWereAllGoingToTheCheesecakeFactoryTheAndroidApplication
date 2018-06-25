package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.domain.interactor.dropoff

import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.domain.interactor.UseCase
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.domain.interactor.UseCase.None
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.model.Dropoff
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.repository.dropoff.DropoffsRepository
import javax.inject.Inject


/**
 * Created by Alexander Melton on 6/19/2018.
 */
class GetDropoffs
@Inject constructor(private val dropoffsRepository: DropoffsRepository) : UseCase<List<Dropoff>, None>() {

    override suspend fun run(params: None) = dropoffsRepository.dropoffs()
}