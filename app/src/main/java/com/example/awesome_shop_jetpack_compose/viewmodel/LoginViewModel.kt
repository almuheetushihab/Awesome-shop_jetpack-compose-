package com.example.awesome_shop_jetpack_compose.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.awesome_shop_jetpack_compose.models.login.LoginResponse
import com.example.awesome_shop_jetpack_compose.reposatories.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


import com.example.awesome_shop_jetpack_compose.sharedpreference.SharedPreferenceHelper

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
    private val sharedPreference: SharedPreferenceHelper
) : ViewModel() {
    private val _items = MutableLiveData<Response<LoginResponse>>()
    val items: LiveData<Response<LoginResponse>> = _items



    fun login(username: String, password: String, fullName: String) {

        viewModelScope.launch {
            val response = loginRepository.login(username, password)
            _items.postValue(response)

            if (response.isSuccessful) {
                val token = response.body()?.token
                if (token != null) {
                    sharedPreference.saveCredentials(token, fullName)
                }
            }

        }
    }
}