package com.rantinaya.api

import com.rantinaya.login.data.LoginRequest
import com.rantinaya.login.data.LoginResponse
import com.rantinaya.products.data.ProductByCanton
import com.rantinaya.services.data.ServiceByCanton
import com.rantinaya.signup.data.SignUpRequest
import com.rantinaya.signup.data.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("/productos/{canton}")
    suspend fun getProducts(@Path("canton") canton: String): List<ProductByCanton>

    @GET("/servicios/{canton}")
    suspend fun getServices(@Path("canton") canton: String): List<ServiceByCanton>

    @POST("/register")
    suspend fun singUp(@Body request : SignUpRequest) : SignUpResponse

    @POST("/login")
    suspend fun login(@Body request : LoginRequest) : LoginResponse
}