package com.rantinaya.login.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rantinaya.databinding.ActivityLoginBinding
import com.rantinaya.login.presenter.LoginPresenter
import com.rantinaya.login.data.LoginService
import com.rantinaya.login.LoginContract
import com.rantinaya.init.view.InitActivity
import com.rantinaya.signup.view.SignUpActivity

class LoginActivity : AppCompatActivity() , LoginContract {
    private lateinit var binding : ActivityLoginBinding
    private val presenter = LoginPresenter(this, LoginService())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }

    private fun setListeners() {
        binding.btnSignUpUser.setOnClickListener { presenter.navigateToSignUp() }
        binding.btnSignIn.setOnClickListener { presenter.validateCredentials(
            binding.edtEmail.text.toString(),
            binding.edtPassword.text.toString()
        ) }
    }

    override fun navigateToSingUp() {
        startActivity(Intent(this, SignUpActivity::class.java))
    }

    override fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.progressBar.visibility = View.GONE
    }

    override fun setEmailError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun setPasswordError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToHome() {
        startActivity(Intent(this, InitActivity::class.java))
        finish()
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}