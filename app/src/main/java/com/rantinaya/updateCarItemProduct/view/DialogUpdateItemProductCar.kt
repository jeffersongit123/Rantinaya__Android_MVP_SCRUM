package com.rantinaya.updateCarItemProduct.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import com.rantinaya.databinding.DialogUpdateItemCarProductBinding
import com.rantinaya.room.entity.Car
import com.rantinaya.updateCarItemProduct.UpdateCarItemProductContract
import com.rantinaya.updateCarItemProduct.data.UpdateItemCarProductService
import com.rantinaya.updateCarItemProduct.presenter.UpdateItemCarProductPresenter

class DialogUpdateItemProductCar (var mcontext: Context, var item : Car, var callbackUpdateCar : () -> Unit) : Dialog(mcontext),
    UpdateCarItemProductContract {
    private lateinit var binding: DialogUpdateItemCarProductBinding
    private val presenter = UpdateItemCarProductPresenter(this, UpdateItemCarProductService())
    init {
        initDialog()
    }

    private fun initDialog() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.setCancelable(true)
        binding = DialogUpdateItemCarProductBinding.inflate(LayoutInflater.from(context))
        this.setContentView(binding.root)
        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        this.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        presenter.setItem(item)
        binding.btnPlus.setOnClickListener { presenter.addCnt(binding.textTotal.text.toString()) }
        binding.btnRemove.setOnClickListener { presenter.minusCnt(binding.textTotal.text.toString()) }
        binding.btnUpdate.setOnClickListener { presenter.updateProduct(mcontext, binding.textTotal.text.toString())}
        binding.btnCancel.setOnClickListener { presenter.close()}
    }

    override fun showMessage(message: String) {
        Toast.makeText(mcontext, message, Toast.LENGTH_SHORT).show()
    }

    override fun close() {
        dismiss()
    }

    override fun addSuccess(message: String) {
        Toast.makeText(mcontext, message, Toast.LENGTH_SHORT).show()
        callbackUpdateCar.invoke()
        dismiss()
    }

    override fun setCnt(total: Int) {
        binding.textTotal.setText(total.toString())

    }

    override fun refreshCnt(item: Car) {
        binding.textTotal.setText(item.cnt.toString())
    }

    override fun setInfo(item: Car) {
        binding.textTotal.setText( item.cnt.toString())
    }

}