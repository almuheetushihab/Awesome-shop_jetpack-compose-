package com.example.awesome_shop_jetpack_compose.customappber

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.awesome_shop_jetpack_compose.R
import com.example.awesome_shop_jetpack_compose.sharedpreference.SharedPreferenceHelper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(navController: NavController, title: String) {
    val (expanded, setExpanded) = remember { mutableStateOf(false) }
    val context = LocalContext.current
    val sharedPreferenceHelper = SharedPreferenceHelper(context)

    SmallTopAppBar(
        title = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack()}) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = { setExpanded(true) }) {
                Icon(
                    Icons.Filled.MoreVert,
                    contentDescription = "Settings",
                    tint = Color.White
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { setExpanded(false) }
            ) {
                DropdownMenuItem(
                    text = { Text("Cart") },
                    onClick = {
                        setExpanded(false)
                        navController.navigate("cart_screen"){
                            popUpTo("home_screen") { inclusive = true }
                        }
                    }
                )
                DropdownMenuItem(
                    text = { Text("Logout") },
                    onClick = {
                        setExpanded(false)
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
        ),
        modifier = Modifier.fillMaxWidth()
    )
}
