package com.example.awesomeshop.models.cart

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CartResponse(
    @SerializedName("__v")
    val __v: Int,
    @SerializedName("date")
    val date: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("products")
    val products: List<Product>,
    @SerializedName("userId")
    val userId: Int
): Serializable