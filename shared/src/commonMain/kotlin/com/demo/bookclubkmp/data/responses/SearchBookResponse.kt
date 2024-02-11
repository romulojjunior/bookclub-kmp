package com.demo.bookclubkmp.data.responses

import kotlinx.serialization.Serializable


@Serializable
data class SearchBookResponse(val items: List<SearchItem> = emptyList(), val totalItems: Int = 0)

@Serializable
data class SearchItem(val id: String, val volumeInfo: VolumeInfo, val saleInfo: SaleInfo)

@Serializable
data class VolumeInfo(
    val title: String,
    val description: String? = null,
    val authors: List<String> = emptyList(),
    val ratingsCount: Int = 0,
    val pageCount: Int = 0,
    val averageRating: Double = 0.0,
    val imageLinks: ImageLinks? = null
)

@Serializable
data class ImageLinks(val smallThumbnail: String? = null, val thumbnail: String? = null, val large: String? = null)

@Serializable
data class SaleInfo(val country: String? = null, val listPrice: ListPrice? = null)

@Serializable
data class ListPrice(val amount: Double? = 0.0, val currencyCode: String? = null)
