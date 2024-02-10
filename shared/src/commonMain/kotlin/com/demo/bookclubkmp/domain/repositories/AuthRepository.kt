package com.demo.bookclubkmp.domain.repositories

import com.demo.bookclubkmp.domain.entities.Session

interface IAuthRepository {
    suspend fun signIn() : Session
}
class AuthRepository : IAuthRepository {
    override suspend fun signIn(): Session {
        return Session.mocked()
    }
}