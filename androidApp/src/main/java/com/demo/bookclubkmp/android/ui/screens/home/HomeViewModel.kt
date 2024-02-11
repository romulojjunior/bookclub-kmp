package com.demo.bookclubkmp.android.ui.screens.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.bookclubkmp.domain.entities.Book
import com.demo.bookclubkmp.domain.usecases.book.ISearchBookByNameUC
import com.demo.bookclubkmp.ui.viewmodels.IHomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel (private val searchBookByNameUC: ISearchBookByNameUC) : ViewModel(),
    IHomeViewModel {
    data class UIState(
        val featuredBooks: List<Book> = emptyList(),
        val recommendedBooks: List<Book> = emptyList(),
        val favoritesBooks: List<Book> = emptyList(),
        val searchResultBooks: List<Book> = emptyList(),
        val exception: Any? = null,
        val isLoading: Boolean = false
    )

    private val _uiState = mutableStateOf(UIState())
    val uiState = _uiState


    data class SearchUIState(
        val searchResultBooks: List<Book> = emptyList(),
        val exception: Any? = null,
        val isLoading: Boolean = false
    )

    private val _searchUIState = mutableStateOf(SearchUIState())
    val searchUIState = _searchUIState

    override
    fun searchBookByName(name: String) {
        _searchUIState.value = _searchUIState.value.copy(isLoading = true,searchResultBooks = emptyList(), exception = null)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val books = searchBookByNameUC.execute(name)
                _searchUIState.value = _searchUIState.value.copy(searchResultBooks = books, isLoading = false)
            } catch (e: Exception) {
                _searchUIState.value = _searchUIState.value.copy(exception = e, isLoading = false)
            }
        }
    }

    override fun loadFeatureBooks(name: String) {
        if (_uiState.value.featuredBooks.isNotEmpty()) {
            return
        }

        _uiState.value = _uiState.value.copy(isLoading = true, exception = null)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val books = searchBookByNameUC.execute(name)
                _uiState.value = _uiState.value.copy(featuredBooks = books, isLoading = false)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(exception = e, isLoading = false)
            }
        }
    }

    override fun loadRecommendedBooks(name: String) {
        if (_uiState.value.recommendedBooks.isNotEmpty()) {
            return
        }

        _uiState.value = _uiState.value.copy(isLoading = true, exception = null)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val books = searchBookByNameUC.execute(name)
                _uiState.value = _uiState.value.copy(recommendedBooks = books, isLoading = false)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(exception = e, isLoading = false)
            }
        }
    }

    override fun loadFavoritesBooks(name: String) {
        if (_uiState.value.featuredBooks.isNotEmpty()) {
            return
        }

        _uiState.value = _uiState.value.copy(isLoading = true, exception = null)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val books = searchBookByNameUC.execute(name)
                _uiState.value = _uiState.value.copy(favoritesBooks = books, isLoading = false)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(exception = e, isLoading = false)
            }
        }
    }
}