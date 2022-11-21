package com.example.roomdbex.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdbex.Entity.User

@Dao
interface Daoclass
{
        @Insert
        fun addUser(user: User?)

        @Query("select * from users")
        fun getUsers(): MutableList<User>

}