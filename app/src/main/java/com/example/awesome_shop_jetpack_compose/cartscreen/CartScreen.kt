package com.example.awesome_shop_jetpack_compose.cartscreen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.awesome_shop_jetpack_compose.customappber.CartTopAppBar
import com.example.awesome_shop_jetpack_compose.customappber.CustomAppBar
import com.example.awesome_shop_jetpack_compose.models.product.ProductsResponseItem
import com.example.awesome_shop_jetpack_compose.viewmodel.CartViewModel

@Composable
fun CartScreen(navController: NavController, cartViewModel: CartViewModel = hiltViewModel()) {
    val cartItems by cartViewModel.items.observeAsState(emptyList())
    val context = LocalContext.current
    var totalPrice by remember { mutableStateOf(0.0) }

    LaunchedEffect(cartItems) {
        totalPrice = cartItems.sumOf { it.price * it.rating.count }
    }

    LaunchedEffect(Unit) {
        cartViewModel.cartData(cartId = 1)
    }

    Scaffold(
        topBar = {
            CartTopAppBar(navController, fullName = "", title = "Cart")
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                if (cartItems.isNotEmpty()) {
                    cartItems.forEach { product ->
                        CartItemCard(product) { newQuantity ->
                            val updatedItems = cartItems.map {
                                if (it.id == product.id) {
                                    it.copy(rating = it.rating.copy(count = newQuantity))
                                } else it
                            }
                            cartViewModel.items.value = updatedItems
                            totalPrice = updatedItems.sumOf { it.price * it.rating.count }
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Total Price:", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Text(
                            text = String.format("%.2f৳", totalPrice),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Button(
                        onClick = {
                            Toast.makeText(context, "Order Placed Successfully!", Toast.LENGTH_SHORT).show()
                            navController.navigate("home_screen"){
                                popUpTo("home_screen"){
                                    inclusive = true
                                }
                            }
                        },
                        modifier = Modifier.width(100.dp)
                    ) {
                        Text(text = "Order", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                } else {
                    CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                }
            }
        }
    )
}

@Composable
fun CartItemCard(product: ProductsResponseItem, onQuantityChange: (Int) -> Unit) {
    var quantity by remember { mutableStateOf(product.rating.count) }
    val totalPrice by remember { derivedStateOf { quantity * product.price } }
    var expanded by remember { mutableStateOf(false) }
    var selectedColor by remember { mutableStateOf("Blue") }
    val colors = listOf("Blue", "Red", "Green", "Black")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Product Name: ${product.title}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Price:", fontSize = 14.sp)
                Text(text = "${product.price}৳", fontSize = 14.sp)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(text = "Quantity:", fontSize = 14.sp)

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "$quantity pcs", fontSize = 14.sp)
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Total:", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = String.format("%.1f৳", totalPrice),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(
                    modifier = Modifier.wrapContentSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(
                        onClick = { expanded = !expanded },
                        colors = ButtonDefaults.textButtonColors(),
                        shape = MaterialTheme.shapes.small,
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .background(color = Color.White)
                    ) {
                        Text(text = selectedColor)

                        Spacer(modifier = Modifier.width(30.dp))

                        Icon(
                            imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.ArrowDropDown,
                            contentDescription = if (expanded) "Dropdown Up Arrow" else "Dropdown Down Arrow"
                        )
                    }

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        colors.forEach { color ->
                            DropdownMenuItem(
                                text = { Text(text = color) },
                                onClick = {
                                    selectedColor = color
                                    expanded = false
                                }
                            )
                        }
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(color = Color.White)
                        .padding(top = 4.dp, bottom = 4.dp)
                        .clip(
                            RoundedCornerShape(8.dp)
                        )
                ) {
                    TextButton(
                        onClick = {
                            if (quantity > 1) {
                                quantity--
                                onQuantityChange(quantity)
                            }
                        },
                        modifier = Modifier.size(40.dp),
                        colors = ButtonDefaults.textButtonColors()
                    ) {
                        Text(text = "-", fontSize = 20.sp)
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(text = "$quantity", fontSize = 20.sp)

                    Spacer(modifier = Modifier.width(16.dp))

                    TextButton(
                        onClick = {
                            quantity++
                            onQuantityChange(quantity)
                        },
                        modifier = Modifier.size(40.dp),
                        colors = ButtonDefaults.textButtonColors()
                    ) {
                        Text(text = "+", fontSize = 20.sp)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    CartScreen(navController = rememberNavController())
}

