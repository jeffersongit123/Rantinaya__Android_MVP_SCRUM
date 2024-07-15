package com.rantinaya.deleteAllCar.presenter

import android.content.Context
import com.rantinaya.deleteAllCar.DeleteAllCarContract
import com.rantinaya.deleteAllCar.data.DeleteAllCarService
import com.rantinaya.deleteAllCar.data.DeleteAllServiceInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DeleteAllCarPresenter(var view : DeleteAllCarContract?,var service : DeleteAllCarService) {
    fun deleteAll(context : Context) {
        CoroutineScope(Dispatchers.IO).launch {
            service.deleteAllCar(object : DeleteAllServiceInterface.DeleteAllCallback {
                override fun onSuccess() {
                    CoroutineScope(Dispatchers.Main).launch {
                        view?.showMessage("Carrito de compras vaciado con éxito")
                        view?.onSuccessDelete()
                    }
                }
            },context,)
        }
    }
    fun close() {
        view?.close()
    }
}