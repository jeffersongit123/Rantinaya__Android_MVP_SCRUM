package com.rantinaya.signup.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rantinaya.databinding.ActivitySingUpBinding
import com.rantinaya.signup.presenter.SignUpPresenter
import com.rantinaya.signup.data.SignUpService
import com.rantinaya.signup.SignUpContract

class SignUpActivity : AppCompatActivity() , SignUpContract {
    private lateinit var binding: ActivitySingUpBinding
    private  val presenter: SignUpPresenter = SignUpPresenter(this, SignUpService())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }

    private fun setListeners() {
        binding.button.setOnClickListener {
            presenter.validateCredentials(
                binding.firstNameEdittext.text.toString(),
                binding.lastNameEdittext.text.toString(),
                binding.userNameEdittext.text.toString(),
                binding.passwordEdittext.text.toString(),
                binding.passwordConfirmEdittext.text.toString(),
                binding.emailEdittext.text.toString()
            )
        }
    }

    override fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
        binding.button.isEnabled = false
    }

    override fun hideProgress() {
        binding.progressBar.visibility = View.GONE
        binding.button.isEnabled = true
    }

    override fun setFirstNameError() {
        Toast.makeText(this, "Nombres es requerido", Toast.LENGTH_SHORT).show()
    }

    override fun setLastNameError() {
        Toast.makeText(this, "Apellidos es requerido", Toast.LENGTH_SHORT).show()
    }

    override fun setUsernameError() {
        Toast.makeText(this, "Nombre de usuario es requerido", Toast.LENGTH_SHORT).show()
    }

    override fun setPasswordError() {
        Toast.makeText(this, "Contraseña es requerida", Toast.LENGTH_SHORT).show()
    }

    override fun setConfirmPasswordError() {
        Toast.makeText(this, "Confirmación de contraseña es requerida", Toast.LENGTH_SHORT).show()
    }

    override fun passwordsDoNotMatchError() {
        Toast.makeText(this, "Contraseña es requerida", Toast.LENGTH_SHORT).show()
    }

    override fun setEmailError() {
        Toast.makeText(this, "Email es requerida", Toast.LENGTH_SHORT).show()
    }

    override fun navigateToHome() {
        finish()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}