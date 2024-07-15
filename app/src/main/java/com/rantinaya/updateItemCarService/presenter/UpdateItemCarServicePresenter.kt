package com.rantinaya.updateItemCarService.presenter

import android.content.Context
import com.rantinaya.room.entity.Car
import com.rantinaya.updateItemCarService.UpdateCarItemServiceContract
import com.rantinaya.updateItemCarService.data.UpdateItemCarServiceService
import com.rantinaya.updateItemCarService.data.UpdateItemCarServiceInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateItemCarServicePresenter(var view: UpdateCarItemServiceContract?, val service: UpdateItemCarServiceService) {
    private lateinit var item: Car

    fun setItem(item: Car) {
        this.item = item
        view?.setInfo(item)
    }

    fun addCnt() {
        if(item.cnt + 1 > 8) {
            view?.showMessage("Solo se puede contratar hasta 8 horas de servicio.")
        } else {
            item.cnt += 1
            item.totalPrice = item.cnt * item.unitPrice
            view?.refreshCnt(item)
        }

    }

    fun minusCnt() {
        if (item.cnt - 1 >= 0) {
            item.cnt -= 1
        }
        item.totalPrice = item.cnt * item.unitPrice
        view?.refreshCnt(item)
    }

    fun close() {
        view?.close()
    }

    fun updateProduct(context: Context) {
        if (item.cnt <= 0) {
            view?.showMessage("Por favor, seleccione una cantidad válida de horas.")
            return
        }

        if(item.cnt > 8) {
            view?.showMessage("Solo se puede contratar hasta 8 horas de servicio.")
            return
        }
        CoroutineScope(Dispatchers.IO).launch {
            service.updateItemCar(
                item = item,
                object : UpdateItemCarServiceInterface.UpdateItemCarCallback {
                    override fun onSuccess() {
                        CoroutineScope(Dispatchers.Main).launch {
                            view?.addSuccess("Articulo actualizado con exito")
                        }
                    }
                },
                context
            )
        }
    }
}