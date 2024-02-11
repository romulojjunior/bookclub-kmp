package com.demo.bookclubkmp.domain.usecases.book

import com.demo.bookclubkmp.domain.entities.Book
import com.demo.bookclubkmp.domain.repositories.IBookRepository

interface ISearchBookByNameUC {
    @Throws(Throwable::class, InvalidBookNameException::class)
    suspend fun execute(name: String): List<Book>
}
class SearchBookByNameUC(private val bookRepository: IBookRepository) : ISearchBookByNameUC {
    override
    suspend fun execute(name: String): List<Book> {
        if (name.isBlank()) {
            throw InvalidBookNameException()
        }

        return bookRepository.searchByName(name)
    }
}

// Exceptions
class InvalidBookNameException: Exception()