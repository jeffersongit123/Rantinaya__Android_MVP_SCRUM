package com.rantinaya.init

/**
 * Interfaz que define los métodos de navegación y gestión de ciclo de vida para la pantalla de inicio (Init).
 */
interface InitContract {
    /**
     * Navega a la pantalla principal (Home).
     */
    fun navigateToHome()

    /**
     * Abre una página web en el navegador predeterminado.
     */
    fun openWeb()

    /**
     * Limpia la referencia a la vista para evitar pérdidas de memoria.
     */
    fun onDestroy()
}
