package com.example.awesome_shop_jetpack_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.awesome_shop_jetpack_compose.homescreen.HomeScreen
import com.example.awesome_shop_jetpack_compose.homescreen.HomeScreenWithAppBar
import com.example.awesome_shop_jetpack_compose.loginscreen.LoginScreen
import com.example.awesome_shop_jetpack_compose.signupscreen.SignUpScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login_screen") {
        composable("login_screen") {
            LoginScreen(navController)
        }
        composable("signup_screen") {
            SignUpScreen(navController)
        }
        composable("home_screen") {
            HomeScreenWithAppBar()

        }
    }
}
