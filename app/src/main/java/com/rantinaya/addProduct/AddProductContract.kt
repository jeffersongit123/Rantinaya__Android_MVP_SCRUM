package com.rantinaya.addProduct

import com.rantinaya.room.entity.Car

interface AddProductContract {
    fun showMessage(message : String)
    fun close()
    fun addSuccess(s: String)
    fun setCnt(total: Int)
    fun refreshCnt(item: Car)
}