package com.example.pr31_artyushina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pr31_artyushina.ui.theme.Pr31_ArtyushinaTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val shoeDao = db.shoeDao()
        CoroutineScope(Dispatchers.IO).launch {
            shoeDao.insertAll(
                Shoe(
                    name = "Nike Air Max",
                    price = 752.0,
                    isBestSeller = true,
                    imageRes = R.drawable.shoe1
                ),
                Shoe(name = "Nike Zoom", price = 799.0, imageRes = R.drawable.shoe2),
                Shoe(name = "Nike Air Jordan", price = 899.0, imageRes = R.drawable.shoe3)
            )
        }
        setContent {
            Pr31_ArtyushinaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pr31_ArtyushinaTheme {
        Greeting("Android")
    }
}