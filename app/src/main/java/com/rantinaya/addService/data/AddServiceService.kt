package com.rantinaya.addService.data

import android.content.Context
import com.rantinaya.room.database.AppDatabase
import com.rantinaya.room.entity.Car

interface AddServiceServiceInterface{
    interface AddServiceCallback {
        fun onSuccess()
    }
    interface CntCarCallback{
        fun onSuccess(total : Int)
    }
    suspend fun addServiceToCar(item : Car,callback : AddServiceCallback, context: Context)
    suspend fun fetchCtnCar(context: Context, callback: CntCarCallback)
}
class AddServiceService : AddServiceServiceInterface {
    override suspend fun addServiceToCar(item: Car, callback : AddServiceServiceInterface.AddServiceCallback,context: Context) {
        val carDaoInsert = AppDatabase.getDatabase(context).carDao().insert(item)
        callback.onSuccess()
    }

    override suspend fun fetchCtnCar(
        context: Context,
        callback: AddServiceServiceInterface.CntCarCallback
    ) {
        val total = AppDatabase.getDatabase(context).carDao().getCar()
        callback.onSuccess(total.size)
    }
}