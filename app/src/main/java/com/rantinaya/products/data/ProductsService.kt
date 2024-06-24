package com.rantinaya.products.data

import com.rantinaya.api.RetrofitClient
import com.rantinaya.utils.modelBackUp.listImageInfoProducts
import com.rantinaya.utils.CantonEnum
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface ProductsServiceInterface {
    interface ProductsCallback {
        fun onSuccess(response: List<ProductByCanton>)
        fun onFailure(message: String)
    }

    suspend fun fetchProducts(canton: String, callback: ProductsCallback)
    fun getImagesProducts(empresa: String): List<Int>
    fun getRedes(empresa: String): Triple<String, String, String>
    fun getColorTitle(canton: String, callback: (title: String, color: String) -> Unit)
}

class ProductsService : ProductsServiceInterface {
    override suspend fun fetchProducts(
        canton: String,
        callback: ProductsServiceInterface.ProductsCallback
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.apiService.getProducts(canton.lowercase())
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

    override fun getImagesProducts(empresa: String): List<Int> {
        return listImageInfoProducts.firstOrNull { it.name == empresa }!!.listImage
    }

    override fun getRedes(empresa: String): Triple<String, String, String> {
        return listImageInfoProducts.firstOrNull { it.name == empresa }!!.redes
    }

    override fun getColorTitle(canton: String, callback: (title: String, color: String) -> Unit) {
        when (canton) {
            CantonEnum.Orellana.name -> {
                callback.invoke(
                    "Empresas de productos " + CantonEnum.Orellana.canton,
                    "#00ff00"
                )
            }

            CantonEnum.Loreto.name -> {
                callback.invoke("Empresas de productos " + CantonEnum.Loreto.canton, "#00ffff")

            }

            CantonEnum.Sacha.name -> {
                callback.invoke("Empresas de productos " + CantonEnum.Sacha.canton, "#808080")

            }

            CantonEnum.Aguarico.name -> {
                callback.invoke(
                    "Empresas de productos " + CantonEnum.Aguarico.canton,
                    "#ff00ff"
                )

            }
        }
    }
}
