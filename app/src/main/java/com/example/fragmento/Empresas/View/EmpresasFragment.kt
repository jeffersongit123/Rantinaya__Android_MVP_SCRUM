package com.example.fragmento.Empresas.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmento.Empresas.model.Item
import com.example.fragmento.Empresas.presenter.ItemPresenter
import com.example.fragmento.Empresas.model.ItemRepositoryImpl
import com.example.fragmento.Empresas.model.RedSocial
import com.example.fragmento.R
import androidx.appcompat.widget.SearchView


class EmpresasFragment : Fragment(), ItemView {

    private lateinit var presenter: ItemPresenter
    private lateinit var adapter: EmpresasAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_empresas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = ItemPresenter(this, ItemRepositoryImpl())
        adapter = EmpresasAdapter(listOf())

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewEmpresas)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        presenter.loadItems()
    }

    override fun showItems(items: List<Item>) {
        adapter.updateItems(items)
    }
}