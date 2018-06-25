package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.repository.dropoff

/**
 * Created by Alexander Melton on 6/19/2018.
 */

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

internal interface DropoffsApi {
    companion object {
        private const val DROPOFFS = "/dropoff/"
    }

    @SerializedName("dropoffs") @GET(DROPOFFS) fun dropoffs(): Call<DropoffsEntity>
}