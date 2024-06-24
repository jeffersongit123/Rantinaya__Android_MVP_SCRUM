package com.rantinaya.home.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rantinaya.about.view.AboutActivity
import com.rantinaya.databinding.ActivityHomeBinding
import com.rantinaya.home.presenter.HomePresenter
import com.rantinaya.home.HomeContract
import com.rantinaya.utils.CantonEnum
import com.rantinaya.services.view.ServiceActivity

/**
 * Actividad principal que muestra la pantalla de inicio (Home) y gestiona la navegación entre las distintas funciones.
 */
class HomeActivity : AppCompatActivity(), HomeContract {
    private lateinit var binding : ActivityHomeBinding
    private val presenter = HomePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }

    /**
     * Establece los listeners para los botones de la interfaz de usuario.
     */
    private fun setListeners() {
        binding.btnAbout.setOnClickListener { presenter.navigateToAbout() }
        // binding.btnLogin.setOnClickListener { presenter.navigateToLogin() }

        binding.btnServiceLoreto.setOnClickListener { presenter.navigateToService(CantonEnum.Loreto.name) }
        binding.btnServiceAguarico.setOnClickListener { presenter.navigateToService(CantonEnum.Aguarico.name) }
        binding.btnServiceSachas.setOnClickListener { presenter.navigateToService(CantonEnum.Sacha.name) }
        binding.btnServiceOrellana.setOnClickListener { presenter.navigateToService(CantonEnum.Orellana.name) }
    }

    /**
     * Navega a la pantalla 'AboutActivity'.
     */
    override fun navigateToAbout() {
        startActivity(Intent(this, AboutActivity::class.java))
    }

    /**
     * No implementado actualmente en esta versión.
     */


    /**
     * Llama al método onDestroy del presentador para limpiar la referencia a la vista.
     */
    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    /**
     * Navega a la pantalla 'ServiceActivity' con el cantón especificado.
     *
     * @param canton El nombre del cantón para el cual se desean mostrar los servicios.
     */
    override fun navigateToServices(canton: String) {
        startActivity(Intent(this, ServiceActivity::class.java).apply {
            this.putExtra("canton", canton)
        })
    }
}
