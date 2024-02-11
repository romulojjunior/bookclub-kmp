package com.demo.bookclubkmp.android.ui.screens.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.bookclubkmp.domain.entities.Session
import com.demo.bookclubkmp.domain.usecases.auth.ISignInUC
import com.demo.bookclubkmp.ui.viewmodels.IAuthViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthViewModel (private val signInUC: ISignInUC) : ViewModel(), IAuthViewModel {
    data class UIState(
        val session: Session? = null,
        val exception: Any? = null,
        val isLoading: Boolean = false
    )

    private val _uiState = mutableStateOf(UIState())
    val uiState = _uiState

    override
    fun signIn(username: String, password: String) {
        _uiState.value = _uiState.value.copy(isLoading = true, exception = null)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val session = signInUC.execute(username, password)
                _uiState.value = _uiState.value.copy(session = session, isLoading = false)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(exception = e, isLoading = false)
            }
        }
    }
}