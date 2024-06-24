package com.rantinaya.signup

interface SignUpContract {
    fun showProgress()
    fun hideProgress()
    fun setFirstNameError()
    fun setLastNameError()
    fun setUsernameError()
    fun setPasswordError()
    fun setConfirmPasswordError()
    fun passwordsDoNotMatchError()
    fun setEmailError()
    fun navigateToHome()
    fun showMessage(message: String)
    fun showError(message: String)
}