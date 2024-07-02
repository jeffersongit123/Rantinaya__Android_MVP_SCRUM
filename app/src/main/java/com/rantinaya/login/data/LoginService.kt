package com.rantinaya.login.data

import android.content.Context
import android.content.SharedPreferences
import com.rantinaya.api.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface LoginServiceInterface {
    interface LoginCallback {
        fun onSuccess(response : LoginResponse)
        fun onFailure(message: String)
    }

    interface CheckLoginCallback {
        fun isLogged()
    }
    suspend fun login(email: String, password: String,  context : Context, callback: LoginCallback)
    fun checkLogin(context: Context,callback : CheckLoginCallback)
}

class LoginService : LoginServiceInterface {
    override suspend fun login(email: String, password: String, context : Context, callback: LoginServiceInterface.LoginCallback) {
        try {
            val sharedPreferences = context.getSharedPreferences("task",0)
            val editor : SharedPreferences.Editor = sharedPreferences.edit()

            val response = RetrofitClient.apiService.login(
                LoginRequest(
                    email,
                    password
                )
            )
            withContext(Dispatchers.Main) {
                editor.putBoolean("isLogged",true)
                editor.apply()
                editor.commit()
                callback.onSuccess(response)
            }
        }catch ( e : Exception) {
            withContext(Dispatchers.Main) {
                callback.onFailure(e.message ?: "Error desconocido")
            }
        }
    }

    override fun checkLogin(context: Context,callback: LoginServiceInterface.CheckLoginCallback) {
        val sharedPreferences = context.getSharedPreferences("task",0)
        val editor : SharedPreferences.Editor = sharedPreferences.edit()

        val isLogged = sharedPreferences.getBoolean("isLogged",false) ?: false
        if(isLogged) {
            callback.isLogged()
        }
    }
}
