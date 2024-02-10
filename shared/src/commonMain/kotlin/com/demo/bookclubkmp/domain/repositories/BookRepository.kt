package com.demo.bookclubkmp.domain.repositories

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

interface IBookRepository {
    suspend fun searchByName(name: String): String
}
class BookRepository(): IBookRepository {
    private val apiHost = "https://www.googleapis.com/books"
    override
    suspend fun searchByName(name: String): String {
        val client = HttpClient()
        val response = client.get("$apiHost/v1/volumes?q=$name")
        return response.bodyAsText()
    }
}