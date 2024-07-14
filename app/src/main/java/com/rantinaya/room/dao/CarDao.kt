package com.rantinaya.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.rantinaya.room.entity.Car

@Dao
interface CarDao {

    @Insert
     fun insert(item : Car)

    @Query("SELECT * FROM car_table")
     fun getCar() : List<Car>

    @Delete
     fun deleteItem(item : Car)

    @Update
     fun updateItem(item : Car)
}