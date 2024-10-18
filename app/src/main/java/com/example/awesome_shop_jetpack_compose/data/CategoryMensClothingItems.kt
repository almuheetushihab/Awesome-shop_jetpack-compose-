package com.example.awesome_shop_jetpack_compose.data

import com.example.awesome_shop_jetpack_compose.R

data class CategoryMensClothingItems(val title: String, val imageRes: Int)


val menClothingItems = listOf(
    CategoryMensClothingItems("T-Shirts", R.drawable.mensclothings_tshirt),
    CategoryMensClothingItems("Cotton Jacket", R.drawable.mensclothings_jacket),
    CategoryMensClothingItems("Casual Slim Fit", R.drawable.mensclothings_slimfit),
    CategoryMensClothingItems("Backpack", R.drawable.mensclothings_backpack)
)