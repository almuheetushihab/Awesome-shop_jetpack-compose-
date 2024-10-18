package com.example.awesome_shop_jetpack_compose.data

import com.example.awesome_shop_jetpack_compose.R

data class CategoryElectronicItems(val title: String, val imageRes: Int)

val electronicsItems = listOf(
    CategoryElectronicItems("Acer 21.5 inc", R.drawable.electronics_c),
    CategoryElectronicItems("SanDisk 1TB", R.drawable.electronics_a),
    CategoryElectronicItems("SanDisk 1TB", R.drawable.electronics_a),
    CategoryElectronicItems("Curved Monitor", R.drawable.electronics_d)
)