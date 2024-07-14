package com.rantinaya.products.presenter

import com.rantinaya.products.data.ProductByCanton
import com.rantinaya.products.ProductsContract
import com.rantinaya.products.data.ProductsService
import com.rantinaya.products.data.ProductsServiceInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductsPresenter(var productsView: ProductsContract?) {
    private var listProducts = mutableListOf<ProductByCanton>()
    private val service = ProductsService()
    fun fetchProducts(canton: String) {
        service.getColorTitle(canton, callback = {title, color ->
            productsView?.setTitle(title)
            productsView?.setColor(color)
        })
        productsView?.showLoading()
        CoroutineScope(Dispatchers.IO).launch {
            service.fetchProducts(
                canton.lowercase(),
                object : ProductsServiceInterface.ProductsCallback {
                    override fun onSuccess(response: List<ProductByCanton>) {
                        productsView?.hideLoading()
                        listProducts = response.toMutableList()
                        productsView?.onSuccess(response)
                    }

                    override fun onFailure(message: String) {
                        productsView?.hideLoading()
                        productsView?.onError(message)
                    }
                })
        }
    }

    fun navigateToDetail(position: Int) {
        productsView?.navigateToDetail(listProducts[position])
    }

    fun onDestroy() {
        productsView = null
    }
}