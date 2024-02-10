package com.demo.bookclubkmp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.demo.bookclubkmp.domain.repositories.IBookRepository
import com.demo.bookclubkmp.di.AppDIKoin
import kotlinx.coroutines.launch
import org.koin.core.component.get

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                HomeScreen()
            }
        }
    }
}


@Composable
fun HomeScreen() {
    val scope = rememberCoroutineScope()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            Text("Android Home")
            Button(onClick = {
                scope.launch {
                    val result = AppDIKoin.get<IBookRepository>().searchByName("Travelling")
                    println(result)
                }
            }) {
                Text("Click me!")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPReview() {
    MaterialTheme {
        HomeScreen()
    }
}