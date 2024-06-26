package com.rantinaya.login.presenter

import com.rantinaya.login.data.LoginService
import com.rantinaya.login.data.LoginServiceInterface
import com.rantinaya.login.LoginContract
import com.rantinaya.login.data.LoginResponse
import com.rantinaya.utils.isValidEmail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginPresenter (var loginView: LoginContract?, private val loginService: LoginService){
    fun validateCredentials(email: String, password: String) {
        if (email.isEmpty()) {
            loginView?.setEmailError("Email es requerido")
            return
        }

        if(!isValidEmail(email)) {
            loginView?.setEmailError("Ingrese un email valido")
            return
        }

        if (password.isEmpty()) {
            loginView?.setPasswordError("Password es requerido")
            return
        }

        loginView?.showProgress()
        CoroutineScope(Dispatchers.IO).launch {
            loginService.login(email, password, object : LoginServiceInterface.LoginCallback {
                override fun onSuccess(response: LoginResponse) {
                    loginView?.hideProgress()
                    loginView?.showMessage(response.message)
                    loginView?.navigateToHome()
                }

                override fun onFailure(message: String) {
                    loginView?.hideProgress()
                    loginView?.showError(message)
                }

            })
        }
    }

    fun navigateToSignUp() {
        loginView?.navigateToSingUp()
    }

    fun onDestroy() {
        loginView = null
    }
}