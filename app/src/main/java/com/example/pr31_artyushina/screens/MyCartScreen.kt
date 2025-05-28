package com.example.pr31_artyushina.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp
import com.example.pr31_artyushina.viewmodel.ProductViewModel

@Composable
fun MyCartScreen(viewModel: ProductViewModel, onBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        IconButton(onClick = onBack) {
            Icon(Icons.Default.ArrowBack, contentDescription = null)
        }
        LazyColumn {
            items(viewModel.cartItems) { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth().padding(8.dp)
                ) {
                    IconButton(onClick = { viewModel.decreaseQuantity(item) }) {
                        Text("-")
                    }
                    Text("${item.quantity}")
                    IconButton(onClick = { viewModel.increaseQuantity(item) }) {
                        Text("+")
                    }
                    Spacer(Modifier.width(8.dp))
                    Text(item.product.name)
                    Spacer(Modifier.weight(1f))
                    Text("₽${item.product.price * item.quantity}")
                    IconButton(onClick = { viewModel.removeFromCart(item) }) {
                        Icon(Icons.Default.Delete, contentDescription = null)
                    }
                }
            }
        }
        val total = viewModel.cartItems.sumOf { it.product.price * it.quantity }
        Text("Итого: ₽$total", modifier = Modifier.padding(16.dp))
        Button(onClick = { /* оформить заказ */ }, modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Text("Оформить заказ")
        }
    }
}