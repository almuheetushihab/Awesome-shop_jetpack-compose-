package com.example.awesome_shop_jetpack_compose.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.awesome_shop_jetpack_compose.cartscreen.CartScreen
import com.example.awesome_shop_jetpack_compose.homescreen.HomeScreenWithAppBar
import com.example.awesome_shop_jetpack_compose.loginscreen.LoginScreen
import com.example.awesome_shop_jetpack_compose.loginscreen.SplashScreen
import com.example.awesome_shop_jetpack_compose.productsdetailsscreen.ProductDetailsScreen
import com.example.awesome_shop_jetpack_compose.signupscreen.SignUpScreen
import com.example.awesome_shop_jetpack_compose.viewmodel.LoginViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.awesome_shop_jetpack_compose.categoryscreen.CategoryScreen
import com.example.awesome_shop_jetpack_compose.homescreen.ProductsListScreen
import com.example.awesome_shop_jetpack_compose.sharedpreference.SharedPreferenceHelper

@Composable
fun AppNavigation(context: Context) {
    val navController = rememberNavController()
    val loginViewModel = hiltViewModel<LoginViewModel>()
    val sharedPreferences = SharedPreferenceHelper(context)

    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navController, sharedPreferences = sharedPreferences)
        }
        composable("login_screen") {
            LoginScreen(navController, loginViewModel)
        }
        composable("signup_screen") {
            SignUpScreen(navController)
        }
        composable("home_screen/{fullName}") { backStackEntry ->
            val fullName = backStackEntry.arguments?.getString("fullName") ?: "User"
            HomeScreenWithAppBar(navController, fullName)
        }
        composable("product_details_screen/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull()
            ProductDetailsScreen(navController, productId.toString())
        }
        composable("cart_screen") {
            CartScreen(navController)
        }
        composable("products_list_screen/{category}") {
            ProductsListScreen(navController)
        }

        composable(
            "category_screen/{categoryTitle}",
            arguments = listOf(navArgument("categoryTitle") { type = NavType.StringType })
        ) { backStackEntry ->
            val categoryTitle = backStackEntry.arguments?.getString("categoryTitle")
            if (categoryTitle != null) {
                CategoryScreen(navController = navController, categoryTitle = categoryTitle)
            }
        }

    }
}
