package com.example.awesome_shop_jetpack_compose.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.awesome_shop_jetpack_compose.R
import com.example.awesome_shop_jetpack_compose.data.CategoryElectronicItems
import com.example.awesome_shop_jetpack_compose.data.CategoryJeweleryItems
import com.example.awesome_shop_jetpack_compose.data.CategoryMensClothingItems
import com.example.awesome_shop_jetpack_compose.data.CategoryWomenClothingItems
import com.example.awesome_shop_jetpack_compose.data.Product
import com.example.awesome_shop_jetpack_compose.data.electronicsItems
import com.example.awesome_shop_jetpack_compose.data.jeweleryItems
import com.example.awesome_shop_jetpack_compose.data.menClothingItems
import com.example.awesome_shop_jetpack_compose.data.productItems
import com.example.awesome_shop_jetpack_compose.data.womenClothingItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenWithAppBar() {

    Scaffold(topBar = {
        SmallTopAppBar(title = {
            Box(
                modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Awesome Shop",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }, actions = {
            IconButton(onClick = { }) {
                Icon(
                    Icons.Filled.MoreVert, contentDescription = "Settings", tint = Color.White
                )
            }
        }, colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(0xFF6200EE)
        )
        )
    }) { paddingValues ->
        HomeScreen(
            navController = rememberNavController(), modifier = Modifier.padding(paddingValues)
        )
    }
}


@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabTitles = listOf("Electronics", "Jewelery", "Men's clothing", "Women's clothing")
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp), horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = "Welcome,",
            style = MaterialTheme.typography.headlineMedium,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )


        ScrollableTabRow(selectedTabIndex = selectedTabIndex, edgePadding = 0.dp) {
            tabTitles.forEachIndexed { index, title ->
                Tab(selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title) })
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable {}
            ) {
                Text(
                    text = "See All",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier.padding(16.dp)
                )

                Icon(
                    painter = painterResource(id = R.drawable.arrow_forwards_24),
                    contentDescription = "Right Arrow",
                    tint = Color.Blue,
                    modifier = Modifier
                        .size(16.dp)
                        .padding(start = 4.dp)
                )
            }
        }

        when (selectedTabIndex) {
            0 -> CategoryElectronicsContentGrid()
            1 -> CategoryJeweleryContentGrid()
            2 -> CategoryMensClothingContentGrid()
            3 -> CategoryWomenClothingContentGrid()
        }


        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Products",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(end = 16.dp, bottom = 16.dp, top = 16 .dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable {}
            ) {
                Text(
                    text = "See All",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold
                    )
                    ,
                    modifier = Modifier.padding(16.dp)
                )

                Icon(
                    painter = painterResource(id = R.drawable.arrow_forwards_24),
                    contentDescription = "Right Arrow",
                    tint = Color.Blue,
                    modifier = Modifier
                        .size(16.dp)
                        .padding(start = 4.dp)
                )
            }
        }


        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(productItems.size) { productIndex ->
                ProductItem(productItems[productIndex])
            }
        }


        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(productItems.size) { productIndex ->
                ProductItem(productItems[productIndex])
            }
        }

    }
}

@Composable
fun CategoryElectronicsContentGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
    ) {
        items(electronicsItems.size) { itemIndex ->
            CategoryElectronicItem(electronicsItems[itemIndex])
        }
    }
}

@Composable
fun CategoryJeweleryContentGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
    ) {
        items(jeweleryItems.size) { itemIndex ->
            CategoryJeweleryItem(jeweleryItems[itemIndex])
        }
    }
}

@Composable
fun CategoryMensClothingContentGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
    ) {
        items(menClothingItems.size) { itemIndex ->
            CategoryMensClothingItem(menClothingItems[itemIndex])
        }
    }
}

@Composable
fun CategoryWomenClothingContentGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
    ) {
        items(womenClothingItems.size) { itemIndex ->
            CategoryWomenClothingItem(womenClothingItems[itemIndex])
        }
    }
}

@Composable
fun CategoryElectronicItem(categoryItem: CategoryElectronicItems) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = categoryItem.imageRes),
                contentDescription = categoryItem.title,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )

            Text(
                text = categoryItem.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Composable
fun CategoryJeweleryItem(categoryItem: CategoryJeweleryItems) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = categoryItem.imageRes),
                contentDescription = categoryItem.title,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )

            Text(
                text = categoryItem.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Composable
fun CategoryMensClothingItem(categoryItem: CategoryMensClothingItems) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = categoryItem.imageRes),
                contentDescription = categoryItem.title,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )

            Text(
                text = categoryItem.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}



@Composable
fun CategoryWomenClothingItem(categoryItem: CategoryWomenClothingItems) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = categoryItem.imageRes),
                contentDescription = categoryItem.title,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )

            Text(
                text = categoryItem.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}



@Composable
fun ProductItem(product: Product) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.title,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )

            Text(
                text = product.title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController())
}
