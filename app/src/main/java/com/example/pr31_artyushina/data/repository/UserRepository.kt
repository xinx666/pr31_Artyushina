package com.example.pr31_artyushina.data.repository

import com.example.pr31_artyushina.data.database.UserDao
import com.example.pr31_artyushina.data.model.User

class UserRepository(private val userDao: UserDao) {
    suspend fun login(email: String, password: String): User? {
        return userDao.login(email, password)
    }

    suspend fun insertUsers(users: List<User>) {
        userDao.insertAll(users)
    }
}