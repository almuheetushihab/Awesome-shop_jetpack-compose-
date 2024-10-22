package com.example.awesome_shop_jetpack_compose.reposatories

import com.example.awesome_shop_jetpack_compose.models.product.ProductsResponse
import com.example.awesome_shop_jetpack_compose.networks.ApiInterface
import javax.inject.Inject


class ProductRepository @Inject constructor(
    private val productApi: ApiInterface
) {
    suspend fun getProducts(): ProductsResponse? {
        return productApi.getProducts().body()
    }
}