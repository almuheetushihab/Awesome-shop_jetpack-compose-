package com.example.awesome_shop_jetpack_compose.loginscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.awesome_shop_jetpack_compose.R
import com.example.awesome_shop_jetpack_compose.sharedpreference.SharedPreferenceHelper

@Composable
fun SplashScreen(navController: NavController, sharedPreferences: SharedPreferenceHelper) {

    LaunchedEffect(key1 = true) {
        kotlinx.coroutines.delay(2000)

        val isLoggedIn = sharedPreferences.getToken() != null
        if (isLoggedIn) {
            val fullName = sharedPreferences.getFullName() ?: "User"
            navController.navigate("home_screen/$fullName")
        } else {
            navController.navigate("login_screen")
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.app_logos),
            contentDescription = "App Logo",
            modifier = Modifier.size(120.dp)
        )
    }
}
