package com.rantinaya.utils.modelBackUp

import com.rantinaya.R

class ImagesInfo(
    var name : String,
    var logo : Int,
    var listImage : List<Int>,
    var redes : Triple<String,String, String>
)

var listImageInfoProducts = listOf(
    ImagesInfo(
        name = "Sacha Ayllu",
        logo = R.drawable.sasha_ayllu_logo,
        listImage = listOf(R.drawable.sasha_ayllu_image_1),
        redes = Triple("https://www.facebook.com/SachaylluEcuador","https://www.instagram.com/sachaylluecuador/","https://wa.pe/9bNbDZFkoX")
    ),
    ImagesInfo(
        name = "Sacha Fit",
        logo = R.drawable.sasha_fit_logo,
        listImage = listOf(R.drawable.sasha_fit_image_1, R.drawable.sasha_fit_image_2),
        redes = Triple("https://www.facebook.com/SachaFitEcuador","https://www.instagram.com/sachafitecuador/","https://wa.pe/nEskoGJMIF")
    ),
    ImagesInfo(
        name = "Asociaci\u00f3n artesanal AWEIDI del Yasun\u00ed",
        logo = R.drawable.aweidi_logo,
        listImage = listOf(R.drawable.aweidi_image_1),
        redes = Triple("https://www.facebook.com/aweididelyasuni","https://www.instagram.com/aweidi_del_yasuni/","https://wa.pe/S2jjQiO3Cp")
    ),
    ImagesInfo(
        name = "Frutos Mundo",
        logo = R.drawable.frutos_mundo_logo,
        listImage = listOf(R.drawable.frutos_mundo_image_1),
        redes = Triple("","","https://wa.pe/NAtSXlxnqr")
    ),
    ImagesInfo(
        name = "Warmi-Beer & Warmi-Power",
        logo = R.drawable.warmi_beer_logo,
        listImage = listOf(R.drawable.warmi_beer_image_1),
        redes = Triple("https://www.facebook.com/warmibeer","https://www.instagram.com/warmibeer/","https://wa.pe/OFlVCyGgYs")
    ),
    ImagesInfo(
        name = "Masadicoffe",
        logo = R.drawable.masadicofee_logo,
        listImage = listOf(R.drawable.masadicofee_image_1),
        redes = Triple("https://www.facebook.com/MasadiCoffeeAmazonia","https://www.instagram.com/masadicoffee","https://wa.pe/wXcpfRhCk1")
    ),
    ImagesInfo(
        name = "Vinos Onko",
        logo = R.drawable.onko_logo,
        listImage = listOf(R.drawable.onko_image_1),
        redes = Triple("https://www.facebook.com/vinos.onko","https://www.instagram.com/vinos.onko/","https://wa.link/ncoxs0")
    ),
    ImagesInfo(
        name = "Gelatinas de Raquel",
        logo = R.drawable.gelatinasraquel_logo,
        listImage = listOf(R.drawable.gelatinasraquel_image_1,R.drawable.gelatinasraquel_image_2),
        redes = Triple("https://www.facebook.com/profile.php?id=100063497861619","https://www.instagram.com/gelatinas_de_raquel/","https://wa.pe/EGxkHOB8bl")
    ),
    ImagesInfo(
        name = "Asoproafy-Waeme",
        logo = R.drawable.asoproaf_logo,
        listImage = listOf(R.drawable.asoproaf_image_1,R.drawable.asoproaf_image_2),
        redes = Triple("https://www.facebook.com/profile.php?id=100063757140632","https://www.instagram.com/asoproafy_waeme","https://wa.pe/9Nr5l4JYWL")
    ),
    ImagesInfo(
        name = "Apaika",
        logo = R.drawable.apaika_logo,
        listImage = listOf(R.drawable.apaika_image_1,R.drawable.apaika_image_2,R.drawable.apaika_image_3),
        redes = Triple("https://www.facebook.com/hongosapaika","https://www.instagram.com/apaika.hongosdelaselva","https://wa.pe/wXcpfRhCk1")
    ),
    ImagesInfo(
        name = "Yupa Land",
        logo = R.drawable.yupa_logo,
        listImage = listOf(R.drawable.yupa_logo),
        redes = Triple("https://www.facebook.com/yupaland.ec","https://www.instagram.com/yupaland.ec/","https://wa.pe/pH0LijFRJ3")
    ),
    ImagesInfo(
        name = "S\u00e1nchez Escaparate",
        logo = R.drawable.sanchezescaparate_logo,
        listImage = listOf(R.drawable.sanchezescaparate_image_1, R.drawable.sanchezescaparate_image_2 , R.drawable.sanchezescaparate_image_3, R.drawable.sanchezescaparate_image_4),
        redes = Triple("https://www.facebook.com/escaparate.sanchez","https://www.instagram.com/escaparate.sanchez/","https://wa.pe/BdtZjneizd")
    ),
    ImagesInfo(
        name = "Cafeter\u00eda Do\u00f1a P\u00eda",
        logo = R.drawable.donapia_logo,
        listImage = listOf(R.drawable.donapia_image_1, R.drawable.donapia_image_2 , R.drawable.donapia_image_3, R.drawable.donapia_image_4),
        redes = Triple("https://www.facebook.com/Cafeteriadonapia","https://www.instagram.com/apaika.hongosdelaselva","https://wa.link/967xua")
    ),
)

var listImageInfoServices = listOf(
    ImagesInfo(
        name = "Siambiplag Plus",
        logo = R.drawable.siam_logo,
        listImage = listOf(R.drawable.siam_logo),
        redes = Triple("https://www.facebook.com/profile.php?id=100093836955377","https://www.instagram.com/siambiplag/","https://wa.pe/xqA44M1Maf")
    ),
    ImagesInfo(
        name = "Experiencia Gastron\u00f3mica en la Selva",
        logo = R.drawable.madera_logo,
        listImage = listOf(R.drawable.madera_image_1),
        redes = Triple("https://www.facebook.com/profile.php?id=61553177210905","https://www.instagram.com/restaurant_madera_y_piedra/","https://wa.pe/rRR0eTpyRB")
    ),
    ImagesInfo(
        name = "Servicio de Limpieza Profesional",
        logo = R.drawable.asociacion_logo,
        listImage = listOf(R.drawable.asociacion_image_1),
        redes = Triple("https://www.facebook.com/AserlimebpevEC","https://www.instagram.com/aserlimebpev/","https://wa.pe/XC2wVMBf6k")
    ),
    ImagesInfo(
        name = "Artesan\u00edas AWAK MAKI",
        logo = R.drawable.awak_logo,
        listImage = listOf(R.drawable.awak_image_1, R.drawable.awak_image_2),
        redes = Triple("https://www.facebook.com/asoawakmaki","https://www.instagram.com/asoproawakmaki/","https://wa.pe/hP49bcfxdF")
    ),
    ImagesInfo(
        name = "Experiencia Cultural SHUAR JEMPE",
        logo = R.drawable.shuar_logo,
        listImage = listOf(R.drawable.shuar_image_1),
        redes = Triple("https://www.facebook.com/profile.php?id=61554703256013&locale=es_LA","https://www.instagram.com/shuar_jempe/","")
    ),
    ImagesInfo(
        name = "Artesan\u00edas Giino",
        logo = R.drawable.turistico_logo,
        listImage = listOf(R.drawable.turistico_image_1),
        redes = Triple("https://www.facebook.com/profile.php?id=61554703256013&locale=es_LA","https://www.instagram.com/shuar_jempe/","")
    ),
)
