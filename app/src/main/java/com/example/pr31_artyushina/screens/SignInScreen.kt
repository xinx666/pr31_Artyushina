package com.example.pr31_artyushina.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pr31_artyushina.data.database.AppDatabase
import com.example.pr31_artyushina.data.model.User
import com.example.pr31_artyushina.data.repository.UserRepository
import com.example.pr31_artyushina.viewmodel.SignInViewModel

@Composable
fun SignInScreen(navController: NavHostController) {
    val context = LocalContext.current
    val db = AppDatabase.getDatabase(context)
    val repo = UserRepository(db.userDao())
    val viewModel = remember { SignInViewModel(repo) }

    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val loginSuccess by viewModel.loginSuccess.collectAsState()

    LaunchedEffect(Unit) {
        repo.insertUsers(
            listOf(
                User(email = "test1@gmail.com", password = "123456"),
                User(email = "test2@gmail.com", password = "123456"),
                User(email = "test3@gmail.com", password = "123456"),
                User(email = "test4@gmail.com", password = "123456"),
                User(email = "test5@gmail.com", password = "123456"),
            )
        )
    }

    LaunchedEffect(loginSuccess) {
        if (loginSuccess) {
            navController.navigate("home")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Привет!", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Пароль") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { viewModel.login(email.value, password.value) },
            modifier = Modifier.fillMaxWidth(),
            enabled = email.value.contains("@") && password.value.isNotEmpty()
        ) {
            Text("Войти")
        }
    }
}