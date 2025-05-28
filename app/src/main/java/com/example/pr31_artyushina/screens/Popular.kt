package com.example.pr31_artyushina.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pr31_artyushina.data.database.ShoeDao
import com.example.pr31_artyushina.data.database.UserDao
import com.example.pr31_artyushina.data.model.Shoe
import com.example.pr31_artyushina.data.model.User
import kotlinx.coroutines.launch

@Composable
fun PopularScreen(shoeDao: ShoeDao) {
    val scope = rememberCoroutineScope()
    var shoes by remember { mutableStateOf<List<Shoe>>(emptyList()) }
    LaunchedEffect(true) {
        scope.launch {
            shoes = shoeDao.getAll()
        }
    }

    LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(8.dp)) {
        items(shoes) { shoe ->
            Card(
                modifier = Modifier.padding(8.dp).fillMaxWidth(),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (shoe.isBestSeller) {
                        Text(
                            "BEST SELLER",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.Blue
                        )
                    }
                    Image(painter = painterResource(shoe.imageRes), contentDescription = null)
                    Text(shoe.name, style = MaterialTheme.typography.bodyLarge)
                    Text("₽${shoe.price}", style = MaterialTheme.typography.bodyMedium)
                    IconButton(onClick = { /* handle click */ }) {
                        Icon(Icons.Default.Add, contentDescription = null)
                    }
                }
            }
        }
    }
}