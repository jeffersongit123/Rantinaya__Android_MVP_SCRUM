package com.example.fragmento.Empresas.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmento.R
import android.widget.Filter
import com.example.fragmento.Empresas.model.Item

class EmpresasAdapter(private var items: List<Item>) : RecyclerView.Adapter<EmpresasAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val description: TextView = view.findViewById(R.id.description)
        val owner: TextView = view.findViewById(R.id.owner)
        val address: TextView = view.findViewById(R.id.address)
        val canton: TextView = view.findViewById(R.id.canton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_empresas, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.description.text = item.description
        holder.owner.text = item.owner
        holder.address.text = item.address
        holder.canton.text = item.canton
    }

    override fun getItemCount(): Int = items.size

    fun updateItems(newItems: List<Item>) {
        items = newItems
        notifyDataSetChanged()
    }
}
