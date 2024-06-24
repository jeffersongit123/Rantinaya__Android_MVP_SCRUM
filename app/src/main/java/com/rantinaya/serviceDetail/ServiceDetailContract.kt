package com.rantinaya.serviceDetail

import com.rantinaya.services.data.ServiceByCanton

/**
 * Interfaz que define los métodos para la comunicación entre el presentador y la vista
 * en el contexto de los detalles de un servicio.
 */
interface ServiceDetailContract {
    /**
     * Método para establecer la información detallada de un servicio.
     * @param serviceByCanton Objeto que contiene los detalles del servicio.
     */
    fun setInfoService(serviceByCanton: ServiceByCanton)

    /**
     * Método para establecer las imágenes asociadas al servicio.
     * @param list Lista de recursos de imágenes a mostrar.
     */
    fun setImages(list: List<Int>)

    /**
     * Método para abrir un enlace web externo.
     * @param url URL del enlace web a abrir.
     */
    fun openWeb(url: String)

    /**
     * Método para establecer el color de fondo de la interfaz de usuario.
     * @param color Color en formato hexadecimal (#RRGGBB) a establecer.
     */
    fun setColor(color: String)
}
