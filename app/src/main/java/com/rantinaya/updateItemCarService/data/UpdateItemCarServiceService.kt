package com.rantinaya.updateItemCarService.data

import android.content.Context
import com.rantinaya.room.database.AppDatabase
import com.rantinaya.room.entity.Car

interface UpdateItemCarServiceInterface{
    interface UpdateItemCarCallback{
        fun onSuccess()
    }
    suspend fun updateItemCar(item : Car, callback : UpdateItemCarCallback, context: Context)
}

class UpdateItemCarServiceService : UpdateItemCarServiceInterface {
    override suspend fun updateItemCar(
        item: Car,
        callback: UpdateItemCarServiceInterface.UpdateItemCarCallback,
        context: Context
    ) {
        val carDao = AppDatabase.getDatabase(context).carDao().updateItem(item)
        callback.onSuccess()
    }
}