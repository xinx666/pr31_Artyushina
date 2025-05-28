package com.example.pr31_artyushina.data.database

import androidx.room.Dao
import androidx.room.Query
import com.example.pr31_artyushina.data.model.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM product WHERE name LIKE '%' || :query || '%'")
    suspend fun searchProducts(query: String): List<Product>
    @Query("SELECT * FROM product")
    suspend fun getAll(): List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(products: List<Product>)
}