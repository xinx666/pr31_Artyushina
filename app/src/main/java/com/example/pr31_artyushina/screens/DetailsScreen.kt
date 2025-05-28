package com.example.pr31_artyushina.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.pr31_artyushina.data.model.Product
import com.example.pr31_artyushina.viewmodel.ProductViewModel

@Composable
fun DetailsScreen(product: Product, viewModel: ProductViewModel, onBack: () -> Unit, onCart: () -> Unit) {
    Column {
        IconButton(onClick = onBack) {
            Icon(Icons.Default.ArrowBack, contentDescription = null)
        }
        Text(product.name, style = MaterialTheme.typography.h5)
        Image(painter = painterResource(id = product.imageResId), contentDescription = null)
        Text(product.description)
        Text("₽${product.price}")
        Button(onClick = {
            viewModel.addToCart(product)
            onCart()
        }) {
            Text("В Корзину")
        }
    }
}