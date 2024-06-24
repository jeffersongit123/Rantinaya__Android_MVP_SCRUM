package com.rantinaya.serviceDetail.presenter

import com.rantinaya.services.data.ServiceByCanton
import com.rantinaya.utils.modelBackUp.listImageInfoServices
import com.rantinaya.serviceDetail.ServiceDetailContract
import com.rantinaya.services.data.ServicesService

/**
 * Presenter para la pantalla de detalle de servicio.
 * @param view Interfaz de contrato para comunicarse con la vista.
 */
class ServiceDetailPresenter(val view: ServiceDetailContract?) {

    private val service = ServicesService()

    /**
     * Método para obtener los detalles del servicio y actualizar la vista correspondiente.
     * @param serviceByCanton Objeto que contiene los detalles del servicio.
     */
    fun fetchDetail(serviceByCanton: ServiceByCanton) {
        // Setea la información del servicio en la vista
        view?.setInfoService(serviceByCanton)

        // Obtiene y muestra las imágenes del servicio desde el archivo de respaldo
        view?.setImages(listImageInfoServices.firstOrNull { it.name == serviceByCanton.Servicio }!!.listImage)

        // Obtiene y establece el color del título según el cantón del servicio
        service.getColorTitle(serviceByCanton.Cantón, callback = { title, color ->
            view?.setColor(color)
        })
    }

    /**
     * Método para abrir la página de Facebook asociada al servicio.
     * @param serviceByCanton Objeto que contiene los detalles del servicio.
     */
    fun openFace(serviceByCanton: ServiceByCanton) {
        view?.openWeb(service.getRedes(serviceByCanton.Servicio).first)
    }

    /**
     * Método para abrir la página de Instagram asociada al servicio.
     * @param serviceByCanton Objeto que contiene los detalles del servicio.
     */
    fun openInst(serviceByCanton: ServiceByCanton) {
        view?.openWeb(service.getRedes(serviceByCanton.Servicio).second)
    }

    /**
     * Método para abrir la página de WhatsApp asociada al servicio.
     * @param serviceByCanton Objeto que contiene los detalles del servicio.
     */
    fun openWzp(serviceByCanton: ServiceByCanton) {
        view?.openWeb(service.getRedes(serviceByCanton.Servicio).third)
    }
}
