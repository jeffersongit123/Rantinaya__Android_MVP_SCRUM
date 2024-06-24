package com.rantinaya.about.presenter

import com.rantinaya.about.AboutContract
import com.rantinaya.about.data.AboutService

/**
 * Clase que actúa como presentador en el patrón MVP (Modelo-Vista-Presentador) para la funcionalidad 'About'.
 *
 * @property view La vista que implementa AboutContract.
 */
class AboutPresenter(var view: AboutContract?) {

    // Instancia del servicio para obtener datos de los miembros.
    private val service = AboutService()

    /**
     * Método para obtener la lista de miembros y actualizar la vista.
     */
    fun getMembers() {
        view?.setMembers(service.getAboutMembers())
    }

    /**
     * Método para abrir una URL en la vista.
     *
     * @param url La URL que se debe abrir.
     */
    fun openWeb(url: String) {
        view?.openWeb(url)
    }

    /**
     * Método que se llama cuando el presentador ya no es necesario.
     * Libera la referencia a la vista para evitar fugas de memoria.
     */
    fun onDestroy() {
        view = null
    }
}
