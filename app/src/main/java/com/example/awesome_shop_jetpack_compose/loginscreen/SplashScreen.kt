package com.example.awesome_shop_jetpack_compose.loginscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.awesome_shop_jetpack_compose.sharedpreference.SharedPreferenceHelper

@Composable
fun SplashScreen(navController: NavController) {
    val context = LocalContext.current
    val sharedPreferenceHelper = SharedPreferenceHelper(context)
    val savedLoginData = sharedPreferenceHelper.getLoginData()


    LaunchedEffect(Unit) {
        savedLoginData.let {
            if (it.first != null && it.second != null && it.third != null) {

                navController.navigate("home_screen/${it.first}") {
                    popUpTo("splash_screen") { inclusive = true }
                }
            } else {

                navController.navigate("login_screen") {
                    popUpTo("splash_screen") { inclusive = true }
                }
            }
        }
    }


    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Loading...", fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}
