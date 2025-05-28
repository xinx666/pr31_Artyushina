package com.example.pr31_artyushina.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Главная", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))

        Row {
            Button(onClick = {}, modifier = Modifier.padding(end = 8.dp)) {
                Text("Все")
            }
            Button(onClick = {}, modifier = Modifier.padding(end = 8.dp)) {
                Text("Outdoor")
            }
            Button(onClick = {}) {
                Text("Tennis")
            }
        }

        Spacer(Modifier.height(16.dp))
        Text("Популярное", style = MaterialTheme.typography.titleMedium)

        LazyRow {
            items(2) {
                Card(
                    Modifier
                        .padding(8.dp)
                        .width(150.dp)
                ) {
                    Column(Modifier.padding(8.dp)) {
                        Text("Nike Air Max", fontWeight = FontWeight.Bold)
                        Text("₽752.00")
                    }
                }
            }
        }
    }
}