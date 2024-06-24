package com.rantinaya.products

import com.rantinaya.products.data.ProductByCanton

interface ProductsContract {
    fun showLoading()
    fun hideLoading()
    fun onSuccess(products: List<ProductByCanton>)
    fun onError(error: String)
    fun navigateToDetail(product : ProductByCanton)
    fun setTitle(title : String)
    fun setColor(color : String)
}