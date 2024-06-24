package com.rantinaya.api

import com.rantinaya.services.data.ServiceByCanton
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Interfaz que define las operaciones API disponibles mediante Retrofit.
 */
interface ApiService {
    /**
     * Obtiene la lista de productos por cantón.
     *
     * @param canton Nombre del cantón para el cual se obtienen los productos.
     * @return Lista de productos específicos del cantón.
     */

    /**
     * Obtiene la lista de servicios por cantón.
     *
     * @param canton Nombre del cantón para el cual se obtienen los servicios.
     * @return Lista de servicios específicos del cantón.
     */
    @GET("/servicios/{canton}")
    suspend fun getServices(@Path("canton") canton: String): List<ServiceByCanton>
}
