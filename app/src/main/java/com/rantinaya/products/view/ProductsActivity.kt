package com.rantinaya.products.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rantinaya.databinding.ActivityProductsBinding
import com.rantinaya.products.data.ProductByCanton
import com.rantinaya.products.presenter.ProductsPresenter
import com.rantinaya.products.ProductsContract
import com.rantinaya.productDetail.view.ProductDetailActivity

class ProductsActivity : AppCompatActivity() , ProductsContract {
    private lateinit var binding : ActivityProductsBinding
    private val presenter = ProductsPresenter(this)
    private lateinit var adapter : ProductsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAdapter()
        fetchProducts(intent.extras?.getString("canton","") ?: "")

    }

    private fun setAdapter() {
        adapter = ProductsAdapter(mutableListOf())
        binding.rvProducts.adapter = adapter
        adapter.onSelect = {
            presenter.navigateToDetail(it)
        }
    }

    private fun fetchProducts(canton: String) {
        presenter.fetchProducts(canton)
    }

    override fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }

    override fun onSuccess(products: List<ProductByCanton>) {
        adapter.list = products.toMutableList()
        adapter.update()
    }

    override fun onError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToDetail(product: ProductByCanton) {
        startActivity(Intent(this, ProductDetailActivity::class.java).apply {
            this.putExtra("product",product)
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