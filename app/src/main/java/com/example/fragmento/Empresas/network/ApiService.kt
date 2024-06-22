package com.example.fragmento.Empresas.network

import com.example.fragmento.Empresas.model.Item
import com.example.fragmento.Empresas.model.RedSocial
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("api/empresa/{id}/productos")
    fun getProductos(@Path("id") id: Int): Call<List<Item>>

    @GET("api/empresa/canton/{cantonId}")
    fun getEmpresasByCanton(@Path("cantonId") cantonId: Int): Call<List<Item>>

    @GET("api/empresa/{id}/redes-sociales")
    fun getRedesSociales(@Path("id") id: Int): Call<List<RedSocial>>
}