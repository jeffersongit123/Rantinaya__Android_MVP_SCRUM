package com.rantinaya.serviceDetail

import com.rantinaya.products.data.ProductByCanton
import com.rantinaya.services.data.ServiceByCanton

interface ServiceDetailContract {
    fun setInfoService(serviceByCanton: ServiceByCanton)
    fun setImages(list : List<Int>)
    fun openWeb(url : String)
    fun setColor(color : String)
    fun openCar()
    fun openAddProduct(serviceByCanton: ServiceByCanton)
}