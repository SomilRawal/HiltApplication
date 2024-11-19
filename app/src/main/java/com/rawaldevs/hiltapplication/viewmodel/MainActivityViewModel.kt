package com.rawaldevs.hiltapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rawaldevs.hiltapplication.model.User
import com.rawaldevs.hiltapplication.repository.MainActivityRepository
import com.rawaldevs.hiltapplication.util.NetworkResult
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * @auther Somil Rawal
 * Created on 01-06-2024 at 02:33.
 * somil.rawal@gmail.com
 */
class MainActivityViewModel
@Inject constructor(
    private val repository: MainActivityRepository
) : ViewModel() {

    private val _userData: MutableLiveData<NetworkResult<List<User?>>> = MutableLiveData()
    val userData: LiveData<NetworkResult<List<User?>>>
        get() = _userData

    fun getUserData() = viewModelScope.launch {
        _userData.value = NetworkResult.Loading()
        try {
            _userData.value = NetworkResult.Success(data = repository.getUser())
        } catch (e: Exception) {
            _userData.value = NetworkResult.Failure(throwable = e)
        }
    }

}