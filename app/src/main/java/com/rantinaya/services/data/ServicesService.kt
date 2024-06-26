package com.rantinaya.services.data

import com.rantinaya.api.RetrofitClient
import com.rantinaya.utils.modelBackUp.listImageInfoServices
import com.rantinaya.utils.CantonEnum
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface ServicesServiceInterface {
    interface ServicesCallback {
        fun onSuccess(response : List<ServiceByCanton>)
        fun onFailure(message : String)
    }
    suspend fun fetchServices(canton : String, callback : ServicesCallback)
    fun getImagesService(empresa : String) : List<Int>
    fun getRedes(empresa : String) : Triple<String, String, String>
    fun getColorTitle(canton: String, callback: (title: String, color: String) -> Unit)

}
class ServicesService : ServicesServiceInterface {
    override suspend fun fetchServices(canton : String , callback: ServicesServiceInterface.ServicesCallback) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.apiService.getServices(canton.lowercase())
                withContext(Dispatchers.Main) {
                    callback.onSuccess(response)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    callback.onFailure(e.message ?: "Error desconocido")
                }
            }
        }
    }

    override fun getImagesService(empresa: String): List<Int> {
        return listImageInfoServices.firstOrNull { it.name == empresa }!!.listImage

    }

    override fun getRedes(empresa: String): Triple<String, String, String> {
        return listImageInfoServices.firstOrNull { it.name == empresa }!!.redes

    }

    override fun getColorTitle(canton: String, callback: (title: String, color: String) -> Unit) {
        when (canton) {
            CantonEnum.Orellana.name -> {
                callback.invoke(
                    "Empresas de servicios de " + CantonEnum.Orellana.canton,
                    "#00ff00"
                )
            }

            CantonEnum.Loreto.name -> {
                callback.invoke("Empresas de servicios de "  + CantonEnum.Loreto.canton, "#00ffff")

            }

            CantonEnum.Sacha.name -> {
                callback.invoke("Empresas de servicios de "  + CantonEnum.Sacha.canton, "#808080")

            }

            CantonEnum.Aguarico.name -> {
                callback.invoke(
                    "Empresas de servicios de "  + CantonEnum.Aguarico.canton,
                    "#ff00ff"
                )

            }
        }
    }


}