package com.rantinaya.car

import com.rantinaya.room.entity.Car

interface CarContract {
    fun setListCar(list: List<Car>)
    fun openDeleteItem(item: Car)
    fun openUpdateItemService(item: Car)
    fun openUpdateItemProduct(item: Car)
}