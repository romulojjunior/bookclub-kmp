package com.demo.bookclubkmp.domain.usecases.friend

import com.demo.bookclubkmp.domain.entities.Friend
import com.demo.bookclubkmp.domain.repositories.IFriendRepository

interface IGetFriendsByUserIdUC {
    suspend fun execute(userId: String): List<Friend>
}
class GetFriendsByUserIdUC(
    private val friendRepository: IFriendRepository
) : IGetFriendsByUserIdUC {
    override suspend fun execute(userId: String): List<Friend> {
        return friendRepository.getFriends(userId)
    }
}