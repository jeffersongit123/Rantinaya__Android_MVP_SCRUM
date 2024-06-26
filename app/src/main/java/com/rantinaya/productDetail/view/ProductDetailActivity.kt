package com.rantinaya.productDetail.view

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rantinaya.databinding.ActivityProductDetailBinding
import com.rantinaya.products.data.ProductByCanton
import com.rantinaya.productDetail.presenter.ProductDetailPresenter
import com.rantinaya.productDetail.ProductDetailContract
import com.rantinaya.products.view.ProductsImgAdapter
import com.rantinaya.utils.setAutomaticSlider

class ProductDetailActivity : AppCompatActivity() , ProductDetailContract {
    private lateinit var binding : ActivityProductDetailBinding
    private val presenter = ProductDetailPresenter(this)
    private lateinit var product : ProductByCanton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        product = intent.extras!!.getSerializable("product") as ProductByCanton
        presenter.fetchDetail(product)
        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            btnFace.setOnClickListener { presenter.openFace(product) }
            btnInst.setOnClickListener { presenter.openInst(product) }
            btnWzp.setOnClickListener { presenter.openWzp(product) }
        }
    }

    override fun setInfoProduct(productByCanton: ProductByCanton) {
        binding.apply {
            textDescription.text = productByCanton.Descripción
            textTitle.text = "Accediste a productos de "+productByCanton.Cantón
            textName.text = productByCanton.Producto
            textContact.text = productByCanton.Contacto
            textEmail.text = productByCanton.Email
            textAddress.text = productByCanton.Dirección
            textOwner.text = productByCanton.Propietario
            textPrice.text = productByCanton.Precio
        }
    }

    override fun setImages(list: List<Int>) {
        val adapter = ProductsImgAdapter(list.toMutableList())
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