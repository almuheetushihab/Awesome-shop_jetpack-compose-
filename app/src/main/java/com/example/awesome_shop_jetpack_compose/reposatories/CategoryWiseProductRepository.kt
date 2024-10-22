package com.example.awesome_shop_jetpack_compose.reposatories

import com.example.awesome_shop_jetpack_compose.models.product.ProductsResponseItem
import com.example.awesome_shop_jetpack_compose.networks.ApiInterface
import javax.inject.Inject

class CategoryWiseProductRepository @Inject constructor(
    private val categoriesProductApi: ApiInterface
) {

    suspend fun getCategoryWiseProducts(category: String): List<ProductsResponseItem>? {
        return categoriesProductApi.getCategoryWiseProducts(category).body()
    }
}
