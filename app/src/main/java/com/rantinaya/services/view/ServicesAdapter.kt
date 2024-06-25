package com.rantinaya.services.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rantinaya.databinding.ItemServicesBinding
import com.rantinaya.services.data.ServiceByCanton
import com.rantinaya.utils.modelBackUp.listImageInfoServices

class ServicesAdapter (var list : MutableList<ServiceByCanton>) : RecyclerView.Adapter<ServicesAdapter.MyViewHolder>() {
    lateinit  var onSelect : (position : Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemServicesBinding.inflate(
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

    inner class MyViewHolder(var binding : ItemServicesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : ServiceByCanton, position: Int) {
            binding.apply {
                textDescription.text = item.Descripción
                textName.text = item.Servicio
                try {
                    imgService.setImageResource(listImageInfoServices.firstOrNull { it.name == item.Servicio }!!.logo)
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
