package com.rantinaya.home

/**
 * Interfaz que define los métodos de navegación y gestión de ciclo de vida para la vista principal (Home).
 */
interface HomeContract {
    /**
     * Navega a la pantalla 'About'.
     */
    fun navigateToAbout()

    /**
     * Navega a la pantalla de inicio de sesión.
     */
    /**
     * Navega a la pantalla de productos para el cantón especificado.
     *
     * @param canton El nombre del cantón para el cual se desean mostrar los productos.
     */

    /**
     * Limpia la referencia a la vista para evitar pérdidas de memoria.
     */
    fun onDestroy()

    /**
     * Navega a la pantalla de servicios para el cantón especificado.
     *
     * @param canton El nombre del cantón para el cual se desean mostrar los servicios.
     */
    fun navigateToServices(canton: String)
}
