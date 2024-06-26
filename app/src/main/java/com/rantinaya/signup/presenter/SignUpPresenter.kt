package com.rantinaya.signup.presenter

import com.rantinaya.signup.data.SignUpService
import com.rantinaya.signup.data.SignUpServiceInterface
import com.rantinaya.signup.SignUpContract
import com.rantinaya.signup.data.SignUpResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class
SignUpPresenter(private var signUpView: SignUpContract?, private val signUpService: SignUpService)  {

    fun validateCredentials(
        firstName: String,
        lastName: String,
        username: String,
        password: String,
        confirmPassword: String,
        email: String
    ) {
        if (firstName.isEmpty()) {
            signUpView?.setFirstNameError()
            return
        }

        if (lastName.isEmpty()) {
            signUpView?.setLastNameError()
            return
        }

        if (username.isEmpty()) {
            signUpView?.setUsernameError()
            return
        }

        if(email.isEmpty()) {
            signUpView?.setEmailError()
        }

        if (password.isEmpty()) {
            signUpView?.setPasswordError()
            return
        }

        if (confirmPassword.isEmpty()) {
            signUpView?.setConfirmPasswordError()
            return
        }

        if (password != confirmPassword) {
            signUpView?.passwordsDoNotMatchError()
            return
        }

        signUpView?.showProgress()
        CoroutineScope(Dispatchers.IO).launch {
            signUpService.signUp(firstName,lastName,username,password,email, object : SignUpServiceInterface.SignUpCallback {
                override fun onSuccess(response: SignUpResponse) {
                    signUpView?.hideProgress()
                    signUpView?.showMessage(response.message)
                    signUpView?.navigateToHome()
                }

                override fun onFailure(message: String) {
                    signUpView?.hideProgress()
                    signUpView?.showError(message)
                }
            })
        }
    }

    fun onDestroy() {
        signUpView = null
    }
}