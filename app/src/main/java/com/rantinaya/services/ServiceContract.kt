package com.rantinaya.services

import com.rantinaya.services.data.ServiceByCanton

interface ServiceContract {
    fun showLoading()
    fun hideLoading()
    fun onSuccess(service: List<ServiceByCanton>)
    fun onError(error: String)
    fun navigateToDetail(service : ServiceByCanton)
    fun setTitle(title : String)
    fun setColor(color : String)

}