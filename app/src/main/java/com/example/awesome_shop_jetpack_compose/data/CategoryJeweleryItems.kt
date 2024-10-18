package com.example.awesome_shop_jetpack_compose.data

import com.example.awesome_shop_jetpack_compose.R

data class CategoryJeweleryItems(val title: String, val imageRes: Int)


val jeweleryItems = listOf(
    CategoryJeweleryItems("Bracelet", R.drawable.jewelery_bracelet),
    CategoryJeweleryItems("Gold Petite Micropave", R.drawable.jewelery_petite),
    CategoryJeweleryItems("White Gold Plated", R.drawable.jewelery_plated),
    CategoryJeweleryItems("Rose Gold Plated", R.drawable.jewelery_rosegold)
)