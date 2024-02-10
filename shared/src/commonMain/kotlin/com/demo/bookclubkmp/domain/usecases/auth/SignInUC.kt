package com.demo.bookclubkmp.domain.usecases.auth

import com.demo.bookclubkmp.domain.entities.Session
import com.demo.bookclubkmp.domain.repositories.IAuthRepository

interface ISignInUC {
    suspend fun execute(username: String, password: String): Session
}
class SignInUC(private val authRepository: IAuthRepository) : ISignInUC {
    override
    suspend fun execute(username: String, password: String): Session {
        if (username.isBlank()) {
            throw InvalidUsernameException()
        }

        if (password.isBlank() || password.count() < 6) {
            throw InvalidPasswordException()
        }

        return authRepository.signIn()
    }
}

// Sign-in Exceptions
class InvalidUsernameException: Exception()
class InvalidPasswordException: Exception()