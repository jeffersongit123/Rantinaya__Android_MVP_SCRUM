package com.rantinaya.updateCarItemProduct.data

import android.content.Context
import com.rantinaya.room.database.AppDatabase
import com.rantinaya.room.entity.Car

interface UpdateItemCarProductInterface{
    interface UpdateItemCarCallback{
        fun onSuccess()
    }
    suspend fun updateItemCar(item : Car, callback : UpdateItemCarCallback, context: Context)
}

class UpdateItemCarProductService : UpdateItemCarProductInterface {
    override suspend fun updateItemCar(
        item: Car,
        callback: UpdateItemCarProductInterface.UpdateItemCarCallback,
        context: Context
    ) {
        val carDao = AppDatabase.getDatabase(context).carDao().updateItem(item)
        callback.onSuccess()
    }
}