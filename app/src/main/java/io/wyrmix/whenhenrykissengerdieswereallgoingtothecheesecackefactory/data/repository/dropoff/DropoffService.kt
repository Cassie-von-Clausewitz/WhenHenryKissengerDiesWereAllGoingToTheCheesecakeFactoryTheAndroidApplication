package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.repository.dropoff

/**
 * Created by Alexander Melton on 6/19/2018.
 */

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DropoffService
@Inject constructor(retrofit: Retrofit) : DropoffsApi {
    private val dropoffsApi by lazy { retrofit.create(DropoffsApi::class.java) }

    override fun dropoffs() = dropoffsApi.dropoffs()
}