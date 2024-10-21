package com.example.awesome_shop_jetpack_compose.customappber

import androidx.compose.ui.res.painterResource

package com.example.awesome_shop_jetpack_compose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.awesome_shop_jetpack_compose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(navController: NavController, title: String) {
    val (expanded, setExpanded) = remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Text(
                text = title,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "Back"
                )
            }
        },
        actions = {
            IconButton(onClick = { setExpanded(true) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_settings),
                    contentDescription = "Settings"
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
                    }
                )
                DropdownMenuItem(
                    text = { Text("Logout") },
                    onClick = {
                        setExpanded(false)
                    }
                )
            }
        },
        modifier = Modifier.padding(8.dp)
    )
}
