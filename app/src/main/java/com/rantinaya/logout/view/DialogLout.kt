package com.rantinaya.logout.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import com.rantinaya.databinding.DialogLogoutBinding
import com.rantinaya.logout.LogoutContract
import com.rantinaya.logout.data.LogoutService
import com.rantinaya.logout.presenter.LogoutPresenter

class DialogLout(var mcontext: Context, var callbackLogout: () -> Unit) : Dialog(mcontext), LogoutContract {
    private lateinit var binding: DialogLogoutBinding
    private val presenter = LogoutPresenter(this, LogoutService())
    init {
        initDialog()
    }

    private fun initDialog() {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.setCancelable(true)
        binding = DialogLogoutBinding.inflate(LayoutInflater.from(context))
        this.setContentView(binding.root)
        this.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        this.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        binding.btnCancel.setOnClickListener {
            dismiss()
            presenter.onDestroy()
        }

        binding.btnLogout.setOnClickListener {
            presenter.logout(mcontext)
        }
    }

    override fun logout() {
        callbackLogout.invoke()
        presenter.onDestroy()
    }

    override fun showMessage(message: String) {
        Toast.makeText(mcontext, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {

    }
}