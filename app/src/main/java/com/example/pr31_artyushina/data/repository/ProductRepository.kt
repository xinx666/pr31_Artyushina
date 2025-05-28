package com.example.pr31_artyushina.data.repository

import com.example.pr31_artyushina.data.database.ProductDao

class ProductRepository(private val dao: ProductDao) {
    suspend fun getAll() = dao.getAll()
    suspend fun search(query: String) = dao.searchProducts(query)
}