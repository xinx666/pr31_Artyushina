package com.example.pr31_artyushina.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pr31_artyushina.screens.HomeScreen
import com.example.pr31_artyushina.screens.SignInScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "signIn") {
        composable("signIn") { SignInScreen(navController) }
        composable("home") { HomeScreen() }
    }
}