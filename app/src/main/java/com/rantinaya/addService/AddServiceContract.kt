package com.rantinaya.addService

import com.rantinaya.room.entity.Car

interface AddServiceContract {
    fun showMessage(message : String)
    fun close()
    fun addSuccess(s: String)
    fun setCnt(total: Int)
    fun refreshCnt(item: Car)
}