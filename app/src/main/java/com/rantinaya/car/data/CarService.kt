package com.rantinaya.car.data

import android.content.Context
import com.rantinaya.room.database.AppDatabase
import com.rantinaya.room.entity.Car

interface CarServiceInterface {
    interface CntCarCallback {
        fun onSuccess(list : List<Car>)
    }

    suspend fun fetchCar(context : Context,callback: CntCarCallback)
}

class CarService : CarServiceInterface{
    override suspend fun fetchCar(context: Context, callback: CarServiceInterface.CntCarCallback) {
        val list = AppDatabase.getDatabase(context).carDao().getCar()
        callback.onSuccess(list)
    }
}