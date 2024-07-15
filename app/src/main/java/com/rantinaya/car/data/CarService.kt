package com.rantinaya.car.data

import android.content.Context
import com.rantinaya.room.database.AppDatabase
import com.rantinaya.room.entity.Car

interface CarServiceInterface {
    interface CntCarCallback {
        fun onSuccess(list : List<Car>)
    }

    interface InfoCarCallback {
        fun onSuccess(info : TotalsCar)
    }
    suspend fun fetchCar(context : Context,callback: CntCarCallback)
    suspend fun fetchInfoCar(context : Context, callback : InfoCarCallback)
}

class CarService : CarServiceInterface{
    override suspend fun fetchCar(context: Context, callback: CarServiceInterface.CntCarCallback) {
        val list = AppDatabase.getDatabase(context).carDao().getCar()
        callback.onSuccess(list)
    }

    override suspend fun fetchInfoCar(
        context: Context,
        callback: CarServiceInterface.InfoCarCallback
    ) {
        val discountRate = 10.0
        val ivaRate = 15.0

        val car = AppDatabase.getDatabase(context).carDao().getCar()
        val subTotal = car.sumOf { it.totalPrice }
        val discount = subTotal * discountRate / 100
        val subTotalWithDiscount = subTotal - discount
        val iva = subTotalWithDiscount * ivaRate / 100
        val totalFinal = subTotalWithDiscount + iva

        val totalsCar = TotalsCar(
            subTotal = "$subTotal$",
            discount = "$discount$",
            subTotalWithDiscount = "$subTotalWithDiscount$",
            iva = "$iva$",
            totalFinal = "$totalFinal$"
        )

        callback.onSuccess(totalsCar)
    }
}