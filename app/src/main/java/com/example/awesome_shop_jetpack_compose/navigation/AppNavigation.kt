package com.example.awesome_shop_jetpack_compose.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
    }
}
