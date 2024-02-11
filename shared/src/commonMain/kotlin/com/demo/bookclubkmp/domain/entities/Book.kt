package com.demo.bookclubkmp.domain.entities

class Book(
    var id: String?,
    var title: String,
    // VolumeInfo
    val description: String? = null,
    val authors: List<String> = emptyList(),
    val ratingsCount: Int = 0,
    val pageCount: Int = 0,
    val averageRating: Double = 0.0,
    // ImageLinks
    val smallThumbnail: String? = null,
    val thumbnail: String? = null,
    val large: String? = null,
    // SaleInfo
    val country: String? = null,
    val amount: Double? = 0.0,
    val currencyCode: String? = null
)