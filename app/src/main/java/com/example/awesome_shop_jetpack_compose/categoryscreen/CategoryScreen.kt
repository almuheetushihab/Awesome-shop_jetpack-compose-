package com.example.awesome_shop_jetpack_compose.categoryscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.awesome_shop_jetpack_compose.customappber.CustomAppBar
import com.example.awesome_shop_jetpack_compose.homescreen.ProductItem
import com.example.awesome_shop_jetpack_compose.viewmodel.CategoryWiseProductViewModel

@Composable
fun CategoryScreen(
    navController: NavController,
    categoryTitle: String,
    categoryWiseProductViewModel: CategoryWiseProductViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        categoryWiseProductViewModel.getCategoryWiseProducts(categoryTitle)
    }

    val products by categoryWiseProductViewModel.items.observeAsState()
    Scaffold(
        topBar = {
            CustomAppBar(navController, title = "Category Items ")
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (!products.isNullOrEmpty()) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        items(products!!.size) { index ->
                            val product = products!![index]
                            ProductItem(product = product) {
                                navController.navigate("product_details_screen/${product.id}")
                            }
                        }
                    }
                } else {
                    CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                }
            }
        })
}
