package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.repository

import com.google.android.gms.tasks.Task
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.data.functional.Either
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.domain.exceptions.Failure
import io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.extensions.await
import retrofit2.Call

/**
 * Created by Alexander Melton on 6/19/2018.
 */
interface Repository {
    fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> Either.Right(transform((response.body() ?: default)))
                false -> Either.Left(Failure.ServerError())
            }
        } catch (exception: Throwable) {
            Either.Left(Failure.ServerError())
        }
    }

    suspend fun <T, R> request(task: Task<T>, transform: (T) -> R, default: T): Either<Failure, R> {
        return try{
            val response: T = task.await()
            when(task.isSuccessful){
                true -> Either.Right(transform(response ?: default))
                else -> Either.Left(Failure.ServerError())
            }
        }catch (e: Exception){
            Either.Left(Failure.ServerError())
        }
    }
}