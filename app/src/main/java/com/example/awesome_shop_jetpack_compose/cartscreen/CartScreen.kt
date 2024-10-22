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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.awesome_shop_jetpack_compose.customappber.CustomAppBar

@Composable
fun CartScreen(navController: NavController) {
    var quantity by remember { mutableStateOf(1) }
    var expanded by remember { mutableStateOf(false) }
    var selectedColor by remember { mutableStateOf("Blue") }
    val colors = listOf("Blue", "Red", "Green", "Black")
    val pricePerItem = 109.95
    val totalPrice = remember { derivedStateOf { quantity * pricePerItem } }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomAppBar(navController, title = "Cart")
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp),
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Product Name: Backpack",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Price:", fontSize = 16.sp)
                    Text(text = "$pricePerItem৳", fontSize = 16.sp)
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Quantity:", fontSize = 16.sp)

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "$quantity pcs", fontSize = 16.sp)

                        Spacer(modifier = Modifier.height(8.dp))

                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Total:", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Text(
                        text = String.format("%.1f৳", totalPrice.value),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
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
                                if (quantity > 1) quantity--
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
                            onClick = { quantity++ },
                            modifier = Modifier.size(40.dp),
                            colors = ButtonDefaults.textButtonColors()
                        ) {
                            Text(text = "+", fontSize = 20.sp)
                        }
                    }
                }

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
                text = String.format("%.2f৳", totalPrice.value),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Button(
            onClick = {
                Toast.makeText(context, "Order Placed Successfully!", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.width(100.dp)
        ) {
            Text(text = "Order", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    CartScreen(navController = rememberNavController())
}
