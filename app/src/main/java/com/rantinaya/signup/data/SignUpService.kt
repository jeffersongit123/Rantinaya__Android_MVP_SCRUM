package com.rantinaya.signup.data

import com.rantinaya.api.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface SignUpServiceInterface {
    interface SignUpCallback {
        fun onSuccess(response : SignUpResponse)
        fun onFailure(message: String)
    }

    suspend fun signUp(firstName: String, lastName: String, username: String, password: String,email: String, callback: SignUpCallback)
}

class SignUpService : SignUpServiceInterface {
    override suspend fun signUp(firstName: String, lastName: String, username: String, password: String,email : String, callback: SignUpServiceInterface.SignUpCallback) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.apiService.singUp(
                    SignUpRequest(
                        name = lastName+" "+firstName,
                        email = email,
                        username = username,
                        role_id = 1,
                        password = password
                    )
                )
                withContext(Dispatchers.Main) {
                    callback.onSuccess(response)
                }
            }catch (e : Exception) {
                withContext(Dispatchers.Main) {
                    callback.onFailure(e.message ?: "Error desconocido")
                }
            }
        }
    }
}