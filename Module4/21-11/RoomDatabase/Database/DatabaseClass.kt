package com.example.roomdbex.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdbex.Dao.Daoclass
import com.example.roomdbex.Entity.User

@Database(entities = [User::class], version = 1)
abstract class DatabaseClass : RoomDatabase()
{
    abstract fun daoClass(): Daoclass
}