package com.rantinaya.addService.presenter

import android.content.Context
import com.rantinaya.addService.AddServiceContract
import com.rantinaya.addService.data.AddServiceService
import com.rantinaya.addService.data.AddServiceServiceInterface
import com.rantinaya.room.entity.Car
import com.rantinaya.room.entity.TypeCar
import com.rantinaya.services.data.ServiceByCanton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddServicePresenter(var addServiceView: AddServiceContract?, val service: AddServiceService) {
    private var item: Car = Car(
        key = 0, name = "", description = "", cnt = 0, unitPrice = 0.0, totalPrice = 0.0, type = TypeCar.SERVICE.value
    )

    fun setInfoItem(product: ServiceByCanton) {
        item.cnt = 0
        item.name = product.Servicio
        item.description = product.Descripción
        item.unitPrice = product.Precio.toDouble()
    }

    fun addCnt() {
        if(item.cnt + 1 > 8) {
            addServiceView?.showMessage("Solo se puede contratar hasta 8 horas de servicio.")
        } else {
            item.cnt += 1
            item.totalPrice = item.cnt * item.unitPrice
            addServiceView?.refreshCnt(item)
        }
    }

    fun minusCnt() {
        if (item.cnt - 1 >= 0) {
            item.cnt -= 1
            item.totalPrice = item.cnt * item.unitPrice

            addServiceView?.refreshCnt(item)
        } else {
            addServiceView?.showMessage("Por favor, seleccione una cantidad válida de horas.")
        }

    }

    fun close() {
        addServiceView?.close()
    }

    fun addService(context: Context) {
        if (item.cnt <= 0) {
            addServiceView?.showMessage("Por favor, seleccione una cantidad válida de horas.")
            return
        }

        if(item.cnt > 8) {
            addServiceView?.showMessage("Solo se puede contratar hasta 8 horas de servicio.")
            return
        }

        CoroutineScope(Dispatchers.IO).launch {
            service.addServiceToCar(
                item = item,
                object : AddServiceServiceInterface.AddServiceCallback {
                    override fun onSuccess() {
                        CoroutineScope(Dispatchers.Main).launch {
                            addServiceView?.addSuccess("Agregado correctamente al carrito")
                        }
                    }
                },
                context
            )
        }
    }

    fun fetchTotalListItemsCar(mcontext: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            service.fetchCtnCar(mcontext, object : AddServiceServiceInterface.CntCarCallback {
                override fun onSuccess(total: Int) {
                    CoroutineScope(Dispatchers.Main).launch {
                        addServiceView?.setCnt(total)
                    }
                }
            })
        }
    }
}