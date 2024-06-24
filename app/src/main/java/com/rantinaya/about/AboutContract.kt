package com.rantinaya.about

import com.rantinaya.about.data.AboutMember

/**
 * Interfaz que define el contrato entre la vista y el presentador para la funcionalidad 'About'.
 */
interface AboutContract {

    /**
     * Establece la lista de miembros en la vista.
     *
     * @param members Lista de objetos AboutMember.
     */
    fun setMembers(members: List<AboutMember>)

    /**
     * Abre una URL en la vista.
     *
     * @param url La URL que se debe abrir.
     */
    fun openWeb(url: String)
}
