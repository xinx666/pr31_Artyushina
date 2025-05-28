package com.example.pr31_artyushina.data.model

import androidx.room.PrimaryKey

data class Shoe(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val price: Double,
    val isBestSeller: Boolean = false,
    val imageRes: Int
)