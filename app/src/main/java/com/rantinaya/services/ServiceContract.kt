package com.rantinaya.services

import com.rantinaya.services.data.ServiceByCanton

/**
 * Interfaz que define las operaciones requeridas para manejar la interacción con los servicios.
 */
interface ServiceContract {
    /**
     * Muestra un indicador de carga o progreso.
     */
    fun showLoading()

    /**
     * Oculta el indicador de carga o progreso.
     */
    fun hideLoading()

    /**
     * Se invoca cuando la solicitud de servicios es exitosa.
     * @param service Lista de servicios obtenidos.
     */
    fun onSuccess(service: List<ServiceByCanton>)

    /**
     * Se invoca cuando ocurre un error durante la solicitud de servicios.
     * @param error Mensaje de error descriptivo.
     */
    fun onError(error: String)

    /**
     * Navega a la pantalla de detalle del servicio.
     * @param service Detalle del servicio al que se navegará.
     */
    fun navigateToDetail(service: ServiceByCanton)

    /**
     * Establece el título de la pantalla.
     * @param title Título a establecer.
     */
    fun setTitle(title: String)

    /**
     * Establece el color de fondo de la pantalla.
     * @param color Color en formato hexadecimal (#RRGGBB o #AARRGGBB).
     */
    fun setColor(color: String)
}
