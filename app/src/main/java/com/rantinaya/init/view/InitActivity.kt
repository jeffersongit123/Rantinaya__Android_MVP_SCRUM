package com.rantinaya.init.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rantinaya.databinding.ActivityInitBinding
import com.rantinaya.home.view.HomeActivity
import com.rantinaya.init.presenter.InitPresenter
import com.rantinaya.init.InitContract

class InitActivity : AppCompatActivity(), InitContract {
    private lateinit var binding : ActivityInitBinding
    private val presenter = InitPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()

    }

    private fun setListeners() {
        binding.btnInit.setOnClickListener {
            presenter.navigateToHome()
        }
        binding.btnWeb.setOnClickListener { presenter.openWeb() }
    }

    override fun navigateToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    override fun openWeb() {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://rantinaya.com/")
        )
       startActivity(intent)
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}