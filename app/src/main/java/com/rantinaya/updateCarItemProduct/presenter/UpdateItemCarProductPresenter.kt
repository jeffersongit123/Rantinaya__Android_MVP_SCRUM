package com.rantinaya.updateCarItemProduct.presenter

import android.content.Context
import com.rantinaya.room.entity.Car
import com.rantinaya.updateCarItemProduct.UpdateCarItemProductContract
import com.rantinaya.updateCarItemProduct.data.UpdateItemCarProductInterface
import com.rantinaya.updateCarItemProduct.data.UpdateItemCarProductService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateItemCarProductPresenter (var view: UpdateCarItemProductContract?, val service: UpdateItemCarProductService) {
    private lateinit var item: Car

    fun setItem(item: Car) {
        this.item = item
        view?.setInfo(item)
    }

    fun addCnt(cntInText: String) {
        if(cntInText.isNotEmpty()) {
            if(item.cnt != cntInText.toInt()) {
                item.cnt = cntInText.toInt()
                item.totalPrice = item.cnt * item.unitPrice
            }
        } else {
            item.cnt = 0
            item.totalPrice = item.cnt * item.unitPrice
        }
        if(item.cnt + 1 > 100) {
            view?.showMessage("Cantidad no disponible en el inventario.")
        } else {
            item.cnt += 1
            item.totalPrice = item.cnt * item.unitPrice
            view?.refreshCnt(item)
        }
    }

    fun minusCnt(cntInText: String) {
        if(cntInText.isNotEmpty()) {
            if(item.cnt != cntInText.toInt()) {
                item.cnt = cntInText.toInt()
                item.totalPrice = item.cnt * item.unitPrice
            }
        } else {
            item.cnt = 0
        }


        if (item.cnt - 1 >= 0) {
            item.cnt -= 1
            item.totalPrice = item.cnt * item.unitPrice

            view?.refreshCnt(item)
        } else {
            view?.showMessage("Cantidad no disponible en el inventario.")
        }
    }

    fun close() {
        view?.close()
    }

    fun updateProduct(context: Context, cntInText: String) {
        if(cntInText.isEmpty()) {
            view?.showMessage("Por favor, ingrese una cantidad  válida.")
            return
        }

        if(cntInText.toInt() != item.cnt) {
            item.cnt = cntInText.toInt()
            item.totalPrice = item.cnt * item.unitPrice

        }
        if (item.cnt <= 0) {
            view?.showMessage( "Por favor, ingrese una cantidad válida.")
            return
        }

        if(item.cnt > 100) {
            view?.showMessage( "Por favor, ingrese una cantidad válida.")
            return
        }

        CoroutineScope(Dispatchers.IO).launch {
            service.updateItemCar(
                item = item,
                object : UpdateItemCarProductInterface.UpdateItemCarCallback {
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