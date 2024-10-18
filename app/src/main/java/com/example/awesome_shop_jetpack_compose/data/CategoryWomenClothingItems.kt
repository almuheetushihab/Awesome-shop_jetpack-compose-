package com.example.awesome_shop_jetpack_compose.data

import com.example.awesome_shop_jetpack_compose.R

data class CategoryWomenClothingItems(val title: String, val imageRes: Int)


val womenClothingItems = listOf(
    CategoryWomenClothingItems("Snowboard Jacket", R.drawable.womensclothing_snowboard),
    CategoryWomenClothingItems("Leather Jacket", R.drawable.womensclothing_lether),
    CategoryWomenClothingItems("Rain Jacket", R.drawable.womensclothing_rain),
    CategoryWomenClothingItems("Short Sleeve", R.drawable.womensclothing_sleeve)
)
