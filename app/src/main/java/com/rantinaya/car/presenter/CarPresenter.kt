package com.rantinaya.car.presenter

import android.content.Context
import com.rantinaya.car.CarContract
import com.rantinaya.car.data.CarService
import com.rantinaya.car.data.CarServiceInterface
import com.rantinaya.car.data.TotalsCar
import com.rantinaya.room.entity.Car
import com.rantinaya.room.entity.TypeCar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CarPresenter(var view : CarContract?, val myService : CarService) {

    fun fetchCar(context : Context) {
        CoroutineScope(Dispatchers.IO).launch {
            myService.fetchCar(context, object : CarServiceInterface.CntCarCallback {
                override fun onSuccess(list: List<Car>) {
                    CoroutineScope(Dispatchers.Main).launch {
                        if(list.isEmpty()) {
                            view?.showEmptyList()
                        } else {
                            view?.setListCar(list)
                        }
                    }
                }
            })

            myService.fetchInfoCar(context, object : CarServiceInterface.InfoCarCallback {
                override fun onSuccess(info: TotalsCar) {
                    CoroutineScope(Dispatchers.Main).launch {
                        view?.setInfoCar(info)
                    }
                }
            })
        }
    }

    fun openDeleteItem(item: Car) {
        view?.openDeleteItem(item)
    }

    fun openUpdateItem(item: Car) {
        if(item.type == TypeCar.PRODUCT.value) {
            view?.openUpdateItemProduct(item)
        } else {
            view?.openUpdateItemService(item)
        }
    }

    fun openDeleteAll() {
        view?.openDeleteAll()
    }

    fun openProducts() {
        view?.openProducts()
    }
}