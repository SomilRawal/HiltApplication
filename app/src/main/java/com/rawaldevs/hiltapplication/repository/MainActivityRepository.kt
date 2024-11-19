package com.rawaldevs.hiltapplication.repository

import com.rawaldevs.hiltapplication.model.User
import com.rawaldevs.hiltapplication.network.ApiService
import javax.inject.Inject


class MainActivityRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getUser(): List<User> {
        return apiService.getUsers()
    }
}