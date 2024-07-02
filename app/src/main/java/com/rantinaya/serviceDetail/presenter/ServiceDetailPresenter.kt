package com.rantinaya.serviceDetail.presenter

import com.rantinaya.services.data.ServiceByCanton
import com.rantinaya.utils.modelBackUp.listImageInfoServices
import com.rantinaya.serviceDetail.ServiceDetailContract
import com.rantinaya.services.data.ServicesService

class ServiceDetailPresenter (val view : ServiceDetailContract?) {

    private val service = ServicesService()
    fun fetchDetail(serviceByCanton : ServiceByCanton) {
        view?.setInfoService(serviceByCanton)
        view?.setImages(listImageInfoServices.firstOrNull { it.name == serviceByCanton.Servicio }!!.listImage)
        service.getColorTitle(serviceByCanton.Cantón, callback = {title, color ->
            view?.setColor(color)
        })
    }

    fun openFace(serviceByCanton: ServiceByCanton) {
        view?.openWeb(service.getRedes(serviceByCanton.Servicio).first)
    }

    fun openInst(serviceByCanton: ServiceByCanton) {
        view?.openWeb(service.getRedes(serviceByCanton.Servicio).second)
    }

    fun openWzp(serviceByCanton: ServiceByCanton) {
        view?.openWeb(service.getRedes(serviceByCanton.Servicio).third)
    }
}