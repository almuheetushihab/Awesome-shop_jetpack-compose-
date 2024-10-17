package com.example.awesome_shop_jetpack_compose.loginscreen

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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.awesome_shop_jetpack_compose.R
import com.example.awesome_shop_jetpack_compose.ui.theme.Awesomeshop_jetpackcomposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var fullName by rememberSaveable { mutableStateOf("") }
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    var fullNameError by rememberSaveable { mutableStateOf("") }
    var usernameError by rememberSaveable { mutableStateOf("") }
    var passwordError by rememberSaveable { mutableStateOf("") }
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
            .imePadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.app_logos),
            contentDescription = "Logo",
            modifier = Modifier
                .size(120.dp)
                .padding(top = 30.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Awesome\nShop",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Full Name",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = fullName,
            onValueChange = {
                fullName = it
                fullNameError = validateFullName(it)
            },
            placeholder = { Text("Enter your full name") },
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

        if (fullNameError.isNotEmpty()) {
            Text(
                text = fullNameError,
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Username",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = username,
            onValueChange = {
                username = it
                usernameError = validateUsername(it)
            },
            placeholder = { Text("Enter your username") },
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
        if (usernameError.isNotEmpty()) {
            Text(
                text = usernameError,
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Password",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                passwordError = validatePassword(it)
            },
            placeholder = { Text("Enter your password") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray.copy(alpha = 0.2f)),
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        painter = painterResource(id = if (passwordVisible) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24),
                        contentDescription = if (passwordVisible) stringResource(id = R.string.hide_password) else stringResource(
                            id = R.string.show_password
                        )
                    )
                }
            },
            colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            )
        )

        if (passwordError.isNotEmpty()) {
            Text(
                text = passwordError,
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(35.dp),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = {
                Toast.makeText(context, "Forgot Password Clicked", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Forgot Password?", color = Color.Blue, fontSize = 13.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (validateFields(
                        fullName, username, password,
                        { fullNameError = it }, { usernameError = it }, { passwordError = it }
                    )
                ) {
                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.size(150.dp, 40.dp)
        ) {
            Text(text = stringResource(id = R.string.login), fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Or Sign Up Using",
            fontSize = 14.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.Center
        ) {

            IconButton(onClick = {
                Toast.makeText(context, "Facebook Clicked", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.facebook_brands_solid),
                    contentDescription = "Facebook",
                    tint = Color.Blue
                )
            }

            IconButton(onClick = {
                Toast.makeText(context, "Twitter Clicked", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.square_twitter_brands_solid),
                    contentDescription = "Twitter",
                    tint = colorResource(R.color.twitter_blue)
                )
            }

            IconButton(onClick = {
                Toast.makeText(
                    context,
                    "Google Plus Clicked",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.google_plus_brands_solid),
                    contentDescription = "Google Plus",
                    tint = Color.Red
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Or Sign Up Using",
            fontSize = 14.sp,
            color = Color.Blue,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp)
        )

        TextButton(
            onClick = {
                navController.navigate("signup_screen")
            },
            modifier = Modifier.size(100.dp, 40.dp)
        ) {
            Text(text = "Sign Up", fontWeight = FontWeight.Bold, color = Color.Blue)
        }
    }
}

fun validateFullName(fullName: String): String {
    return when {
        fullName.isEmpty() -> ""
        fullName.isEmpty() || fullName.any { it.isDigit() } -> "Invaild name"
        fullName.length < 3 -> "Full name should be at least 3 characters long"
        else -> ""
    }
}

fun validateUsername(username: String): String {
    return if (username.isEmpty()) {
        ""
    } else if (username.length < 3) {
        "Username should be at least 3 characters long"
    } else {
        ""
    }
}

fun validatePassword(password: String): String {
    return if (password.isEmpty()) {
        ""
    } else if (password.length < 6) {
        "Password should be at least 6 characters long"
    } else {
        ""
    }
}

fun validateFields(
    fullName: String,
    username: String,
    password: String,
    onFullNameError: (String) -> Unit,
    onUsernameError: (String) -> Unit,
    onPasswordError: (String) -> Unit
): Boolean {
    var isValid = true


    val fullNameValidation = validateFullName(fullName)
    if (fullNameValidation.isNotEmpty()) {
        onFullNameError(fullNameValidation)
        isValid = false
    } else {
        onFullNameError("")
    }

    val usernameValidation = validateUsername(username)
    if (usernameValidation.isNotEmpty()) {
        onUsernameError(usernameValidation)
        isValid = false
    } else {
        onUsernameError("")
    }

    val passwordValidation = validatePassword(password)
    if (passwordValidation.isNotEmpty()) {
        onPasswordError(passwordValidation)
        isValid = false
    } else {
        onPasswordError("")
    }

    return isValid
}

@Preview(showBackground = true)
@Composable
fun LoginScreensPreview() {
    Awesomeshop_jetpackcomposeTheme {
        LoginScreen(navController = NavController(LocalContext.current))
    }
}
