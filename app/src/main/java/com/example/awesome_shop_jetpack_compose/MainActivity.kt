package com.example.awesome_shop_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.awesome_shop_jetpack_compose.loginscreen.LoginScreen
import com.example.awesome_shop_jetpack_compose.navigation.AppNavigation
import com.example.awesome_shop_jetpack_compose.signupscreen.SignUpScreen
import com.example.awesome_shop_jetpack_compose.ui.theme.Awesomeshop_jetpackcomposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Awesomeshop_jetpackcomposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AwesomeShopPreview() {
    Awesomeshop_jetpackcomposeTheme {
        AppNavigation()
    }
}