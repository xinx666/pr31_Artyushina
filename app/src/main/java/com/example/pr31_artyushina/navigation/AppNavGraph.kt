package com.example.pr31_artyushina.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pr31_artyushina.data.database.UserDao
import com.example.pr31_artyushina.screens.HomeScreen
import com.example.pr31_artyushina.screens.OnboardingScreen
import com.example.pr31_artyushina.screens.PopularScreen
import com.example.pr31_artyushina.screens.SearchScreen
import com.example.pr31_artyushina.screens.SignInScreen
import com.example.pr31_artyushina.screens.SplashScreen

@Composable
fun AppNavGraph(navController: NavHostController, userDao: UserDao) {
    NavHost(navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("home") { HomeScreen()}
        composable("onboard") { OnboardingScreen(navController) }
        composable("popular") { PopularScreen(userDao) }
        composable("search") {
            SearchScreen(viewModel) { product ->
                navController.navigate("details/${product.id}")
            }
        }
        composable("details/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            val product = viewModel.allProducts.find { it.id == id }
            if (product != null) {
                DetailsScreen(product, viewModel, onBack = { navController.popBackStack() }) {
                    navController.navigate("cart")
                }
            }
        }
        composable("cart") {
            MyCartScreen(viewModel, onBack = { navController.popBackStack() })
        }
    }
}