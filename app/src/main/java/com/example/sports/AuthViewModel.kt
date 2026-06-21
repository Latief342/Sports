package com.example.sports

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sports.network.AuthApiService
import com.example.sports.network.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authApiService: AuthApiService
) : ViewModel() {

    private val _loginSuccess = MutableStateFlow(false)
    val loginSuccess: StateFlow<Boolean> = _loginSuccess

    private val _message = MutableStateFlow("")
    val message: StateFlow<String> = _message

    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser

    fun login(
        username: String,
        password: String
    ) {
        viewModelScope.launch {

            try {

                val users = authApiService.getUsers()

                val user = users.find {
                    it.username == username &&
                            it.password == password
                }

                if (user != null) {

                    _currentUser.value = user

                    _loginSuccess.value = true

                    _message.value =
                        "Login berhasil. Selamat datang ${user.fullName}"

                } else {

                    _message.value =
                        "Username atau Password salah"
                }

            } catch (e: Exception) {

                _message.value =
                    "Gagal terhubung ke server"

                e.printStackTrace()
            }
        }
    }

    fun register(
        fullName: String,
        username: String,
        password: String
    ) {

        viewModelScope.launch {

            try {

                val users =
                    authApiService.getUsers()

                val usernameSudahAda =
                    users.any {
                        it.username.equals(
                            username,
                            ignoreCase = true
                        )
                    }

                if (usernameSudahAda) {

                    _message.value =
                        "Username sudah digunakan"

                    return@launch
                }

                val newUser = User(
                    fullName = fullName,
                    username = username,
                    password = password
                )

                authApiService.registerUser(
                    newUser
                )

                _message.value =
                    "Registrasi berhasil"

            } catch (e: Exception) {

                _message.value =
                    "Registrasi gagal"

                e.printStackTrace()
            }
        }
    }

    fun logout() {

        _currentUser.value = null

        _loginSuccess.value = false

        _message.value = ""
    }

    fun resetMessage() {
        _message.value = ""
    }
}