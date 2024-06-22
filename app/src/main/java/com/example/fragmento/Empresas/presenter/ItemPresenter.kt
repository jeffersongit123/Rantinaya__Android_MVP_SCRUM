package com.example.fragmento.Empresas.presenter

import com.example.fragmento.Empresas.View.ItemView
import com.example.fragmento.Empresas.model.ItemRepository



class ItemPresenter(private val view: ItemView, private val repository: ItemRepository) {
    fun loadItems() {
        val items = repository.getItems()
        view.showItems(items)
    }
}
