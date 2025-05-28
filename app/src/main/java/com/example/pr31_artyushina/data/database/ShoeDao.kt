package com.example.pr31_artyushina.data.database

mport androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pr31_artyushina.data.model.Shoe

@Dao
interface ShoeDao {
    @Query("SELECT * FROM Shoe")
    suspend fun getAll(): List<Shoe>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg shoes: Shoe)
}