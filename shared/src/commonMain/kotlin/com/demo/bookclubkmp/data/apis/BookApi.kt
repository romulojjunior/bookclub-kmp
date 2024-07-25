package com.demo.bookclubkmp.data.apis

import com.demo.bookclubkmp.data.responses.SearchBookResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

interface IBookApi {
    suspend fun searchBook(name: String) : SearchBookResponse
}

class BookApi(private val httpClient: HttpClient): IBookApi {
    private val apiHost = "https://www.googleapis.com/books"

    override suspend fun searchBook(name: String): SearchBookResponse {
        val response = httpClient.get("$apiHost/v1/volumes?q=$name")

         if (response.status.value == 429) {
             // TODO: cache result
             return SearchBookResponse()
         }

         if (response.status.value == 500) {
             throw InternalException()
         }

         if (response.status.value == 404) {
             throw NotFoundException()
         }

        val responseBody = response.bodyAsText()
        val jsonParser = Json { ignoreUnknownKeys = true }
        return jsonParser.decodeFromString<SearchBookResponse>(responseBody)
    }
}
