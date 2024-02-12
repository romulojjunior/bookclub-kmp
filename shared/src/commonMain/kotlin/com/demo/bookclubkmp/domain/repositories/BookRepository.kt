package com.demo.bookclubkmp.domain.repositories

import com.demo.bookclubkmp.data.responses.SearchBookResponse
import com.demo.bookclubkmp.domain.entities.Book
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

interface IBookRepository {
    suspend fun searchByName(name: String): List<Book>
}
class BookRepository : IBookRepository {
    private val apiHost = "https://www.googleapis.com/books"
    private var enableMock = false

    override
    suspend fun searchByName(name: String): List<Book> {
        if (enableMock) {
            return mockSearchResult(mutableListOf())
        }

        val client = HttpClient()
        val response = client.get("$apiHost/v1/volumes?q=$name")

        // TODO: cache result
        if (response.status.value == 429) {
            return mockSearchResult(mutableListOf())
        }

        val responseBody = response.bodyAsText()
        val jsonParser = Json { ignoreUnknownKeys = true }
        val books = jsonParser.decodeFromString<SearchBookResponse>(responseBody).items.map {
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
    }

    private fun mockSearchResult(books: MutableList<Book>): MutableList<Book> {
        books.add(
            Book(
                id = "mock-id2345",
                title = "Mocked title",
                description = "Uma Leitura Fácil e Informativa para Virar o Jogo Contra a Indústria de Hospedagem de Tempo Compatilhado Essa indústria de hospedagem vem se aproveit",
                authors = listOf("Travel Hackerz" ),
                ratingsCount = 123,
                pageCount = 1234,
                averageRating = 4.5,
                smallThumbnail = "http://books.google.com/books/content?id=iA6bDgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                thumbnail = "http://books.google.com/books/content?id=iA6bDgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                large = "http://books.google.com/books/content?id=iA6bDgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                country = "BR",
                amount = 120.0,
                currencyCode = "BRL",
            )
        )

        books.add(
            Book(
                id = "mock-id2345",
                title = "Mocked title",
                description = "Uma Leitura Fácil e Informativa para Virar o Jogo Contra a Indústria de Hospedagem de Tempo Compatilhado Essa indústria de hospedagem vem se aproveit",
                authors = listOf("Travel Hackerz" ),
                ratingsCount = 123,
                pageCount = 1234,
                averageRating = 4.5,
                smallThumbnail = "http://books.google.com/books/content?id=iA6bDgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                thumbnail = "http://books.google.com/books/content?id=iA6bDgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                large = "http://books.google.com/books/content?id=iA6bDgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                country = "BR",
                amount = 120.0,
                currencyCode = "BRL",
            )
        )

        books.add(
            Book(
                id = "mock-id2345",
                title = "Mocked title",
                description = "Uma Leitura Fácil e Informativa para Virar o Jogo Contra a Indústria de Hospedagem de Tempo Compatilhado Essa indústria de hospedagem vem se aproveit",
                authors = listOf("Travel Hackerz" ),
                ratingsCount = 123,
                pageCount = 1234,
                averageRating = 4.5,
                smallThumbnail = "http://books.google.com/books/content?id=iA6bDgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                thumbnail = "http://books.google.com/books/content?id=iA6bDgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                large = "http://books.google.com/books/content?id=iA6bDgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api",
                country = "BR",
                amount = 120.0,
                currencyCode = "BRL",
            )
        )

        return books
    }
}