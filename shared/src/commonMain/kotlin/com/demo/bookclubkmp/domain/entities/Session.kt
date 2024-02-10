package com.demo.bookclubkmp.domain.entities

class Session(val id: String, val apikey: String) {
    companion object {
        fun mocked() : Session{
            return Session(
                id = "1234",
                apikey = "1234"
            );
        }
    }
}