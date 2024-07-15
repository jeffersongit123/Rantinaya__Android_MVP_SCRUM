package com.rantinaya.logout.presenter

import android.content.Context
import com.rantinaya.logout.data.LogoutService
import com.rantinaya.logout.data.LogoutServiceInterface
import com.rantinaya.logout.LogoutContract

class LogoutPresenter (var logoutContract: LogoutContract?, val service: LogoutService){

    fun logout(context : Context) {
        service.logout(context , object : LogoutServiceInterface.LogoutCallback {
            override fun logoutSuccess() {
                logoutContract?.showMessage("Cierre de sesión exitoso")
                logoutContract?.logout()
            }
        })
    }

    fun onDestroy() {
        logoutContract = null
    }
}