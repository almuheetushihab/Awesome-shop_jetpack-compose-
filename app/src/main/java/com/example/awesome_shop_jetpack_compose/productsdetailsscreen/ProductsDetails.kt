package com.example.awesome_shop_jetpack_compose.productsdetailsscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.awesome_shop_jetpack_compose.R

@Composable
fun ProductDetailsScreen(
    productImage: Int,
    title: String,
    price: String,
    category: String,
    rating: String,
    description: String
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {}
}


@Preview(showBackground = true)
@Composable
fun ProductDetailsScreenPreview() {
    ProductDetailsScreen(
        productImage = R.drawable.mensclothings_backpack,
        title = "Awesome Men's T-Shirt",
        price = "50",
        category = "Men's Clothing",
        rating = "4.5",
        description = "This is a sample description of a product. It is high quality and comfortable."
    )
}
