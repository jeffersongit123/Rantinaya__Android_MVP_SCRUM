package com.rantinaya.init.presenter

import com.rantinaya.init.InitContract

/**
 * Presentador para la pantalla de inicio (Init).
 * Gestiona la lógica de negocio y la interacción con la vista a través de métodos definidos en InitContract.
 *
 * @property initView La vista de inicio (InitContract) asociada a este presentador.
 */
class InitPresenter(var initView: InitContract?) {

    /**
     * Navega a la pantalla principal (Home).
     * Llama al método navigateToHome en la vista asociada si está disponible.
     */
    fun navigateToHome() {
        initView?.navigateToHome()
    }

    /**
     * Abre una página web.
     * Llama al método openWeb en la vista asociada si está disponible.
     */
    fun openWeb() {
        initView?.openWeb()
    }

    /**
     * Limpia la referencia a la vista para evitar pérdidas de memoria.
     */
    fun onDestroy() {
        initView = null
    }
}
