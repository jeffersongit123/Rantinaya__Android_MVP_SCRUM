package com.rantinaya.addProduct.data

import android.content.Context
import com.rantinaya.room.database.AppDatabase
import com.rantinaya.room.entity.Car


interface AddProductServiceInterface{
    interface AddProductCallback {
        fun onSuccess()
    }
    interface CntCarCallback{
        fun onSuccess(total : Int)
    }
    suspend fun addProductToCar(item : Car,callback : AddProductCallback, context: Context)
    suspend fun fetchCtnCar(context: Context, callback: CntCarCallback)
}
class AddProductService : AddProductServiceInterface {
    override suspend fun addProductToCar(item: Car, callback : AddProductServiceInterface.AddProductCallback,context: Context) {
        val carDaoInsert = AppDatabase.getDatabase(context).carDao().insert(item)
        callback.onSuccess()
    }

    override suspend fun fetchCtnCar(
        context: Context,
        callback: AddProductServiceInterface.CntCarCallback
    ) {
        val total = AppDatabase.getDatabase(context).carDao().getCar()
        callback.onSuccess(total.size)
    }
}