package com.demo.bookclubkmp.di

import com.demo.bookclubkmp.domain.repositories.BookRepository
import com.demo.bookclubkmp.domain.repositories.IBookRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    single<IBookRepository> {
        BookRepository()
    }
}


object AppDIKoin : KoinComponent {
    init {
        startKoin {
            modules(appModule)
        }
    }

    val bookRepository: IBookRepository by inject()
}
