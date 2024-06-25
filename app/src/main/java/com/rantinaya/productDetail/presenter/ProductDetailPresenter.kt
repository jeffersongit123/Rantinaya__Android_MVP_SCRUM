package com.rantinaya.productDetail.presenter

import com.rantinaya.products.data.ProductByCanton
import com.rantinaya.productDetail.ProductDetailContract
import com.rantinaya.products.data.ProductsService

class ProductDetailPresenter(val view : ProductDetailContract?) {
    private val service = ProductsService()
    fun fetchDetail(product : ProductByCanton) {
        view?.setInfoProduct(product)
        view?.setImages(service.getImagesProducts(product.Empresa))
        service.getColorTitle(product.Cantón, callback = {title, color ->
            view?.setColor(color)
        })
    }

    fun openFace(product: ProductByCanton) {
        view?.openWeb(service.getRedes(product.Empresa).first)
    }

    fun openInst(product: ProductByCanton) {
        view?.openWeb(service.getRedes(product.Empresa).second)
    }

    fun openWzp(product: ProductByCanton) {
        view?.openWeb(service.getRedes(product.Empresa).third)
    }
}