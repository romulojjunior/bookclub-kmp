package com.demo.bookclubkmp.ui.viewmodels

// Each platform use a different ViewModel class that should implements this interface.
// Check Android and IOS projects ui package.
interface IAuthViewModel {
    fun signIn(email: String, password: String)
}