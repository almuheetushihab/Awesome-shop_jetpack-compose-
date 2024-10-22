package com.example.awesome_shop_jetpack_compose.productsdetailsscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.awesome_shop_jetpack_compose.R
import com.example.awesome_shop_jetpack_compose.customappber.CustomAppBar

@Composable
fun ProductDetailsScreen(
    navController: NavController,
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomAppBar(navController, title = "Product Details")
        Image(
            painter = painterResource(id = R.drawable.mensclothings_backpack),
            contentDescription = "Product Image",
            modifier = Modifier
                .size(400.dp)
                .padding(16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Title :",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = " Backpack",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Price :",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = " 109.96৳",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "men's clothing",
                fontSize = 16.sp,
                color = Color.Black
            )
            Text(
                text = "Rating : 3.9",
                fontSize = 16.sp,
                color = Color.Black
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Start
        ){
            Text(
                text = "Description : Your perfect pack for everyday use and walks in the forest.Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProductDetailsScreenPreview() {
    ProductDetailsScreen(
        navController = rememberNavController(),
    )
}

//
//@Composable
//fun CartScreen(navController: NavController) {
//    var quantity by remember { mutableStateOf(1) }
//    var expanded by remember { mutableStateOf(false) }
//    var selectedColor by remember { mutableStateOf("Blue") }
//    val colors = listOf("Blue", "Red", "Green", "Black")
//
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//            .verticalScroll(rememberScrollState()),
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {

//        CustomAppBar(navController, title = "Cart")
//

//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 16.dp),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            // Dropdown for selecting color
//            Row(
//                modifier = Modifier.wrapContentSize(),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                TextButton(
//                    onClick = { expanded = true },
//                    colors = ButtonDefaults.textButtonColors(),
//                    shape = MaterialTheme.shapes.small
//                ) {
//                    Text(text = selectedColor)
//                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Dropdown Arrow")
//                }
//
//
//                DropdownMenu(
//                    expanded = expanded,
//                    onDismissRequest = { expanded = false }
//                ) {
//                    colors.forEach { color ->
//                        DropdownMenuItem(
//                            onClick = {
//                                selectedColor = color
//                                expanded = false
//                            }
//                        ) {
//                            Text(text = color)
//                        }
//                    }
//                }
//            }
//
//            // Quantity Buttons for increment/decrement
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                // Decrement Button
//                TextButton(
//                    onClick = {
//                        if (quantity > 1) quantity--
//                    },
//                    modifier = Modifier.size(40.dp),
//                    colors = ButtonDefaults.textButtonColors()
//                ) {
//                    Text(text = "-", fontSize = 20.sp)
//                }
//
//
//                Spacer(modifier = Modifier.width(16.dp))
//                Text(text = "$quantity", fontSize = 20.sp)
//                Spacer(modifier = Modifier.width(16.dp))
//
//
//                TextButton(
//                    onClick = { quantity++ },  // বাড়িয়ে আনা
//                    modifier = Modifier.size(40.dp),
//                    colors = ButtonDefaults.textButtonColors()
//                ) {
//                    Text(text = "+", fontSize = 20.sp)
//                }
//            }
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Total price and order button section
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Text(text = "Total Price:", fontSize = 18.sp, fontWeight = FontWeight.Bold)

//            Text(text = String.format("%.2f৳", quantity * 109.95), fontSize = 16.sp, fontWeight = FontWeight.Bold)
//        }
//
//        Spacer(modifier = Modifier.height(14.dp))
//
//        Button(
//            onClick = {
//            },
//            modifier = Modifier.width(100.dp)
//        ) {
//            Text(text = "Order", fontSize = 18.sp, fontWeight = FontWeight.Bold)
//        }
//    }
//}


