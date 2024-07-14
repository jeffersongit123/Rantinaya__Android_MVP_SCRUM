package com.rantinaya.car.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rantinaya.car.CarContract
import com.rantinaya.car.data.CarService
import com.rantinaya.car.presenter.CarPresenter
import com.rantinaya.databinding.ActivityCarBinding
import com.rantinaya.deleteItemCar.view.DialogDeleteItemCar
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
}