package com.example.awesome_shop_jetpack_compose.homescreen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenWithAppBar() {

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text("Awesome Shop")},
                actions = {
                    IconButton(onClick = {  }) {
                        Icon(Icons.Filled.MoreVert, contentDescription = "Settings")
                    }
                }
            )
        }
    ) { paddingValues ->

        HomeScreen(navController = rememberNavController(), modifier = Modifier.padding(paddingValues))
    }
}


@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = "Welcome",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp, top = 16.dp)
        )


        Text(
            text = "Categories",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )


        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            items(10) { categoryIndex ->
                CategoryItem(categoryIndex)
            }
        }


        Text(
            text = "Products",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )


        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(100) { productIndex ->
                ProductItem(productIndex)
            }
        }
    }
}

@Composable
fun CategoryItem(index: Int) {
    Box(
        modifier = Modifier
            .width(100.dp)
            .border(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Text(text = "Category $index" , modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun ProductItem(index: Int) {
    Box(
        modifier = Modifier
            .size(150.dp)
            .border(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Text(text = "Product $index")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController())
}
