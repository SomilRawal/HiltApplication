package com.rawaldevs.hiltapplication.util


/**
 * @auther Somil Rawal
 * Created on 17-11-2024 at 18:54.
 * somil.rawal@gmail.com
 */
sealed class NetworkResult<T>(
    val data: T? = null,
    val throwable: Throwable? = null
) {
    class Loading<T>() : NetworkResult<T>()
    class Success<T>(data: T) : NetworkResult<T>(data = data)
    class Failure<T>(throwable: Throwable) : NetworkResult<T>(throwable = throwable)
}