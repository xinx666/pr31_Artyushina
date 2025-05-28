package com.example.pr31_artyushina.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pr31_artyushina.data.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    suspend fun getAll(): List<User>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg users: User)
}