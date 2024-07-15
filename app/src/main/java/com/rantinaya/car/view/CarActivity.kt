package com.rantinaya.car.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.rantinaya.car.CarContract
import com.rantinaya.car.data.CarService
import com.rantinaya.car.data.TotalsCar
import com.rantinaya.car.presenter.CarPresenter
import com.rantinaya.databinding.ActivityCarBinding
import com.rantinaya.deleteAllCar.view.DialogDeleteAllCar
import com.rantinaya.deleteItemCar.view.DialogDeleteItemCar
import com.rantinaya.home.view.HomeActivity
import com.rantinaya.room.entity.Car
import com.rantinaya.updateCarItemProduct.view.DialogUpdateItemProductCar
import com.rantinaya.updateItemCarService.view.DialogUpdateItemServiceCar

class CarActivity : AppCompatActivity(), CarContract {
    private lateinit var binding : ActivityCarBinding
    private lateinit var adapter : AdapterCar
    private val presenter = CarPresenter(this, CarService())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAdapter()
        fetchCar()
        setListeners()
    }

    private fun setListeners() {
        binding.btnDeleteAll.setOnClickListener {
            presenter.openDeleteAll()
        }

        binding.btnProducts.setOnClickListener {
            presenter.openProducts()
        }
    }

    private fun fetchCar() {
        presenter.fetchCar(this)
    }

    private fun setAdapter() {
        adapter = AdapterCar(mutableListOf())
        binding.rvCar.adapter = adapter
        adapter.onDelete = {
            presenter.openDeleteItem(it)
        }
        adapter.onUpdate = {
            presenter.openUpdateItem(it)
        }
    }

    override fun setListCar(list: List<Car>) {
        binding.containerInfo.visibility = View.VISIBLE
        binding.containerEmptyCar.visibility = View.GONE
        binding.rvCar.visibility = View.VISIBLE
        binding.btnDeleteAll.visibility = View.VISIBLE
        adapter.list = list.toMutableList()
        adapter.update()
    }

    override fun openDeleteItem(item: Car) {
        DialogDeleteItemCar(this,item) {
            presenter.fetchCar(this)
        }.show()
    }

    override fun openUpdateItemService(item: Car) {
        DialogUpdateItemServiceCar(this,item) {
            presenter.fetchCar(this)
        }.show()
    }

    override fun openUpdateItemProduct(item: Car) {
        DialogUpdateItemProductCar(this,item) {
            presenter.fetchCar(this)
        }.show()
    }

    override fun openDeleteAll() {
        DialogDeleteAllCar(this) {
            presenter.fetchCar(this)
        }.show()
    }

    override fun setInfoCar(info: TotalsCar) {
        binding.textSubtotal.text = info.subTotal
        binding.textDiscount.text = info.discount
        binding.textTotalWithDiscount.text = info.subTotalWithDiscount
        binding.textIva.text = info.iva
        binding.textFinal.text = info.totalFinal
    }

    override fun showEmptyList() {
        binding.containerEmptyCar.visibility = View.VISIBLE
        binding.rvCar.visibility = View.GONE
        binding.btnDeleteAll.visibility = View.GONE
        binding.containerInfo.visibility = View.GONE
    }

    override fun openProducts() {
        val intent = Intent(this,HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}