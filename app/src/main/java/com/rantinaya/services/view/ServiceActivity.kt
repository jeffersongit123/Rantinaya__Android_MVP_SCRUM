package com.rantinaya.services.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.rantinaya.databinding.ActivityServiceBinding
import com.rantinaya.services.data.ServiceByCanton
import com.rantinaya.services.presenter.ServicePresenter
import com.rantinaya.services.ServiceContract
import com.rantinaya.serviceDetail.view.ServiceDetailActivity

class ServiceActivity : AppCompatActivity() , ServiceContract {
    private lateinit var binding : ActivityServiceBinding
    private val presenter = ServicePresenter(this)
    private lateinit var adapter : ServicesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAdapter()
        fetchServices(intent.extras?.getString("canton","") ?: "")

    }

    private fun setAdapter() {
        adapter = ServicesAdapter(mutableListOf())
        binding.rvServices.adapter = adapter
        adapter.onSelect = {
            presenter.navigateToDetail(it)
        }
    }

    private fun fetchServices(canton: String) {
        presenter.fetchServices(canton)
    }

    override fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }

    override fun onSuccess(products: List<ServiceByCanton>) {
        adapter.list = products.toMutableList()
        adapter.update()
    }

    override fun onError(error: String) {

    }

    override fun navigateToDetail(service: ServiceByCanton) {
        startActivity(Intent(this, ServiceDetailActivity::class.java).apply {
            this.putExtra("service",service)
        })
    }

    override fun setTitle(title: String) {
        binding.textTitle.text = title
    }

    override fun setColor(color: String) {
        binding.containerTitle.setBackgroundColor(Color.parseColor(color))
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}