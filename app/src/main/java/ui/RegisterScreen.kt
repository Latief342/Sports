package com.example.sports.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sports.AuthViewModel
import com.example.sports.R

@Composable
fun RegisterScreen(
    authViewModel: AuthViewModel,
    onBackToLogin: () -> Unit
) {

    var fullName by remember {
        mutableStateOf("")
    }

    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    val message by authViewModel.message.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(
                id = R.drawable.sports_banner
            ),
            contentDescription = "Sports Banner",
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),

            shape = RoundedCornerShape(20.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "REGISTER",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                OutlinedTextField(
                    value = fullName,
                    onValueChange = {
                        fullName = it
                    },

                    label = {
                        Text("Nama Lengkap")
                    },

                    modifier = Modifier.fillMaxWidth(),

                    singleLine = true
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                OutlinedTextField(
                    value = username,
                    onValueChange = {
                        username = it
                    },

                    label = {
                        Text("Username")
                    },

                    modifier = Modifier.fillMaxWidth(),

                    singleLine = true
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },

                    label = {
                        Text("Password")
                    },

                    visualTransformation =
                        PasswordVisualTransformation(),

                    modifier = Modifier.fillMaxWidth(),

                    singleLine = true
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Button(
                    onClick = {

                        authViewModel.register(
                            fullName,
                            username,
                            password
                        )
                    },

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {

                    Text(
                        text = "DAFTAR"
                    )
                }

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                TextButton(
                    onClick = onBackToLogin
                ) {

                    Text(
                        text = "Sudah punya akun? Login"
                    )
                }

                if (message.isNotEmpty()) {

                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )

                    Text(
                        text = message
                    )
                }
            }
        }
    }
}