package com.example.awesome_shop_jetpack_compose.data

import com.example.awesome_shop_jetpack_compose.R

data class Product(val title: String, val imageRes: Int)

val productItems = listOf(
    Product("Snowboard Jacket", R.drawable.womensclothing_snowboard),
    Product("Leather Jacket", R.drawable.womensclothing_lether),
    Product("Rain Jacket", R.drawable.womensclothing_rain),
    Product("Short Sleeve", R.drawable.womensclothing_sleeve),
    Product("Acer 21.5 inc", R.drawable.electronics_c),
    Product("SanDisk 1TB", R.drawable.electronics_a),
    Product("SanDisk 1TB", R.drawable.electronics_a),
    Product("Curved Monitor", R.drawable.electronics_d),
    Product("Bracelet", R.drawable.jewelery_bracelet),
    Product("Gold Petite Micropave", R.drawable.jewelery_petite),
    Product("White Gold Plated", R.drawable.jewelery_plated),
    Product("Rose Gold Plated", R.drawable.jewelery_rosegold),
    Product("T-Shirts", R.drawable.mensclothings_tshirt),
    Product("Cotton Jacket", R.drawable.mensclothings_jacket),
    Product("Casual Slim Fit", R.drawable.mensclothings_slimfit),
    Product("Backpack", R.drawable.mensclothings_backpack)
)
