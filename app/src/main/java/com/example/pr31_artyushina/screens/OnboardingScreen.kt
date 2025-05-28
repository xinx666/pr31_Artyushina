package com.example.pr31_artyushina.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pr31_artyushina.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

val pages = listOf(
    OnboardPage("Добро пожаловать", R.drawable.shoe1),
    OnboardPage("Начнем путешествие", R.drawable.shoe2),
    OnboardPage("У вас есть сила", R.drawable.shoe3)
)

@Composable
fun OnboardingScreen(navController: NavHostController) {
    val pagerState = rememberPagerState(pageCount = { pages.size })
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF58B2F1)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        HorizontalPager(state = pagerState) { page ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(id = pages[page].imageRes), contentDescription = null)
                Text(text = pages[page].title, style = MaterialTheme.typography.titleLarge, color = Color.White)
            }
        }

        HorizontalPagerIndicator(pagerState = pagerState)

        Button(
            onClick = {
                if (pagerState.currentPage == pages.size - 1) {
                    navController.navigate("popular")
                } else {
                    CoroutineScope(Dispatchers.Main).launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }
            },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text(text = if (pagerState.currentPage == pages.size - 1) "Готово" else "Далее")
        }
    }
}

data class OnboardPage(val title: String, val imageRes: Int)