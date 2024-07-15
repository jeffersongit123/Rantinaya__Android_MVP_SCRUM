package com.rantinaya.deleteAllCar.data

import android.content.Context
import com.rantinaya.room.database.AppDatabase
import com.rantinaya.room.entity.Car

interface DeleteAllServiceInterface{
    interface DeleteAllCallback {
        fun onSuccess()
    }
    suspend fun deleteAllCar(callback : DeleteAllCallback, context : Context)
}
class DeleteAllCarService : DeleteAllServiceInterface {
    override suspend fun deleteAllCar(
        callback: DeleteAllServiceInterface.DeleteAllCallback,
        context: Context
    ) {
        val carDao = AppDatabase.getDatabase(context).carDao().deleteAll()
        callback.onSuccess()
    }
}