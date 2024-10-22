package com.example.awesome_shop_jetpack_compose.networks

import com.example.awesome_shop_jetpack_compose.models.cart.CartResponse
import com.example.awesome_shop_jetpack_compose.models.login.LoginRequest
import com.example.awesome_shop_jetpack_compose.models.login.LoginResponse
import com.example.awesome_shop_jetpack_compose.models.product.ProductsResponse
import com.example.awesome_shop_jetpack_compose.models.product.ProductsResponseItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface ApiInterface {

    @GET("products/categories")
    suspend fun getCategories(): Response<List<String>>

    @GET("products")
    suspend fun getProducts(): Response<ProductsResponse>

    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @GET("products/category/{category}")
    suspend fun getCategoryWiseProducts(@Path("category") category: String): Response<List<ProductsResponseItem>>

    @GET("products/{id}")
    suspend fun getProductDetails(@Path("id") id: Int): Response<ProductsResponseItem>

    @GET("carts/{id}")
    suspend fun getCart(@Path("id") id: Int): Response<CartResponse>

}