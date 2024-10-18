package com.example.awesome_shop_jetpack_compose.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
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
                    Icons.Filled.MoreVert,
                    contentDescription = "Settings",
                    tint = Color.White
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
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title) }
                )
            }
        }


        when (selectedTabIndex) {
            0 -> CategoryElectronicsContentGrid()
            1 -> CategoryJeweleryContentGrid()
            2 -> CategoryMensClothingContentGrid()
            3 -> CategoryWomenClothingContentGrid()
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
            items(productItems.size) { productIndex ->
                ProductItem(productItems[productIndex])
            }
        }

    }
}

val electronicsItems = listOf(
    CategoryElectronicItems("Acer 21.5 inc", R.drawable.electronics_c),
    CategoryElectronicItems("SanDisk 1TB", R.drawable.electronics_a),
    CategoryElectronicItems("SanDisk 1TB", R.drawable.electronics_a),
    CategoryElectronicItems("Curved Monitor", R.drawable.electronics_d)
)

val jeweleryItems = listOf(
    CategoryJeweleryItems("Bracelet", R.drawable.jewelery_bracelet),
    CategoryJeweleryItems("Gold Petite Micropave", R.drawable.jewelery_petite),
    CategoryJeweleryItems("White Gold Plated", R.drawable.jewelery_plated),
    CategoryJeweleryItems("Rose Gold Plated", R.drawable.jewelery_rosegold)
)

val menClothingItems = listOf(
    CategoryMensClothingItems("T-Shirts", R.drawable.mensclothings_tshirt),
    CategoryMensClothingItems("Cotton Jacket", R.drawable.mensclothings_jacket),
    CategoryMensClothingItems("Casual Slim Fit", R.drawable.mensclothings_slimfit),
    CategoryMensClothingItems("Backpack", R.drawable.mensclothings_backpack)
)

val womenClothingItems = listOf(
    CategoryWomenClothingItems("Snowboard Jacket", R.drawable.womensclothing_snowboard),
    CategoryWomenClothingItems("Leather Jacket", R.drawable.womensclothing_lether),
    CategoryWomenClothingItems("Rain Jacket", R.drawable.womensclothing_rain),
    CategoryWomenClothingItems("Short Sleeve", R.drawable.womensclothing_sleeve)
)

val productItems = listOf(
    Product("Acer 21.5 inc", R.drawable.electronics_c),
    Product("SanDisk 1TB", R.drawable.electronics_a),
    Product("SanDisk 1TB", R.drawable.electronics_a),
    Product("Curved Monitor", R.drawable.electronics_d),
    Product("Bracelet", R.drawable.jewelery_bracelet),
    Product("Gold Petite Micropave", R.drawable.jewelery_petite),
    Product("T-Shirts", R.drawable.mensclothings_tshirt),
    Product("T-Shirts", R.drawable.mensclothings_tshirt),
    Product("T-Shirts", R.drawable.mensclothings_tshirt),
    Product("T-Shirts", R.drawable.mensclothings_tshirt),
    Product("T-Shirts", R.drawable.mensclothings_tshirt),
    Product("T-Shirts", R.drawable.mensclothings_tshirt),
    Product("T-Shirts", R.drawable.mensclothings_tshirt),
    Product("T-Shirts", R.drawable.mensclothings_tshirt),
    Product("T-Shirts", R.drawable.mensclothings_tshirt),
    Product("T-Shirts", R.drawable.mensclothings_tshirt),
)



@Composable
fun CategoryElectronicsContentGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(bottom = 16.dp)
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
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(bottom = 16.dp)
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
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(bottom = 16.dp)
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
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        items(womenClothingItems.size) { itemIndex ->
            CategoryWomenClothingItem(womenClothingItems[itemIndex])
        }
    }
}


@Composable
fun CategoryElectronicItem(categoryItem: CategoryElectronicItems) {
    Column(
        modifier = Modifier
            .padding(top = 8.dp)
            .border(1.dp, MaterialTheme.colorScheme.outline)
            .padding(8.dp)
            .wrapContentSize()
    ) {
        Image(
            painter = painterResource(id = categoryItem.imageRes),
            contentDescription = categoryItem.title,
            modifier = Modifier
                .fillMaxWidth()
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

@Composable
fun CategoryJeweleryItem(categoryItem: CategoryJeweleryItems) {
    Column(
        modifier = Modifier
            .padding(top = 8.dp)
            .border(1.dp, MaterialTheme.colorScheme.outline)
            .padding(8.dp)
            .wrapContentSize()
    ) {
        Image(
            painter = painterResource(id = categoryItem.imageRes),
            contentDescription = categoryItem.title,
            modifier = Modifier
                .fillMaxWidth()
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

@Composable
fun CategoryMensClothingItem(categoryItem: CategoryMensClothingItems) {
    Column(
        modifier = Modifier
            .padding(top = 8.dp)
            .border(1.dp, MaterialTheme.colorScheme.outline)
            .padding(8.dp)
            .wrapContentSize()
    ) {
        Image(
            painter = painterResource(id = categoryItem.imageRes),
            contentDescription = categoryItem.title,
            modifier = Modifier
                .fillMaxWidth()
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


@Composable
fun CategoryWomenClothingItem(categoryItem: CategoryWomenClothingItems) {
    Column(
        modifier = Modifier
            .padding(top = 8.dp)
            .border(1.dp, MaterialTheme.colorScheme.outline)
            .padding(8.dp)
            .wrapContentSize()
    ) {
        Image(
            painter = painterResource(id = categoryItem.imageRes),
            contentDescription = categoryItem.title,
            modifier = Modifier
                .fillMaxWidth()
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


@Composable
fun ProductItem(product: Product) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .border(1.dp, MaterialTheme.colorScheme.outline)
            .padding(8.dp)
            .width(150.dp)
    ) {

        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        )


        Text(
            text = product.title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController())
}
