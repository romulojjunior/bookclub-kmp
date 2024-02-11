package com.demo.bookclubkmp.android.ui.screens.home.tabs

import com.demo.bookclubkmp.android.ui.screens.home.HomeViewModel
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.demo.bookclubkmp.android.MyApplicationTheme
import com.demo.bookclubkmp.android.ui.components.UIBookCard
import com.demo.bookclubkmp.android.ui.components.UIError
import com.demo.bookclubkmp.android.ui.components.UILoading
import com.demo.bookclubkmp.android.ui.components.UIPageHeader
import com.demo.bookclubkmp.domain.entities.Book
import java.net.UnknownHostException

@Composable
fun MainTab(
    uiState: MutableState<HomeViewModel.UIState> = mutableStateOf(HomeViewModel.UIState()),
    loadFeatureBooks: (name: String) -> Unit = {},
    loadRecommendedBooks: (name: String) -> Unit = {},
    loadFavoritesBooks: (name: String) -> Unit = {}) {

    LaunchedEffect(Unit) {
        loadFeatureBooks("Travel")
        loadRecommendedBooks("Kotlin")
        loadFavoritesBooks("Android")
    }

    if (uiState.value.exception is UnknownHostException) {
        UIError(
            onRetry = {
                loadFeatureBooks("Travel")
                loadRecommendedBooks("Kotlin")
                loadFavoritesBooks("Android")
            }
        )
        return
    }

    if (uiState.value.isLoading) {
        UILoading()
        return
    }

    Surface {
        LazyColumn(Modifier.fillMaxSize(), content = {
            item {
                Column {
                    UIPageHeader(text = "Favorites")
                    LazyRow {
                        items(uiState.value.favoritesBooks.size) { index ->
                            val book: Book = uiState.value.favoritesBooks[index]
                            UIBookCard(title = book.title, imageUrl = book.thumbnail)
                        }
                    }
                }
            }

            item {
                Column {
                    UIPageHeader(text = "Featured")
                    LazyRow {
                        items(uiState.value.featuredBooks.size) { index ->
                            val book: Book = uiState.value.featuredBooks[index]
                            UIBookCard(title = book.title, imageUrl = book.thumbnail)
                        }
                    }
                }
            }

            item {
                Column {
                    UIPageHeader(text = "Recommended")
                    LazyRow {
                        items(uiState.value.recommendedBooks.size) { index ->
                            val book: Book = uiState.value.recommendedBooks[index]
                            UIBookCard(title = book.title, imageUrl = book.thumbnail)
                        }
                    }
                }
            }
        })
    }
}

@Preview
@Composable
fun MainTabPreview() {
    MyApplicationTheme {
        MainTab()
    }
}
@Composable
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun MainTabPreviewNight() {
    MyApplicationTheme {
        MainTab()
    }
}