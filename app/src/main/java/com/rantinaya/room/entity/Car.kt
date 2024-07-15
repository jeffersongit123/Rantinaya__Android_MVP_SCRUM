package com.rantinaya.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "car_table")
data class Car(
    @PrimaryKey(autoGenerate = true)
    var key : Int = 0,// room key
    var name: String,
    var description : String,
    var cnt : Int,
    var unitPrice : Double,
    var totalPrice : Double,
    var type : String
)

enum class TypeCar(var value : String){
    PRODUCT("Producto"),
    SERVICE("Servicio")
}