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

    override
    fun searchBookByName(name: String) {
        _uiState.value = _uiState.value.copy(isLoading = true, exception = null)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val books = searchBookByNameUC.execute(name)
                _uiState.value = _uiState.value.copy(searchResultBooks = books, isLoading = false)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(exception = e, isLoading = false)
            }
        }
    }

    override fun loadFeatureBooks(name: String) {
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