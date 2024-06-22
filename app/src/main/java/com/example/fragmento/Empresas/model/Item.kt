package com.example.fragmento.Empresas.model

data class Item(
    val id: Int,
    val title: String,
    val description: String,
    val owner: String,
    val number: String,
    val email: String,
    val address: String,
    val urlFacebook: String,
    val urlInstagram: String,
    val urlStore: String,
    val canton: String,
    val images: List<String>
)
