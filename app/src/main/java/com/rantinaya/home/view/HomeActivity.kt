package com.rantinaya.home.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rantinaya.about.view.AboutActivity
import com.rantinaya.databinding.ActivityHomeBinding
import com.rantinaya.home.presenter.HomePresenter
import com.rantinaya.home.HomeContract
import com.rantinaya.utils.CantonEnum
import com.rantinaya.products.view.ProductsActivity
import com.rantinaya.services.view.ServiceActivity

class HomeActivity : AppCompatActivity(), HomeContract {
    private lateinit var binding : ActivityHomeBinding
    private val presenter = HomePresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }

    private fun setListeners() {
        binding.btnAbout.setOnClickListener { presenter.navigateToAbout() }
       // binding.btnLogin.setOnClickListener { presenter.navigateToLogin() }
        binding.btnLoreto.setOnClickListener { presenter.navigateToProduct(CantonEnum.Loreto.name) }
        binding.btnAguario.setOnClickListener { presenter.navigateToProduct(CantonEnum.Aguarico.name) }
        binding.btnSachas.setOnClickListener { presenter.navigateToProduct(CantonEnum.Sacha.name) }
        binding.btnOrellana.setOnClickListener { presenter.navigateToProduct(CantonEnum.Orellana.name) }

        binding.btnServiceLoreto.setOnClickListener { presenter.navigateToService(CantonEnum.Loreto.name) }
        binding.btnServiceAguarico.setOnClickListener { presenter.navigateToService(CantonEnum.Aguarico.name) }
        binding.btnServiceSachas.setOnClickListener { presenter.navigateToService(CantonEnum.Sacha.name) }
        binding.btnServiceOrellana.setOnClickListener { presenter.navigateToService(CantonEnum.Orellana.name) }
    }

    override fun navigateToAbout() {
        startActivity(Intent(this, AboutActivity::class.java))
    }

    override fun navigateToLogin() {

    }

    override fun navigateToProducts(canton: String) {
        startActivity(Intent(this, ProductsActivity::class.java).apply {
            this.putExtra("canton",canton)
        })
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun navigateToServices(canton: String) {
        startActivity(Intent(this, ServiceActivity::class.java).apply {
            this.putExtra("canton",canton)
        })
    }
}