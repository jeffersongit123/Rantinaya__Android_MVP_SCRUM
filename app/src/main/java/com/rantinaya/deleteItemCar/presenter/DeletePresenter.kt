package com.rantinaya.deleteItemCar.presenter

import android.content.Context
import com.rantinaya.deleteItemCar.DeleteItemCarContract
import com.rantinaya.deleteItemCar.data.DeleteItemCarService
import com.rantinaya.deleteItemCar.data.DeleteItemServiceInterface
import com.rantinaya.room.entity.Car
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DeletePresenter(var view : DeleteItemCarContract?, var service : DeleteItemCarService) {
    fun deleteItem(item : Car , context: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            service.deleteItemToCar(item,object : DeleteItemServiceInterface.DeleteItemCallback {
                override fun onSuccess() {
                    CoroutineScope(Dispatchers.Main).launch {
                        view?.showMessage("Articulo eliminado con exito")
                        view?.onSuccessDelete()
                    }
                }
            }, context)
        }
    }

    fun close() {
        view?.close()
    }
}