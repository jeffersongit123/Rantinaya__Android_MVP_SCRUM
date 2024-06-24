package com.rantinaya.serviceDetail.view

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rantinaya.databinding.ActivityServiceDetailBinding
import com.rantinaya.services.data.ServiceByCanton
import com.rantinaya.serviceDetail.presenter.ServiceDetailPresenter
import com.rantinaya.serviceDetail.ServiceDetailContract
import com.rantinaya.services.view.ServicesImageAdapter
import com.rantinaya.utils.setAutomaticSlider

/**
 * Actividad para mostrar los detalles de un servicio específico.
 */
class ServiceDetailActivity : AppCompatActivity(), ServiceDetailContract {
    private lateinit var binding: ActivityServiceDetailBinding
    private val presenter = ServiceDetailPresenter(this)
    private lateinit var service: ServiceByCanton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtiene el objeto ServiceByCanton pasado desde la actividad anterior
        service = intent.extras!!.getSerializable("service") as ServiceByCanton

        // Inicializa el presenter y carga los detalles del servicio
        presenter.fetchDetail(service)
        setListeners()
    }

    /**
     * Establece los listeners para los botones de redes sociales.
     */
    private fun setListeners() {
        binding.apply {
            btnFace.setOnClickListener { presenter.openFace(service) }
            btnInst.setOnClickListener { presenter.openInst(service) }
            btnWzp.setOnClickListener { presenter.openWzp(service) }
        }
    }

    /**
     * Método de la interfaz ServiceDetailContract para mostrar la información del servicio.
     * @param serviceByCanton Objeto que contiene los detalles del servicio.
     */
    override fun setInfoService(serviceByCanton: ServiceByCanton) {
        binding.apply {
            textDescription.text = serviceByCanton.Descripción
            textTitle.text = "Accediste a servicios de " + serviceByCanton.Cantón
            textName.text = serviceByCanton.Servicio
            textContact.text = serviceByCanton.Contacto
            textEmail.text = serviceByCanton.Email
            textAddress.text = serviceByCanton.Dirección
            textOwner.text = serviceByCanton.Propietario
            textPrice.text = serviceByCanton.Precio
        }
    }

    /**
     * Método de la interfaz ServiceDetailContract para mostrar las imágenes del servicio.
     * @param list Lista de recursos de imágenes a mostrar.
     */
    override fun setImages(list: List<Int>) {
        val adapter = ServicesImageAdapter(list.toMutableList())
        binding.rvImages.adapter = adapter
        binding.rvImages.setAutomaticSlider(0, list.size)
    }

    /**
     * Método de la interfaz ServiceDetailContract para abrir un enlace web.
     * @param url URL del enlace web a abrir.
     */
    override fun openWeb(url: String) {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(url)
        )
        try {
            startActivity(intent)
        } catch (e: Exception) {
            // Manejar excepción si no se puede abrir el enlace
        }
    }

    /**
     * Método de la interfaz ServiceDetailContract para establecer el color de fondo del contenedor del título.
     * @param color Color en formato hexadecimal (#RRGGBB) a establecer.
     */
    override fun setColor(color: String) {
        binding.containerTitle.setBackgroundColor(Color.parseColor(color))
    }
}
