package com.rantinaya.about.data
/**
 * Clase que representa a un miembro con información de contacto.
 *
 * @property name Nombre del miembro.
 * @property email Dirección de correo electrónico del miembro.
 * @property phone Número de teléfono del miembro.
 * @property links Triple que contiene tres enlaces relacionados con el miembro.
 */
class AboutMember (
    var name : String,
    var email : String,
    var phone : String,
    var links : Triple<String, String, String>
)
