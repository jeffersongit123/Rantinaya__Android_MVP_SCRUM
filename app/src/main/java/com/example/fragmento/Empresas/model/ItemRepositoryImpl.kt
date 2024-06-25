package com.example.fragmento.Empresas.model

import com.example.fragmento.Empresas.network.RetrofitClient
import com.example.fragmento.Empresas.network.ApiService


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ItemRepositoryImpl : ItemRepository {
    override fun getItems(): List<Item> {
        return listOf(
            Item(
                id = 1,
                title = "Masadicoffe",
                description = "Disfruta de un Café Robusta de Especialidad cultivado en Sistema Agrofor",
                owner = "Alejandra Evelyn Díaz Martínez",
                number = "593 980 166 540",
                email = "finca.masadi@hotmail.com",
                address = "",
                urlFacebook = "https://www.facebook.com/MasadiCoffeeAmazonia",
                urlInstagram = "https://www.instagram.com/masadicoffee",
                urlStore = "https://www.masadicoffee.com/",
                canton = "Francisco de Orellana",
                images = listOf("./MASADI_COFFEE/Logo.png", "./MASADI_COFFEE/1.png", "./MASADI_COFFEE/2.png", "./MASADI_COFFEE/3.png")
            ),
            Item(
                id = 2,
                title = "Vinos Onko",
                description = "Descubre el Espíritu de la Amazonía en Cada Sorbo",
                owner = "Yovanny Cumbicus Jimenez",
                number = "593 998 493 579",
                email = "yovannycj@hotmail.com",
                address = "Vía a Los Zorros, km 8., Francisco de Orellana, Ecuador",
                urlFacebook = "https://www.facebook.com/vinos.onko",
                urlInstagram = "https://www.instagram.com/vinos.onko/",
                urlStore = "https://vinosonko.com/",
                canton = "Francisco de Orellana",
                images = listOf("./VINOS_ONKO/main.jpg","./VINOS_ONKO/1.jpg", "./VINOS_ONKO/2.jpg", "./VINOS_ONKO/3.jpg")
            ),
            Item(
                id = 3,
                title = "Mueblería y Artesanías EDI",
                description = "Al Servicio de la ciudadanía",
                owner = "Edison Edwin Elizanlde Rufil",
                number = "593 993 094 014",
                email = "",
                address = "Oswaldo Guayasamín y los volcanes",
                urlFacebook = "https://www.facebook.com/profile.php?id=100054282290181",
                urlInstagram = "https://www.instagram.com/muebleriayartesaniasediho/",
                urlStore = "",
                canton = "Francisco de Orellana",
                images = listOf("")
            ),
            Item(
                id = 4,
                title = "Siambiplag",
                description = "Servicio de control de plagas",
                owner = "Manuel Enrique Elizalde Jaramillo",
                number = "593 999 414 031",
                email = "siambiplag@hotmail.com",
                address = "El Coca-Barrio Las Américas, Calle Ambato y Guano",
                urlFacebook = "https://www.facebook.com/profile.php?id=100093836955377",
                urlInstagram = "https://www.instagram.com/siambiplag/",
                urlStore = "",
                canton = "Francisco de Orellana",
                images = listOf("./SIAMBIPLAG/main.jpg","./SIAMBIPLAG/1.jpg", "./SIAMBIPLAG/2.jpg", "./SIAMBIPLAG/3.jpg")
            )

        )
    }
}

