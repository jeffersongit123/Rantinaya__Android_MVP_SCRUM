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

/**
 * Actividad principal para mostrar la lista de servicios.
 */
class ServiceActivity : AppCompatActivity(), ServiceContract {
    private lateinit var binding: ActivityServiceBinding
    private val presenter = ServicePresenter(this)
    private lateinit var adapter: ServicesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el adaptador y la vista de lista
        setAdapter()

        // Obtener el cantón del intent o establecerlo como vacío por defecto
        val canton = intent.extras?.getString("canton", "") ?: ""
        fetchServices(canton)
    }

    /**
     * Configurar el adaptador y la vista de lista.
     */
    private fun setAdapter() {
        adapter = ServicesAdapter(mutableListOf())
        binding.rvServices.adapter = adapter

        // Manejar el evento de selección de un servicio en el adaptador
        adapter.onSelect = {
            presenter.navigateToDetail(it)
        }
    }

    /**
     * Método para obtener y mostrar los servicios basados en un cantón específico.
     * @param canton Nombre del cantón para filtrar los servicios.
     */
    private fun fetchServices(canton: String) {
        presenter.fetchServices(canton)
    }

    override fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }

    override fun onSuccess(services: List<ServiceByCanton>) {
        adapter.list = services.toMutableList()
        adapter.update()
    }

    override fun onError(error: String) {
        // Manejar errores en la vista si es necesario
    }

    override fun navigateToDetail(service: ServiceByCanton) {
        // Navegar a la actividad de detalle de servicio con el servicio seleccionado
        startActivity(Intent(this, ServiceDetailActivity::class.java).apply {
            putExtra("service", service)
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
