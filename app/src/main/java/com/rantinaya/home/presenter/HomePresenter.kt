package com.rantinaya.home.presenter

import com.rantinaya.home.HomeContract

/**
 * Presentador para la vista principal (Home) que maneja la navegación y lógica de interacción.
 *
 * @param homeView Una referencia opcional a la vista que implementa el contrato HomeContract.
 */
class HomePresenter(var homeView: HomeContract?) {

    /**
     * Navega a la vista 'About'.
     */
    fun navigateToAbout() {
        homeView?.navigateToAbout()
    }

    /**
     * Navega a la vista de inicio de sesión.
     */


    /**
     * Navega a la vista de productos para el cantón especificado.
     *
     * @param canton El nombre del cantón para el cual se desean mostrar los productos.
     */


    /**
     * Navega a la vista de servicios para el cantón especificado.
     *
     * @param canton El nombre del cantón para el cual se desean mostrar los servicios.
     */
    fun navigateToService(canton: String) {
        homeView?.navigateToServices(canton)
    }

    /**
     * Limpia la referencia a la vista para evitar pérdidas de memoria.
     */
    fun onDestroy() {
        homeView = null
    }
}
