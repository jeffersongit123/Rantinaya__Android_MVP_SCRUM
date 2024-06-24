package com.rantinaya.services.presenter

import com.rantinaya.services.data.ServiceByCanton
import com.rantinaya.services.ServiceContract
import com.rantinaya.services.data.ServicesService
import com.rantinaya.services.data.ServicesServiceInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Presenter para manejar la lógica de presentación de servicios.
 * @param serviceView Vista que implementa la interfaz ServiceContract para comunicarse con la vista.
 */
class ServicePresenter(var serviceView: ServiceContract?) {
    private var listServices = mutableListOf<ServiceByCanton>()
    private val service = ServicesService()

    /**
     * Método para obtener servicios basados en un cantón específico.
     * @param canton Nombre del cantón para filtrar los servicios.
     */
    fun fetchServices(canton: String) {
        // Obtener el título y color asociados al cantón y actualizar la vista.
        service.getColorTitle(canton, callback = { title, color ->
            serviceView?.setTitle(title)
            serviceView?.setColor(color)
        })

        // Mostrar el indicador de carga en la vista.
        serviceView?.showLoading()

        // Lanzar una corrutina en el hilo de fondo para obtener los servicios.
        CoroutineScope(Dispatchers.IO).launch {
            service.fetchServices(
                canton.lowercase(),
                object : ServicesServiceInterface.ServicesCallback {
                    override fun onSuccess(response: List<ServiceByCanton>) {
                        // Ocultar el indicador de carga y actualizar la lista de servicios.
                        serviceView?.hideLoading()
                        listServices = response.toMutableList()
                        serviceView?.onSuccess(response)
                    }

                    override fun onFailure(message: String) {
                        // Ocultar el indicador de carga y manejar el error.
                        serviceView?.hideLoading()
                        serviceView?.onError(message)
                    }
                })
        }
    }

    /**
     * Método para navegar a los detalles de un servicio específico.
     * @param position Posición del servicio en la lista.
     */
    fun navigateToDetail(position: Int) {
        serviceView?.navigateToDetail(listServices[position])
    }

    /**
     * Método para limpiar la referencia de la vista cuando la actividad o fragmento es destruido.
     */
    fun onDestroy() {
        serviceView = null
    }
}
