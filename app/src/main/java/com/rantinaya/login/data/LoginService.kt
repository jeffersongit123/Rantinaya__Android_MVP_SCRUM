package com.rantinaya.login.data

import com.rantinaya.api.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface LoginServiceInterface {
    interface LoginCallback {
        fun onSuccess(response : LoginResponse)
        fun onFailure(message: String)
    }

    suspend fun login(email: String, password: String, callback: LoginCallback)
}

class LoginService : LoginServiceInterface {
    override suspend fun login(email: String, password: String, callback: LoginServiceInterface.LoginCallback) {
        try {
            val response = RetrofitClient.apiService.login(
                LoginRequest(
                    email,
                    password
                )
            )
            withContext(Dispatchers.Main) {
                callback.onSuccess(response)
            }
        }catch ( e : Exception) {
            withContext(Dispatchers.Main) {
                callback.onFailure(e.message ?: "Error desconocido")
            }
        }
    }
}
