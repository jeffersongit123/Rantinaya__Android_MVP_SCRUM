package com.rantinaya.car

import com.rantinaya.car.data.TotalsCar
import com.rantinaya.room.entity.Car

interface CarContract {
    fun setListCar(list: List<Car>)
    fun openDeleteItem(item: Car)
    fun openUpdateItemService(item: Car)
    fun openUpdateItemProduct(item: Car)
    fun openDeleteAll()
    fun setInfoCar(info: TotalsCar)
    fun showEmptyList()
    fun openProducts()
}