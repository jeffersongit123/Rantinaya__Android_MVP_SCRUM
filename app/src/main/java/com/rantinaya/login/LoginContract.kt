package com.rantinaya.login

interface LoginContract {
    fun navigateToSingUp()
    fun showProgress()
    fun hideProgress()
    fun setEmailError(message: String)
    fun setPasswordError(message: String)
    fun navigateToHome()
    fun showError(message: String)
    fun showMessage(message: String)
}