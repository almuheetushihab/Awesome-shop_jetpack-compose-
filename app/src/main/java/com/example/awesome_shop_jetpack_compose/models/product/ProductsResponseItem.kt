package com.example.awesome_shop_jetpack_compose.models.product

import com.google.gson.annotations.SerializedName

data class ProductsResponseItem(
    @SerializedName("category")
    val category: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("rating")
    val rating: Rating,
    @SerializedName("title")
    val title: String,
    @SerializedName("quantity")
    var quantity: Int

)