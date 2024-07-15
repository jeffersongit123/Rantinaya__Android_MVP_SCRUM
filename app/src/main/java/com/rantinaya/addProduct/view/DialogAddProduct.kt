package com.rantinaya.addProduct.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import com.rantinaya.addProduct.AddProductContract
import com.rantinaya.addProduct.data.AddProductService
import com.rantinaya.addProduct.presenter.AddProductPresenter
import com.rantinaya.databinding.DialogAddProductBinding
import com.rantinaya.products.data.ProductByCanton
import com.rantinaya.room.entity.Car
import com.rantinaya.utils.modelBackUp.listImageInfoProducts

class DialogAddProduct (var mcontext: Context, var item : ProductByCanton, var callbackOpenCar : () -> Unit) : Dialog(mcontext),
    AddProductContract {
    private lateinit var binding: DialogAddProductBinding
    private val presenter = AddProductPresenter(this, AddProductService())
    init {
        initDialog()
    }

    private fun initDialog() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.setCancelable(true)
        binding = DialogAddProductBinding.inflate(LayoutInflater.from(context))
        this.setContentView(binding.root)
        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        this.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        presenter.fetchTotalListItemsCar(mcontext)
        setInfoProduct()
        presenter.setInfoItem(item)
        binding.btnAdd.setOnClickListener {
            presenter.addProduct(mcontext, binding.textTotal.text.toString())
        }

        binding.btnPlus.setOnClickListener {
            presenter.addCnt(binding.textTotal.text.toString())
        }

        binding.btnRemove.setOnClickListener {
            presenter.minusCnt(binding.textTotal.text.toString())
        }

        binding.btnBack.setOnClickListener {
            presenter.close()
        }

        binding.btnOpenCar.setOnClickListener {
            callbackOpenCar.invoke()
            presenter.close()
        }
    }

    private fun setInfoProduct() {
        binding.textTotal.setText("0")
        binding.textName.text = item.Producto
        binding.textPrice.text = item.Precio + "$"
        binding.imgProduct.setImageResource(listImageInfoProducts.firstOrNull { it.name == item.Empresa }!!.logo)
    }

    override fun showMessage(message: String) {
        Toast.makeText(mcontext, message, Toast.LENGTH_SHORT).show()
    }


    override fun close() {
        dismiss()
    }

    override fun addSuccess(message: String) {
        Toast.makeText(mcontext, message, Toast.LENGTH_SHORT).show()
        dismiss()
    }

    override fun setCnt(total: Int) {
        binding.textTotalCar.text = total.toString()
    }

    override fun refreshCnt(item: Car) {
        binding.textPriceTotal.text = String.format("%.2f",item.totalPrice)
        binding.textTotal.setText(item.cnt.toString())
    }

}