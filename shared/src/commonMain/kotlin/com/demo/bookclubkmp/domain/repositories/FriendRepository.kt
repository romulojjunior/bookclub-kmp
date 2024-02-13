package com.demo.bookclubkmp.domain.repositories

import com.demo.bookclubkmp.domain.entities.Friend

interface IFriendRepository {
    suspend fun getFriends(userId: String): List<Friend>
}

class FriendRepository : IFriendRepository{
    override suspend fun getFriends(userId: String): List<Friend> {
        return listOf(
            Friend(
                id = "123dwcedv",
                name = "Ana",
                avatarURL = "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8cGVyc29ufGVufDB8fDB8fA%3D%3D&w=1000&q=80"
            ),
            Friend(
                id = "34e3ee3rrbvfecd",
                name = "Jenny",
                avatarURL = "https://thumbs.dreamstime.com/b/surprised-female-person-confused-isolated-surprised-female-person-confused-isolated-168304856.jpg"
            ),
            Friend(
                id = "324ewfeferf",
                name = "Allay",
                avatarURL = "https://engineering.unl.edu/images/staff/Kayla-Person.jpg"
            ),
            Friend(
                id = "5543eeef",
                name = "Bia",
                avatarURL = "https://media.glamourmagazine.co.uk/photos/623b3612980be8aafb01a665/3:4/w_1440,h_1920,c_limit/The%20Worst%20Person%20In%20The%20World%20230322GettyImages-1385537039_SQ.jpg"
            )
        )
    }

}