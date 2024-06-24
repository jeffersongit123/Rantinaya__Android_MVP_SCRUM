package com.rantinaya.init.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rantinaya.databinding.ActivityInitBinding
import com.rantinaya.home.view.HomeActivity
import com.rantinaya.init.presenter.InitPresenter
import com.rantinaya.init.InitContract

/**
 * Actividad principal de inicio (Init).
 * Implementa la interfaz InitContract para definir métodos de navegación y gestión de ciclo de vida.
 */
class InitActivity : AppCompatActivity(), InitContract {
    private lateinit var binding : ActivityInitBinding
    private val presenter = InitPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }

    /**
     * Configura los listeners para los botones de la interfaz de usuario.
     */
    private fun setListeners() {
        binding.btnInit.setOnClickListener {
            presenter.navigateToHome()
        }
        binding.btnWeb.setOnClickListener {
            presenter.openWeb()
        }
    }

    /**
     * Navega a la pantalla principal (HomeActivity).
     * Implementación de InitContract.
     */
    override fun navigateToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    /**
     * Abre una página web en el navegador predeterminado.
     * Implementación de InitContract.
     */
    override fun openWeb() {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://rantinaya.com/")
        )
        startActivity(intent)
    }

    /**
     * Llama al método onDestroy en el presentador para limpiar la referencia a la vista.
     * Llama al método onDestroy de la superclase.
     */
    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}
