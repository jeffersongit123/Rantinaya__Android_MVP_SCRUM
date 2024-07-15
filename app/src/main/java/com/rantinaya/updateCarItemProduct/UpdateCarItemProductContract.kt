package com.rantinaya.updateCarItemProduct

import com.rantinaya.room.entity.Car

interface UpdateCarItemProductContract {
    fun showMessage(message : String)
    fun close()
    fun addSuccess(s: String)
    fun setCnt(total: Int)
    fun refreshCnt(item: Car)
    fun setInfo(item: Car)
}