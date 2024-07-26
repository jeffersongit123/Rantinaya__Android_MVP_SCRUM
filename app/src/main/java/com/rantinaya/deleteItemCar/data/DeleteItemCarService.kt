package com.rantinaya.deleteItemCar.data

import android.content.Context
import com.rantinaya.room.database.AppDatabase
import com.rantinaya.room.entity.Car


interface DeleteItemServiceInterface{
    interface DeleteItemCallback {
        fun onSuccess()
    }
    suspend fun deleteItemToCar(item : Car, callback : DeleteItemCallback, context : Context)
}
class DeleteItemCarService : DeleteItemServiceInterface {
    override suspend fun deleteItemToCar(
        item: Car,
        callback: DeleteItemServiceInterface.DeleteItemCallback,
        context: Context
    ) {
        val carDao = AppDatabase.getDatabase(context).carDao().deleteItem(item)
        callback.onSuccess()
    }
}