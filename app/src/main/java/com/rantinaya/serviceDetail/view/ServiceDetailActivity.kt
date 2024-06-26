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

class ServiceDetailActivity : AppCompatActivity() , ServiceDetailContract {
    private lateinit var binding : ActivityServiceDetailBinding
    private val presenter = ServiceDetailPresenter(this)
    private lateinit var service : ServiceByCanton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        service = intent.extras!!.getSerializable("service") as ServiceByCanton
        presenter.fetchDetail(service)
        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            btnFace.setOnClickListener { presenter.openFace(service) }
            btnInst.setOnClickListener { presenter.openInst(service) }
            btnWzp.setOnClickListener { presenter.openWzp(service) }
        }
    }

    override fun setInfoService(serviceByCanton: ServiceByCanton) {
        binding.apply {
            textDescription.text = serviceByCanton.Descripción
            textTitle.text = "Accediste a servicios de "+serviceByCanton.Cantón
            textName.text = serviceByCanton.Servicio
             textContact.text = serviceByCanton.Contacto
            textEmail.text = serviceByCanton.Email
            textAddress.text = serviceByCanton.Dirección
            textOwner.text = serviceByCanton.Propietario
            textPrice.text = serviceByCanton.Precio
        }
    }

    override fun setImages(list: List<Int>) {
        val adapter = ServicesImageAdapter(list.toMutableList())
        binding.rvImages.adapter = adapter
        binding.rvImages.setAutomaticSlider(0,list.size)
    }

    override fun openWeb(url: String) {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(url)
        )
        try {
            startActivity(intent)
        }catch (e : Exception) {

        }

    }

    override fun setColor(color: String) {
        binding.containerTitle.setBackgroundColor(Color.parseColor(color))
    }
}