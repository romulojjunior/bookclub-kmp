package com.demo.bookclubkmp.domain.repositories

import com.demo.bookclubkmp.data.apis.IBookApi
import com.demo.bookclubkmp.data.apis.InternalException
import com.demo.bookclubkmp.data.apis.NotFoundException
import com.demo.bookclubkmp.domain.entities.Book

interface IBookRepository {
    suspend fun searchByName(name: String): List<Book>
}

// Exceptions
class BookNotFoundException : Exception()
class BookSearchException : Exception()

// Implementation
class BookRepository(private val bookApi: IBookApi) : IBookRepository {
    override
    suspend fun searchByName(name: String): List<Book> {
        try {
            val books = bookApi.searchBook(name).items.map {
                Book(
                    id = it.id,
                    title = it.volumeInfo.title,
                    description = it.volumeInfo.description,
                    authors = it.volumeInfo.authors,
                    ratingsCount = it.volumeInfo.ratingsCount,
                    pageCount = it.volumeInfo.pageCount,
                    averageRating = it.volumeInfo.averageRating,
                    smallThumbnail = it.volumeInfo.imageLinks?.smallThumbnail,
                    thumbnail =it.volumeInfo.imageLinks?.thumbnail,
                    large = it.volumeInfo.imageLinks?.large,
                    country = it.saleInfo.country,
                    amount = it.saleInfo.listPrice?.amount,
                    currencyCode = it.saleInfo.listPrice?.currencyCode,
                )
            }.toMutableList()

            return books
        } catch (e: InternalException) {
            throw BookSearchException()
        } catch (e: NotFoundException) {
            throw BookNotFoundException()
        }
    }
}
