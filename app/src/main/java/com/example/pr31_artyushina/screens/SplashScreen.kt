package com.example.pr31_artyushina.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(true) {
        delay(2000)
        navController.navigate("onboard")
    }
    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFF58B2F1)),
        contentAlignment = Alignment.Center
    ) {
        Icon(Icons.Default.ShoppingBag, contentDescription = null, tint = Color.White, modifier = Modifier.size(80.dp))
    }
}