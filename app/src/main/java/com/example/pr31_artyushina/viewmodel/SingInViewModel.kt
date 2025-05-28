package com.example.pr31_artyushina.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr31_artyushina.data.model.User
import com.example.pr31_artyushina.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignInViewModel(private val repo: UserRepository) : ViewModel() {
    private val _loginSuccess = MutableStateFlow(false)
    val loginSuccess = _loginSuccess.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val user = repo.login(email, password)
            _loginSuccess.value = user != null
        }
    }
}