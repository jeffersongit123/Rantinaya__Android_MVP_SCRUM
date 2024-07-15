package com.rantinaya.deleteItemCar.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import com.rantinaya.databinding.DialogDeleteItemBinding
import com.rantinaya.deleteItemCar.DeleteItemCarContract
import com.rantinaya.deleteItemCar.data.DeleteItemCarService
import com.rantinaya.deleteItemCar.presenter.DeletePresenter
import com.rantinaya.room.entity.Car

class DialogDeleteItemCar  (var mcontext: Context, var item : Car,
                            var callbackUpdateCar : () -> Unit) : Dialog(mcontext),
    DeleteItemCarContract {
    private lateinit var binding: DialogDeleteItemBinding
    private val presenter = DeletePresenter(this, DeleteItemCarService())
    init {
        initDialog()
    }

    private fun initDialog() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.setCancelable(true)
        binding = DialogDeleteItemBinding.inflate(LayoutInflater.from(context))
        this.setContentView(binding.root)
        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        this.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        binding.btnConfirm.setOnClickListener { presenter.deleteItem(item,mcontext) }
        binding.btnCancel.setOnClickListener { presenter.close()}
    }


    override fun showMessage(message: String) {
        Toast.makeText(mcontext, message, Toast.LENGTH_SHORT).show()
    }

    override fun onSuccessDelete() {
        callbackUpdateCar.invoke()
        dismiss()
    }


    override fun close() {
        dismiss()
    }
}