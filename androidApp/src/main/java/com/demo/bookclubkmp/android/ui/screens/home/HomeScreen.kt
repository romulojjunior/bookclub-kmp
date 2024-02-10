package com.demo.bookclubkmp.android.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.demo.bookclubkmp.di.AppDIKoin
import com.demo.bookclubkmp.domain.repositories.IBookRepository
import kotlinx.coroutines.launch
import org.koin.core.component.get

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