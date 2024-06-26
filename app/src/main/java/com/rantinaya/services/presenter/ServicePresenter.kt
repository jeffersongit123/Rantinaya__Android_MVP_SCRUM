package com.rantinaya.services.presenter

import com.rantinaya.services.data.ServiceByCanton
import com.rantinaya.services.ServiceContract
import com.rantinaya.services.data.ServicesService
import com.rantinaya.services.data.ServicesServiceInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ServicePresenter(var serviceView: ServiceContract?) {
    private var listServices = mutableListOf<ServiceByCanton>()
    private val service = ServicesService()
    fun fetchServices(canton: String) {
        service.getColorTitle(canton, callback = {title, color ->
            serviceView?.setTitle(title)
            serviceView?.setColor(color)
        })
        serviceView?.showLoading()
        CoroutineScope(Dispatchers.IO).launch {
            service.fetchServices(
                canton.lowercase(),
                object : ServicesServiceInterface.ServicesCallback {
                    override fun onSuccess(response: List<ServiceByCanton>) {
                        serviceView?.hideLoading()
                        listServices = response.toMutableList()
                        serviceView?.onSuccess(response)
                    }

                    override fun onFailure(message: String) {
                        serviceView?.hideLoading()
                        serviceView?.onError(message)
                    }
                })
        }
    }

    fun navigateToDetail(position: Int) {
        serviceView?.navigateToDetail(listServices[position])
    }

    fun onDestroy() {
        serviceView = null
    }
}