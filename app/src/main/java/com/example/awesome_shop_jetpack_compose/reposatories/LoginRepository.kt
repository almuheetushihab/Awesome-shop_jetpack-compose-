package com.example.awesome_shop_jetpack_compose.reposatories

import com.example.awesome_shop_jetpack_compose.models.login.LoginRequest
import com.example.awesome_shop_jetpack_compose.models.login.LoginResponse
import com.example.awesome_shop_jetpack_compose.networks.ApiInterface
import retrofit2.Response
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val loginInterface: ApiInterface
) {

    suspend fun login(username: String, password: String): Response<LoginResponse> {
        return loginInterface.login(LoginRequest(username, password))
    }
}