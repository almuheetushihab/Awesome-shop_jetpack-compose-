package com.example.awesome_shop_jetpack_compose.reposatories

import com.example.awesome_shop_jetpack_compose.models.cart.CartResponse
import com.example.awesome_shop_jetpack_compose.models.product.ProductsResponseItem
import com.example.awesome_shop_jetpack_compose.networks.ApiClient
import com.example.awesome_shop_jetpack_compose.networks.ApiInterface
import retrofit2.Response
import javax.inject.Inject

class CartRepository @Inject constructor() {

    private val apiInterface: ApiInterface = ApiClient.getInstance().create(ApiInterface::class.java)

    suspend fun getCart(cartId: Int): Response<CartResponse> {
        return apiInterface.getCart(cartId)
    }

    suspend fun getProductById(productId: Int): Response<ProductsResponseItem> {
        return apiInterface.getProductDetails(productId)
    }
}
