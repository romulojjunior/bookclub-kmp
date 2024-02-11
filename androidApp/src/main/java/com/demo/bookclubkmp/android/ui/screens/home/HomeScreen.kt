package com.demo.bookclubkmp.android.ui.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.demo.bookclubkmp.android.MyApplicationTheme
import com.demo.bookclubkmp.android.ui.screens.home.components.HomeNavigationBar
import com.demo.bookclubkmp.android.ui.screens.home.tabs.MainTab
import com.demo.bookclubkmp.android.ui.screens.home.tabs.SearchTab

@Composable
fun HomeScreen(
    uiState: MutableState<HomeViewModel.UIState> = mutableStateOf(HomeViewModel.UIState()),
    searchUIState: MutableState<HomeViewModel.SearchUIState> = mutableStateOf(HomeViewModel.SearchUIState()),
    loadFeatureBooks: (name: String) -> Unit = {},
    loadRecommendedBooks: (name: String) -> Unit = {},
    loadFavoritesBooks: (name: String) -> Unit = {},
    searchBookByName: (name: String) -> Unit = {}) {

    var tabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold(
        bottomBar = {
            HomeNavigationBar(
                tabIndex = tabIndex,
                onTabSelected = { index -> tabIndex = index }
            )
        }
    ) { scaffoldPadding ->

            when (tabIndex) {
                0 -> {
                    Surface(modifier = Modifier.padding(paddingValues = scaffoldPadding)) {
                        MainTab(
                            uiState = uiState,
                            loadFeatureBooks = loadFeatureBooks,
                            loadRecommendedBooks = loadRecommendedBooks,
                            loadFavoritesBooks = loadFavoritesBooks,
                        )
                    }
                }
                1 -> {
                    Surface(modifier = Modifier.padding(paddingValues = scaffoldPadding)) {
                        SearchTab(
                            uiState = searchUIState,
                            searchBookByName = searchBookByName
                        )
                    }
                }
                else -> {
                    Surface(modifier = Modifier.padding(paddingValues = scaffoldPadding)) {
                        Text("No Tab")
                    }
                }
            }

    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MyApplicationTheme {
        HomeScreen()
    }
}
@Composable
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun HomeScreenPreviewNight() {
    MyApplicationTheme {
        HomeScreen()
    }
}