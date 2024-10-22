package com.example.awesome_shop_jetpack_compose.cartscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.awesome_shop_jetpack_compose.customappber.CustomAppBar

@Composable
fun CartScreen(navController: NavController) {
    var quantity by remember { mutableStateOf(120) }
    val pricePerItem = 109.95
    val totalPrice = remember { derivedStateOf { quantity * pricePerItem } }

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

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        TextButton(
                            onClick = { quantity++ },
                            modifier = Modifier.size(40.dp),
                            colors = ButtonDefaults.buttonColors(),
                            shape = MaterialTheme.shapes.small
                        ) {
                            Text(text = "-", color = Color.White, fontSize = 20.sp)
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        TextButton(
                            onClick = { quantity++ },
                            modifier = Modifier.size(40.dp),
                            colors = ButtonDefaults.buttonColors(),
                            shape = MaterialTheme.shapes.small
                        ) {
                            Text(text = "+", color = Color.White, fontSize = 20.sp)
                        }
                    }

                }
            }
        }

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

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
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

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        TextButton(
                            onClick = { quantity++ },
                            modifier = Modifier.size(40.dp),
                            colors = ButtonDefaults.buttonColors(),
                            shape = MaterialTheme.shapes.small
                        ) {
                            Text(text = "-", color = Color.White, fontSize = 20.sp)
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        TextButton(
                            onClick = { quantity++ },
                            modifier = Modifier.size(40.dp),
                            colors = ButtonDefaults.buttonColors(),
                            shape = MaterialTheme.shapes.small
                        ) {
                            Text(text = "+", color = Color.White, fontSize = 20.sp)
                        }
                    }

                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
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

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
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

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        TextButton(
                            onClick = { quantity++ },
                            modifier = Modifier.size(40.dp),
                            colors = ButtonDefaults.buttonColors(),
                            shape = MaterialTheme.shapes.small
                        ) {
                            Text(text = "-", color = Color.White, fontSize = 20.sp)
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        TextButton(
                            onClick = { quantity++ },
                            modifier = Modifier.size(40.dp),
                            colors = ButtonDefaults.buttonColors(),
                            shape = MaterialTheme.shapes.small
                        ) {
                            Text(text = "+", color = Color.White, fontSize = 20.sp)
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
            onClick = { },
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
