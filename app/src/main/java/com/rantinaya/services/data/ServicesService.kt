package com.rantinaya.services.data

import com.rantinaya.api.RetrofitClient
import com.rantinaya.utils.modelBackUp.listImageInfoServices
import com.rantinaya.utils.CantonEnum
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Interfaz para definir los métodos que deben ser implementados en ServicesService.
 */
interface ServicesServiceInterface {
    interface ServicesCallback {
        fun onSuccess(response: List<ServiceByCanton>)
        fun onFailure(message: String)
    }

    /**
     * Método suspendido para obtener servicios basados en un cantón específico.
     * @param canton El nombre del cantón para filtrar los servicios.
     * @param callback Callback que maneja el resultado de la solicitud.
     */
    suspend fun fetchServices(canton: String, callback: ServicesCallback)

    /**
     * Método para obtener las imágenes asociadas a una empresa de servicios.
     * @param empresa Nombre de la empresa para la cual se obtienen las imágenes.
     * @return Lista de recursos de imágenes.
     */
    fun getImagesService(empresa: String): List<Int>

    /**
     * Método para obtener las redes sociales asociadas a una empresa de servicios.
     * @param empresa Nombre de la empresa para la cual se obtienen las redes sociales.
     * @return Tripleta de cadenas con las URL de las redes sociales (Facebook, Instagram, WhatsApp).
     */
    fun getRedes(empresa: String): Triple<String, String, String>

    /**
     * Método para obtener el título y el color asociado a un cantón específico.
     * @param canton Nombre del cantón para el cual se obtiene el título y color.
     * @param callback Callback que maneja el resultado del título y color.
     */
    fun getColorTitle(canton: String, callback: (title: String, color: String) -> Unit)
}

/**
 * Implementación de ServicesServiceInterface que maneja la obtención de servicios.
 */
class ServicesService : ServicesServiceInterface {
    /**
     * Método suspendido para obtener servicios basados en un cantón específico.
     * Utiliza Retrofit para realizar la solicitud a la API.
     * @param canton El nombre del cantón para filtrar los servicios.
     * @param callback Callback que maneja el resultado de la solicitud.
     */
    override suspend fun fetchServices(canton: String, callback: ServicesServiceInterface.ServicesCallback) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.apiService.getServices(canton.lowercase())
                withContext(Dispatchers.Main) {
                    callback.onSuccess(response)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    callback.onFailure(e.message ?: "Error desconocido")
                }
            }
        }
    }

    /**
     * Método para obtener las imágenes asociadas a una empresa de servicios.
     * @param empresa Nombre de la empresa para la cual se obtienen las imágenes.
     * @return Lista de recursos de imágenes.
     */
    override fun getImagesService(empresa: String): List<Int> {
        return listImageInfoServices.firstOrNull { it.name == empresa }!!.listImage
    }

    /**
     * Método para obtener las redes sociales asociadas a una empresa de servicios.
     * @param empresa Nombre de la empresa para la cual se obtienen las redes sociales.
     * @return Tripleta de cadenas con las URL de las redes sociales (Facebook, Instagram, WhatsApp).
     */
    override fun getRedes(empresa: String): Triple<String, String, String> {
        return listImageInfoServices.firstOrNull { it.name == empresa }!!.redes
    }

    /**
     * Método para obtener el título y el color asociado a un cantón específico.
     * @param canton Nombre del cantón para el cual se obtiene el título y color.
     * @param callback Callback que maneja el resultado del título y color.
     */
    override fun getColorTitle(canton: String, callback: (title: String, color: String) -> Unit) {
        when (canton) {
            CantonEnum.Orellana.name -> {
                callback.invoke(
                    "Empresas de servicios de " + CantonEnum.Orellana.canton,
                    "#00ff00"
                )
            }
            CantonEnum.Loreto.name -> {
                callback.invoke("Empresas de servicios de " + CantonEnum.Loreto.canton, "#00ffff")
            }
            CantonEnum.Sacha.name -> {
                callback.invoke("Empresas de servicios de " + CantonEnum.Sacha.canton, "#808080")
            }
            CantonEnum.Aguarico.name -> {
                callback.invoke(
                    "Empresas de servicios de " + CantonEnum.Aguarico.canton,
                    "#ff00ff"
                )
            }
        }
    }
}
