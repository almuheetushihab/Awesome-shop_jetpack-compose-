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
import com.example.awesome_shop_jetpack_compose.homescreen.ProductListScreen
import com.example.awesome_shop_jetpack_compose.sharedpreference.SharedPreferenceHelper
import com.example.awesome_shop_jetpack_compose.viewmodel.CartViewModel

@Composable
fun AppNavigation(context: Context) {
    val navController = rememberNavController()
    val loginViewModel = hiltViewModel<LoginViewModel>()
    val cartViewModel = hiltViewModel<CartViewModel>()
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

        composable("all_products_screen") {
            // Assuming you have a full product list (replace `productList` with your actual data source)
            ProductListScreen(
                navController = navController,
                products = emptyList(), // Pass the full product list here
                navigateToProductDetails = { productId ->
                    navController.navigate("product_details_screen/$productId")
                }
            )
        }
    }
}
