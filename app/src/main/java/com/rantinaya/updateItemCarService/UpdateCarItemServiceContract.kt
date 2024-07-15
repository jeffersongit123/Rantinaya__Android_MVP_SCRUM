package com.rantinaya.updateItemCarService

import com.rantinaya.room.entity.Car

interface UpdateCarItemServiceContract {
    fun showMessage(message : String)
    fun close()
    fun addSuccess(s: String)
    fun setCnt(total: Int)
    fun refreshCnt(item: Car)
    fun setInfo(item: Car)
}