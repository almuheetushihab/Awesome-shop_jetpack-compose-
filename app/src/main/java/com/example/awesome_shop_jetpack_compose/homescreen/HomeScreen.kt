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
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenWithAppBar() {

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Awesome Shop", textAlign = TextAlign.Center, fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold)
                    }
                },
                actions = {
                    IconButton(onClick = {  }) {
                        Icon(Icons.Filled.MoreVert, contentDescription = "Settings", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF6200EE)
                )
            )
        }
    ) { paddingValues ->
        HomeScreen(navController = rememberNavController(), modifier = Modifier.padding(paddingValues))
    }
}


@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabTitles = listOf("Electronics", "Jewelery", "Men's clothing", "Women's clothing")
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = "Welcome,",
            style = MaterialTheme.typography.headlineMedium,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )


        TabRow(selectedTabIndex = selectedTabIndex) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title)}
                )
            }
        }

        when (selectedTabIndex) {
            0 -> CategoryContent(1)
            1 -> CategoryContent(2)
            2 -> CategoryContent(3)
            3 -> CategoryContent(4)
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
fun CategoryContent(categoryIndex: Int) {

    Spacer(modifier = Modifier.height(8.dp))

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        items(10) { itemIndex ->
            CategoryItem(itemIndex + (categoryIndex * 10))
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
        Text(text = "Category $index" , fontSize = 14.sp,textAlign =  TextAlign.Center, modifier = Modifier.padding(8.dp))
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
