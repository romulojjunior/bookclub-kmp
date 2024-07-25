package com.demo.bookclubkmp.di

import com.demo.bookclubkmp.data.apis.BookApi
import com.demo.bookclubkmp.data.apis.IBookApi
import com.demo.bookclubkmp.domain.repositories.AuthRepository
import com.demo.bookclubkmp.domain.repositories.BookRepository
import com.demo.bookclubkmp.domain.repositories.FriendRepository
import com.demo.bookclubkmp.domain.repositories.IAuthRepository
import com.demo.bookclubkmp.domain.repositories.IBookRepository
import com.demo.bookclubkmp.domain.repositories.IFriendRepository
import com.demo.bookclubkmp.domain.usecases.auth.ISignInUC
import com.demo.bookclubkmp.domain.usecases.auth.SignInUC
import com.demo.bookclubkmp.domain.usecases.book.ISearchBookByNameUC
import com.demo.bookclubkmp.domain.usecases.book.SearchBookByNameUC
import com.demo.bookclubkmp.domain.usecases.friend.GetFriendsByUserIdUC
import com.demo.bookclubkmp.domain.usecases.friend.IGetFriendsByUserIdUC
import io.ktor.client.HttpClient
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.dsl.module

val apisModules = module {
    single<HttpClient> { HttpClient() }
    single<IBookApi>{ BookApi(get()) }
}

val repositoryModules = module {
    single<IBookRepository> { BookRepository(get()) }
    single<IAuthRepository> { AuthRepository() }
    single<IFriendRepository> { FriendRepository() }
}

val usecaseModules = module {
    // Auth
    single<ISignInUC> { SignInUC(authRepository = get()) }

    // Books
    single<ISearchBookByNameUC> { SearchBookByNameUC(bookRepository = get())  }

    // Friend
    single<IGetFriendsByUserIdUC> { GetFriendsByUserIdUC(friendRepository = get()) }
}

object AppDIKoin : KoinComponent {
    init {
        startKoin {
            modules(apisModules, repositoryModules, usecaseModules)
        }
    }

    // For ios injection
    val signInUC: ISignInUC by inject()
    val searchBookByNameUC: ISearchBookByNameUC by inject()
    val getFriendsByUserIdUC: IGetFriendsByUserIdUC by inject()
}
