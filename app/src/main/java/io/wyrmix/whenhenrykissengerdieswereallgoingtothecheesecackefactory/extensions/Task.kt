package io.wyrmix.whenhenrykissengerdieswereallgoingtothecheesecackefactory.extensions

import com.google.android.gms.tasks.Task
import kotlin.coroutines.experimental.suspendCoroutine

/**
 * Created by Alexander Melton on 6/20/2018.
 */

@JvmName("awaitVoid")
suspend fun Task<Void>.await() = suspendCoroutine<Unit> { continuation ->
    addOnSuccessListener { continuation.resume(Unit) }
    addOnFailureListener { continuation.resumeWithException(it) }
}

suspend fun <TResult> Task<TResult>.await() = suspendCoroutine<TResult> { continuation ->
    addOnSuccessListener { continuation.resume(it) }
    addOnFailureListener { continuation.resumeWithException(it) }
}