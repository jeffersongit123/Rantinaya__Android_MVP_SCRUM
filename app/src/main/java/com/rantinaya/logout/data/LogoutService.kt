package com.rantinaya.logout.data

import android.content.Context
import android.content.SharedPreferences

interface LogoutServiceInterface {
    interface LogoutCallback {
        fun logoutSuccess()
    }

    fun logout(context : Context , callback : LogoutCallback)
}
class LogoutService : LogoutServiceInterface {
    override fun logout(context : Context, callback : LogoutServiceInterface.LogoutCallback) {
        val sharedPreferences = context.getSharedPreferences("task",0)
        val editor : SharedPreferences.Editor = sharedPreferences.edit()

        editor.putBoolean("isLogged",false)
        editor.apply()
        editor.commit()
        callback.logoutSuccess()
    }
}