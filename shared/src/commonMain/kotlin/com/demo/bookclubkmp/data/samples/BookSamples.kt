package com.demo.bookclubkmp.data.samples

import com.demo.bookclubkmp.domain.entities.Book

fun getBookSamples(): MutableList<Book> {
    val books = mutableListOf<Book>()
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