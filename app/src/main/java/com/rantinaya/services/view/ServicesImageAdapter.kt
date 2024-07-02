package com.rantinaya.services.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rantinaya.databinding.ItemImageBinding

class ServicesImageAdapter (var list : MutableList<Int>) : RecyclerView.Adapter<ServicesImageAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemImageBinding.inflate(
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

    inner class MyViewHolder(var binding : ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Int, position: Int) {
            binding.apply {
                imgProduct.setImageResource(item)
            }
        }
    }
}
