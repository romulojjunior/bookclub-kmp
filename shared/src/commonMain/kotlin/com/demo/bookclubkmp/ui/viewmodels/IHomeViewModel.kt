package com.demo.bookclubkmp.ui.viewmodels

interface IHomeViewModel {
    fun searchBookByName(name: String)

    fun loadFeatureBooks(name: String)

    fun loadRecommendedBooks(name: String)

    fun loadFavoritesBooks(name: String)
}