package com.rantinaya.logout

interface LogoutContract {
    fun logout()
    fun showMessage(message : String)
    fun onDestroy()
}