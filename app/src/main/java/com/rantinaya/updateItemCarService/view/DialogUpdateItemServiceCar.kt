package com.rantinaya.updateItemCarService.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import com.rantinaya.databinding.DialogUpdateItemCarServiceBinding
import com.rantinaya.room.entity.Car
import com.rantinaya.updateItemCarService.UpdateCarItemServiceContract
import com.rantinaya.updateItemCarService.data.UpdateItemCarServiceService
import com.rantinaya.updateItemCarService.presenter.UpdateItemCarServicePresenter

class DialogUpdateItemServiceCar (var mcontext: Context, var item : Car, var callbackUpdateCar : () -> Unit) : Dialog(mcontext),
    UpdateCarItemServiceContract {
    private lateinit var binding: DialogUpdateItemCarServiceBinding
    private val presenter = UpdateItemCarServicePresenter(this, UpdateItemCarServiceService())
    init {
        initDialog()
    }

    private fun initDialog() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.setCancelable(true)
        binding = DialogUpdateItemCarServiceBinding.inflate(LayoutInflater.from(context))
        this.setContentView(binding.root)
        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        this.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        presenter.setItem(item)
        binding.btnPlus.setOnClickListener { presenter.addCnt() }
        binding.btnRemove.setOnClickListener { presenter.minusCnt() }
        binding.btnUpdate.setOnClickListener { presenter.updateProduct(mcontext)}
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
        binding.textTotal.text = total.toString()

    }

    override fun refreshCnt(item: Car) {
        binding.textTotal.text = item.cnt.toString()
    }

    override fun setInfo(item: Car) {
        binding.textTotal.text = item.cnt.toString()
    }

}