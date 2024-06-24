package com.rantinaya.products.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rantinaya.databinding.ItemProductsBinding
import com.rantinaya.products.data.ProductByCanton
import com.rantinaya.utils.modelBackUp.listImageInfoProducts

class ProductsAdapter(var list : MutableList<ProductByCanton>) : RecyclerView.Adapter<ProductsAdapter.MyViewHolder>() {
    lateinit  var onSelect : (position : Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemProductsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setIsRecyclable(false)

        holder.bind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    fun update() {
        notifyDataSetChanged()
    }

    inner class MyViewHolder(var binding : ItemProductsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : ProductByCanton, position: Int) {
            binding.apply {
                textDescription.text = item.Descripción
                try {
                    imgProduct.setImageResource(listImageInfoProducts.firstOrNull { it.name == item.Empresa }!!.logo)
                }catch (e : Exception) {
                    println(e.message)
                }
                btnSelect.setOnClickListener {
                    onSelect.invoke(position)
                }
            }
        }
    }
}
