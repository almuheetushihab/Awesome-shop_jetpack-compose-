package com.example.awesome_shop_jetpack_compose.data

import com.example.awesome_shop_jetpack_compose.R
import com.example.awesome_shop_jetpack_compose.models.product.ProductsResponse
import com.example.awesome_shop_jetpack_compose.models.product.ProductsResponseItem
import com.example.awesome_shop_jetpack_compose.models.product.Rating


val productsResponse:ProductsResponse = ProductsResponse()

fun getProductResponse():ProductsResponse{

    productsResponse.add(  ProductsResponseItem(
        id = 1,
        title = "Product 1",
        price = 100.0,
        quantity = 3,
        rating = Rating(1, 1.0),
        description = "This is product 1 description",
        category = "Electronics",
        image = "https://via.placeholder.com/150"
    ))



    return productsResponse
}
