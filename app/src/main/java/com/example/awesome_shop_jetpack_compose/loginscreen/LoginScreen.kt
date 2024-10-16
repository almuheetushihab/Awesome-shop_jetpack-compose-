package com.example.awesome_shop_jetpack_compose.loginscreen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.awesome_shop_jetpack_compose.R
import com.example.awesome_shop_jetpack_compose.ui.theme.Awesomeshop_jetpackcomposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    var fullName by rememberSaveable { mutableStateOf("") }
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.app_logos),
            contentDescription = "Logo",
            modifier = Modifier
                .size(120.dp)
                .padding(top = 24.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Awesome\nShop",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(40.dp))

        OutlinedTextField(
            value = fullName,
            onValueChange = { fullName = it },
            label = { Text("Full Name") },
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Transparent)
                .background(Color.Gray.copy(alpha = 0.2f)),
            singleLine = true,
            colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray.copy(alpha = 0.2f)),
            singleLine = true,
            colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray.copy(alpha = 0.2f)),
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        painter = painterResource(id = if (passwordVisible) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24),
                        contentDescription = if (passwordVisible) stringResource(id = R.string.hide_password) else stringResource(id = R.string.show_password)
                    )
                }
            },
            colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(8.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = {
                Toast.makeText(context, "Forgot Password Clicked", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Forgot Password")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (validateFields(fullName, username, password, context)) {
                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.size(150.dp, 40.dp)
        ) {
            Text(text = stringResource(id = R.string.login), fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "or Sign Up using",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = { Toast.makeText(context, "Facebook Clicked", Toast.LENGTH_SHORT).show() }) {
                Icon(painter = painterResource(id = R.drawable.facebook_brands_solid), contentDescription = "Facebook")
            }
            IconButton(onClick = { Toast.makeText(context, "Twitter Clicked", Toast.LENGTH_SHORT).show() }) {
                Icon(painter = painterResource(id = R.drawable.baseline_arrow_circle_left_24), contentDescription = "Twitter")
            }
            IconButton(onClick = { Toast.makeText(context, "Google Plus Clicked", Toast.LENGTH_SHORT).show() }) {
                Icon(painter = painterResource(id = R.drawable.baseline_arrow_circle_left_24), contentDescription = "Google Plus")
            }
        }
        Spacer(modifier = Modifier.height(50.dp))


        TextButton(
            onClick = {
                Toast.makeText(context, "Sign Up Clicked", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.size(150.dp, 40.dp)
        ) {
            Text(text = "Sign Up", fontWeight = FontWeight.Bold)
        }
    }
}

fun validateFields(
    fullName: String,
    username: String,
    password: String,
    context: Context
): Boolean {
    if (fullName.isEmpty() || fullName.any { it.isDigit() } || fullName.trim().isEmpty()) {
        Toast.makeText(context, context.getString(R.string.login_failed_error), Toast.LENGTH_SHORT).show()
        return false
    }
    if (fullName.length < 3) {
        Toast.makeText(context, context.getString(R.string.name_length_error), Toast.LENGTH_SHORT).show()
        return false
    }
    if (username.length < 3) {
        Toast.makeText(context, context.getString(R.string.user_length_error), Toast.LENGTH_SHORT).show()
        return false
    }
    if (password.length < 6) {
        Toast.makeText(context, context.getString(R.string.password_length_error), Toast.LENGTH_SHORT).show()
        return false
    }
    return true
}

@Preview(showBackground = true)
@Composable
fun LoginScreensPreview() {
    Awesomeshop_jetpackcomposeTheme {
        LoginScreen()
    }
}
