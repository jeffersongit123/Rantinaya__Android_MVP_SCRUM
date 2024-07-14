package com.rantinaya.addProduct.presenter

import android.content.Context
import com.rantinaya.addProduct.AddProductContract
import com.rantinaya.addProduct.data.AddProductService
import com.rantinaya.addProduct.data.AddProductServiceInterface
import com.rantinaya.products.data.ProductByCanton
import com.rantinaya.room.entity.Car
import com.rantinaya.room.entity.TypeCar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddProductPresenter(var addProductView: AddProductContract?, val service: AddProductService) {
    private var item: Car = Car(
        key = 0, name = "", description = "", cnt = 0, unitPrice = 0.0, totalPrice = 0.0, type = TypeCar.PRODUCT.value
    )

    fun setInfoItem(product: ProductByCanton) {
        item.cnt = 0
        item.name = product.Producto
        item.description = product.Descripción
        item.unitPrice = product.Precio.toDouble()
        item.totalPrice = item.cnt * item.unitPrice
    }

    fun addCnt(cntInText: String) {
        if(cntInText.isNotEmpty()) {
            if(item.cnt != cntInText.toInt()) {
                item.cnt = cntInText.toInt()
                item.totalPrice = item.cnt * item.unitPrice
            }
        } else {
            item.cnt = 0
            item.totalPrice = item.cnt * item.unitPrice
        }
        if(item.cnt + 1 > 100) {
            addProductView?.showMessage("Cantidad no disponible en el inventario.")
        } else {
            item.cnt += 1
            item.totalPrice = item.cnt * item.unitPrice
            addProductView?.refreshCnt(item)
        }

    }

    fun minusCnt(cntInText: String) {
        if(cntInText.isNotEmpty()) {
            if(item.cnt != cntInText.toInt()) {
                item.cnt = cntInText.toInt()
            }
        } else {
            item.cnt = 0
        }


        if (item.cnt - 1 >= 0) {
            item.cnt -= 1
            item.totalPrice = item.cnt * item.unitPrice

            addProductView?.refreshCnt(item)
        } else {
            addProductView?.showMessage("Cantidad no disponible en el inventario.")
        }
    }

    fun close() {
        addProductView?.close()
    }

    fun addProduct(context: Context, cntInText: String) {
        if(cntInText.isEmpty()) {
            addProductView?.showMessage("Por favor, ingrese una cantidad  válida.")
            return
        }

        if(cntInText.toInt() != item.cnt) {
            item.cnt = cntInText.toInt()
            item.totalPrice = item.cnt * item.unitPrice
        }
        if (item.cnt <= 0) {
            addProductView?.showMessage( "Por favor, ingrese una cantidad válida.")
            return
        }

        if(item.cnt > 100) {
            addProductView?.showMessage( "Por favor, ingrese una cantidad válida.")
            return
        }

        CoroutineScope(Dispatchers.IO).launch {
            service.addProductToCar(
                item = item,
                object : AddProductServiceInterface.AddProductCallback {
                    override fun onSuccess() {
                        CoroutineScope(Dispatchers.Main).launch {
                            addProductView?.addSuccess("Agregado correctamente al carrito")
                        }
                    }
                },
                context
            )
        }
    }

    fun fetchTotalListItemsCar(mcontext: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            service.fetchCtnCar(mcontext, object : AddProductServiceInterface.CntCarCallback {
                override fun onSuccess(total: Int) {
                    CoroutineScope(Dispatchers.Main).launch {
                        addProductView?.setCnt(total)
                    }
                }
            })
        }
    }
}