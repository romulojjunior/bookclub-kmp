package com.demo.bookclubkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform