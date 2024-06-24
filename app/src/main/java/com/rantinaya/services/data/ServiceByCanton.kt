package com.rantinaya.services.data

import java.io.Serializable

/**
 * Clase que representa un servicio por cantón.
 *
 * @property Cantón Nombre del cantón donde se ofrece el servicio.
 * @property Descripción Descripción del servicio.
 * @property Empresa Nombre de la empresa que ofrece el servicio.
 * @property Precio Precio del servicio.
 * @property Servicio Tipo de servicio ofrecido.
 * @property Contacto Información de contacto para el servicio.
 * @property Dirección Dirección donde se ofrece el servicio.
 * @property Email Correo electrónico de contacto.
 * @property Propietario Nombre del propietario del servicio.
 */
class ServiceByCanton (
    var Cantón : String,
    var Descripción : String,
    var Empresa : String,
    var Precio : String,
    var Servicio : String,
    var Contacto : String,
    var Dirección : String,
    var Email : String,
    var Propietario : String
) : Serializable
