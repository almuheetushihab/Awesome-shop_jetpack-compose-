package com.example.awesome_shop_jetpack_compose.homescreen

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.example.awesome_shop_jetpack_compose.MainActivity
import com.example.awesome_shop_jetpack_compose.R
import com.example.awesome_shop_jetpack_compose.data.CategoryElectronicItems
import com.example.awesome_shop_jetpack_compose.data.CategoryJeweleryItems
import com.example.awesome_shop_jetpack_compose.data.CategoryMensClothingItems
import com.example.awesome_shop_jetpack_compose.data.CategoryWomenClothingItems
import com.example.awesome_shop_jetpack_compose.data.electronicsItems
import com.example.awesome_shop_jetpack_compose.data.getProductResponse
import com.example.awesome_shop_jetpack_compose.data.jeweleryItems
import com.example.awesome_shop_jetpack_compose.data.menClothingItems
import com.example.awesome_shop_jetpack_compose.data.womenClothingItems
import com.example.awesome_shop_jetpack_compose.models.product.ProductsResponse
import com.example.awesome_shop_jetpack_compose.models.product.ProductsResponseItem
import com.example.awesome_shop_jetpack_compose.sharedpreference.SharedPreferenceHelper
import com.example.awesome_shop_jetpack_compose.viewmodel.CategoriesViewModel
import com.example.awesome_shop_jetpack_compose.viewmodel.CategoryWiseProductViewModel
import com.example.awesome_shop_jetpack_compose.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenWithAppBar(navController: NavController, fullName: String) {
    var menuExpanded by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val sharedPreferenceHelper = SharedPreferenceHelper(context)

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Awesome Shop",
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { menuExpanded = true }) {
                        Icon(
                            Icons.Filled.MoreVert,
                            contentDescription = "Settings",
                            tint = Color.White
                        )
                    }

                    DropdownMenu(
                        expanded = menuExpanded,
                        onDismissRequest = { menuExpanded = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Cart") },
                            onClick = {
                                menuExpanded = false
                                Toast.makeText(context, "Cart Clicked", Toast.LENGTH_SHORT).show()
                                navController.navigate("cart_screen") {
                                    popUpTo("home_screen") { inclusive = true }
                                }
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Logout") },
                            onClick = {
                                menuExpanded = false
                                Toast.makeText(context, "Logout Clicked", Toast.LENGTH_SHORT).show()
                                sharedPreferenceHelper.clearCredentials()
                                navController.navigate("login_screen") {
                                    popUpTo("home_screen") { inclusive = true }
                                }
                            }
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF6200EE)
                )
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            HomeScreen(
                navController = navController,
                modifier = Modifier.padding(paddingValues),
                fullName = fullName
            )
        }
    }
}

@Composable
fun HomeScreen(
    navController: NavController,
    fullName: String,
    productViewModel: ProductViewModel = hiltViewModel(),
    categoriesViewModel: CategoriesViewModel = hiltViewModel(),
    categoryWiseProductViewModel: CategoryWiseProductViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    LaunchedEffect(Unit) {
        productViewModel.getProducts()

    }
    var selectedTabIndex by remember { mutableStateOf(0) }
    val productsResponse by productViewModel.items.observeAsState()
    val categories by categoriesViewModel.items.observeAsState()
    val products by categoryWiseProductViewModel.items.observeAsState()

    LaunchedEffect(Unit) {
        categoriesViewModel.getCategories()
    }

    LaunchedEffect(selectedTabIndex) {
        categories?.get(selectedTabIndex)?.let { category ->
            categoryWiseProductViewModel.getCategoryWiseProducts(category)
        }
    }


    HomeScreenSkeleton(
        fullName = fullName,
        tabTitle = categories ?: emptyList(),
        selectedTabIndex = selectedTabIndex,
        product = productsResponse,
        onTabSelected = { index -> selectedTabIndex = index },
        products = products,
        navigateToProductDetails = {
            navController.navigate("product_details_screen/${it}")
        },
        navController = navController
    )

}

@Composable
fun HomeScreenSkeleton(
    fullName: String,
    tabTitle: List<String>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    products: List<ProductsResponseItem>?,
    product: ProductsResponse?,
    navigateToProductDetails: (Int) -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val activity = context as? MainActivity

    BackHandler {
        Toast.makeText(
            context,
            "Exiting the app...",
            Toast.LENGTH_SHORT
        ).show()
        activity?.finish()
    }


    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = "Welcome, $fullName",
            style = MaterialTheme.typography.headlineMedium,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )

        if (tabTitle.isNotEmpty()) {
            ScrollableTabRow(selectedTabIndex = selectedTabIndex, edgePadding = 0.dp) {
                tabTitle.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = {
                            onTabSelected(index)
                        },
                        text = { Text(title) }
                    )
                }
            }
        } else {
            Text(
                text = "No categories available",
                color = Color.Gray,
                modifier = Modifier.padding(16.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    navController.navigate("category_screen/${tabTitle[selectedTabIndex]}") {
                        popUpTo("home_screen") { inclusive = false }
                    }
                }
            ) {
                Text(
                    text = "See All",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(8.dp)
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


        if (!products.isNullOrEmpty()) {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                items(products.size) { index ->
                    val product = products[index]
                    ProductItem(product = product) {
                        navigateToProductDetails(product.id)
                    }
                }
            }
        } else {
            Text(
                text = "No products available for this category",
                modifier = Modifier.padding(16.dp),
                color = Color.Gray
            )
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
                    .padding(end = 8.dp, bottom = 8.dp, top = 8.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable {
                    }
            ) {
                Text(
                    text = "See All",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(8.dp)
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
            verticalArrangement = Arrangement.spacedBy(6.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)
        ) {
            items(minOf(6, product?.size ?: 0)) { index ->
                val product = product?.get(index)
                if (product != null) {
                    ProductItem(product = product) {
                        navigateToProductDetails(product.id)
                    }
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenSkeletonPreview() {
    HomeScreenSkeleton(
        fullName = "John DOE",
        tabTitle = listOf("Electronics", "Jewelery", "Men's clothing", "Women's clothing"),
        product = getProductResponse(),
        navigateToProductDetails = {},
        selectedTabIndex = 0,
        onTabSelected = {},
        products = emptyList(),
        navController = rememberNavController()
    )
}