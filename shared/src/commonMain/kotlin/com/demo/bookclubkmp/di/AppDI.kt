package com.demo.bookclubkmp.di

import com.demo.bookclubkmp.domain.repositories.AuthRepository
import com.demo.bookclubkmp.domain.repositories.BookRepository
import com.demo.bookclubkmp.domain.repositories.IAuthRepository
import com.demo.bookclubkmp.domain.repositories.IBookRepository
import com.demo.bookclubkmp.domain.usecases.auth.ISignInUC
import com.demo.bookclubkmp.domain.usecases.auth.SignInUC
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.dsl.module

val repositoryModules = module {
    single<IBookRepository> { BookRepository() }
    single<IAuthRepository> { AuthRepository() }
}

val usecaseModules = module {
    single<ISignInUC> { SignInUC(authRepository = get()) }
}

object AppDIKoin : KoinComponent {
    init {
        startKoin {
            modules(repositoryModules, usecaseModules)
        }
    }

    // For ios injection
    val bookRepository: IBookRepository by inject()
    val signInUC: ISignInUC by inject()
}
