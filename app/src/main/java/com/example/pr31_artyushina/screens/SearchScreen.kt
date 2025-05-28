package com.example.pr31_artyushina.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.pr31_artyushina.data.model.Product
import com.example.pr31_artyushina.viewmodel.ProductViewModel

@Composable
fun SearchScreen(viewModel: ProductViewModel, onProductClick: (Product) -> Unit) {
    Column {
        OutlinedTextField(
            value = viewModel.searchQuery,
            onValueChange = {
                viewModel.searchQuery = it
                viewModel.searchProducts(it)
            },
            label = { Text("Поиск") },
            leadingIcon = { Icon(Icons.Default.Search, null) }
        )
        LazyColumn {
            items(viewModel.filteredProducts) { product ->
                ListItem(
                    headlineText = { Text(product.name) },
                    supportingText = { Text("₽${product.price}") },
                    leadingContent = {
                        Image(
                            painter = painterResource(product.imageResId),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    },
                    modifier = Modifier.clickable { onProductClick(product) }
                )
            }
        }
    }
}