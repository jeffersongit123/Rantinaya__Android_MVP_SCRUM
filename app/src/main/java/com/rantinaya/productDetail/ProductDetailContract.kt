package com.rantinaya.productDetail

import com.rantinaya.products.data.ProductByCanton

interface ProductDetailContract {
    fun setInfoProduct(productByCanton: ProductByCanton)
    fun setImages(list : List<Int>)
    fun openWeb(url : String)
    fun setColor(color : String)
}