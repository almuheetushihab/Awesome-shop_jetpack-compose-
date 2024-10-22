package com.example.awesome_shop_jetpack_compose.reposatories

import com.example.awesome_shop_jetpack_compose.networks.ApiInterface
import javax.inject.Inject

class CategoriesRepository @Inject constructor(
    private val productApi: ApiInterface
) {

    suspend fun getCategories(): List<String>? {
        return productApi.getCategories().body()
    }
}