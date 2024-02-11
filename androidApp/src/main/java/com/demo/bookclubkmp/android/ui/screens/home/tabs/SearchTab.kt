package com.demo.bookclubkmp.android.ui.screens.home.tabs

import com.demo.bookclubkmp.android.ui.screens.home.HomeViewModel
import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.bookclubkmp.android.MyApplicationTheme
import com.demo.bookclubkmp.android.R
import com.demo.bookclubkmp.android.ui.components.UIBookCard
import com.demo.bookclubkmp.android.ui.components.UIError
import com.demo.bookclubkmp.android.ui.components.UILoading
import com.demo.bookclubkmp.android.ui.components.UIPageHeader
import com.demo.bookclubkmp.domain.entities.Book
import java.net.UnknownHostException

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchTab(
    uiState: MutableState<HomeViewModel.SearchUIState> = mutableStateOf(HomeViewModel.SearchUIState()),
    searchBookByName: (name: String) -> Unit = {}) {

    var searchQuery by rememberSaveable {
        mutableStateOf("")
    }

    LaunchedEffect(Unit) {
        searchBookByName(searchQuery)
    }

    if (uiState.value.exception is UnknownHostException) {
        UIError(
            onRetry = {
                searchBookByName(searchQuery)
            }
        )
        return
    }

    Surface {
        LazyColumn(Modifier.fillMaxSize(), content = {

            stickyHeader {
                Surface {
                    Column {
                        UIPageHeader(text = stringResource(id = R.string.search))
                        OutlinedTextField(
                            value = searchQuery,
                            onValueChange = { searchQuery = it },
                            placeholder = { Text(text = stringResource(id = R.string.search)) },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                            keyboardActions = KeyboardActions(
                                onSearch = {
                                    searchBookByName(searchQuery)
                                }
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp))
                    }
                }
            }

            if (uiState.value.isLoading) {
                item {
                    UILoading()
                }
            }

            if (uiState.value.searchResultBooks.isNotEmpty()) {
                item {
                    Text(text = "Result for $searchQuery", modifier = Modifier.padding(16.dp))
                }
            }

            items(uiState.value.searchResultBooks.size) { index ->
                val book: Book = uiState.value.searchResultBooks[index]
               Row(modifier = Modifier.padding(16.dp)) {
                   UIBookCard(title = book.title, imageUrl = book.thumbnail)
                   book.description?.let {description ->
                       Text(text = description, maxLines = 10, modifier = Modifier.padding(8.dp))
                   }
               }
            }
        })
    }
}

@Preview
@Composable
fun SearchTabPreview() {
    MyApplicationTheme {
        SearchTab()
    }
}
@Composable
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
fun SearchTabPreviewNight() {
    MyApplicationTheme {
        SearchTab()
    }
}