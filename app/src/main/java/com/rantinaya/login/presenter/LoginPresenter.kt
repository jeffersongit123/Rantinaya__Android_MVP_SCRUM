package com.rantinaya.login.presenter

import android.content.Context
import com.rantinaya.login.data.LoginService
import com.rantinaya.login.data.LoginServiceInterface
import com.rantinaya.login.LoginContract
import com.rantinaya.login.data.LoginResponse
import com.rantinaya.utils.isValidEmail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginPresenter (var loginView: LoginContract?, private val loginService: LoginService){

    fun checkLogged(context: Context) {
        loginService.checkLogin(context,object : LoginServiceInterface.CheckLoginCallback {
            override fun isLogged() {
                loginView?.isLogged()
            }
        })
    }

    fun validateCredentials(email: String, password: String, context: Context) {
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
            loginService.login(email, password, context,object : LoginServiceInterface.LoginCallback {
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