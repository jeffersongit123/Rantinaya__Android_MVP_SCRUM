package com.rantinaya.addService.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import com.rantinaya.addService.AddServiceContract
import com.rantinaya.addService.data.AddServiceService
import com.rantinaya.addService.presenter.AddServicePresenter
import com.rantinaya.databinding.DialogAddServiceBinding
import com.rantinaya.room.entity.Car
import com.rantinaya.services.data.ServiceByCanton
import com.rantinaya.utils.modelBackUp.listImageInfoServices

class DialogAddService  (var mcontext: Context, var item : ServiceByCanton, var callbackOpenCar : () -> Unit) : Dialog(mcontext),
    AddServiceContract {
    private lateinit var binding: DialogAddServiceBinding
    private val presenter = AddServicePresenter(this, AddServiceService())
    init {
        initDialog()
    }

    private fun initDialog() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.setCancelable(true)
        binding = DialogAddServiceBinding.inflate(LayoutInflater.from(context))
        this.setContentView(binding.root)
        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        this.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        presenter.fetchTotalListItemsCar(mcontext)
        setInfoService()
        presenter.setInfoItem(item)
        binding.btnAdd.setOnClickListener {
            presenter.addService(mcontext)
        }

        binding.btnPlus.setOnClickListener {
            presenter.addCnt()
        }

        binding.btnRemove.setOnClickListener {
            presenter.minusCnt()
        }

        binding.btnBack.setOnClickListener {
            presenter.close()
        }

        binding.btnOpenCar.setOnClickListener {
            callbackOpenCar.invoke()
            presenter.close()
        }
    }

    private fun setInfoService() {
        binding.textTotal.text = "0"
        binding.textName.text = item.Servicio
        binding.textPrice.text = item.Precio + "$"
        binding.imgService.setImageResource(listImageInfoServices.firstOrNull { it.name == item.Servicio }!!.logo)
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
        binding.textTotal.text = item.cnt.toString()
    }

}