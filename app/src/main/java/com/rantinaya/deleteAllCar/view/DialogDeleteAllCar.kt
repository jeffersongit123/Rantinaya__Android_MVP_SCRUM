package com.rantinaya.deleteAllCar.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import com.rantinaya.databinding.DialogDeleteAllCarBinding
import com.rantinaya.databinding.DialogDeleteItemBinding
import com.rantinaya.deleteAllCar.DeleteAllCarContract
import com.rantinaya.deleteAllCar.data.DeleteAllCarService
import com.rantinaya.deleteAllCar.presenter.DeleteAllCarPresenter
import com.rantinaya.deleteItemCar.DeleteItemCarContract
import com.rantinaya.deleteItemCar.data.DeleteItemCarService
import com.rantinaya.deleteItemCar.presenter.DeletePresenter
import com.rantinaya.room.entity.Car

class DialogDeleteAllCar  (var mcontext: Context,
                           var callbackUpdateCar : () -> Unit) : Dialog(mcontext),
    DeleteAllCarContract {
    private lateinit var binding: DialogDeleteAllCarBinding
    private val presenter = DeleteAllCarPresenter(this, DeleteAllCarService())
    init {
        initDialog()
    }

    private fun initDialog() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.setCancelable(true)
        binding = DialogDeleteAllCarBinding.inflate(LayoutInflater.from(context))
        this.setContentView(binding.root)
        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        this.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        binding.btnConfirm.setOnClickListener { presenter.deleteAll(mcontext) }
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