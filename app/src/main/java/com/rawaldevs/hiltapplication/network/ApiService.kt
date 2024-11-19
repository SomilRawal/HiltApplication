package com.rawaldevs.hiltapplication.network

import com.rawaldevs.hiltapplication.model.User
import retrofit2.http.GET


/**
 * @auther Somil Rawal
 * Created on 18-11-2024 at 00:45.
 * somil.rawal@gmail.com
 */
interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}