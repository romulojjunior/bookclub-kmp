package com.demo.bookclubkmp.domain.repositories

import com.demo.bookclubkmp.data.samples.getFriendsSamples
import com.demo.bookclubkmp.domain.entities.Friend

interface IFriendRepository {
    suspend fun getFriends(userId: String): List<Friend>
}

class FriendRepository : IFriendRepository{
    override suspend fun getFriends(userId: String): List<Friend> {
        return getFriendsSamples()
    }
}
