package com.demo.bookclubkmp.android.di

import com.demo.bookclubkmp.android.ui.screens.auth.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<AuthViewModel> {
        AuthViewModel(signInUC = get())
    }
}