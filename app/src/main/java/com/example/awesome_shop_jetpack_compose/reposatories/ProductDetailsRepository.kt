package com.example.awesome_shop_jetpack_compose.reposatories

import com.example.awesome_shop_jetpack_compose.models.product.ProductsResponseItem
import com.example.awesome_shop_jetpack_compose.networks.ApiInterface
import javax.inject.Inject

class ProductDetailsRepository @Inject constructor(
    private val productApi: ApiInterface
) {
    suspend fun getProductDetails(id: Int): ProductsResponseItem? {
        return productApi.getProductDetails(id).body()
    }
}
