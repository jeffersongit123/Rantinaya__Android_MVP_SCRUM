package com.rantinaya.car.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rantinaya.databinding.ItemCarBinding
import com.rantinaya.databinding.ItemServicesBinding
import com.rantinaya.room.entity.Car
import com.rantinaya.room.entity.TypeCar
import com.rantinaya.services.data.ServiceByCanton
import com.rantinaya.services.view.ServicesAdapter
import com.rantinaya.utils.modelBackUp.listImageInfoServices

class AdapterCar (var list : MutableList<Car>) : RecyclerView.Adapter<AdapterCar.MyViewHolder>() {
    lateinit  var onDelete : (position : Car) -> Unit
    lateinit var onUpdate : (position : Car) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemCarBinding.inflate(
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

    inner class MyViewHolder(var binding : ItemCarBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Car, position: Int) {
            binding.apply {
               textType.text = item.type
                textName.text = item.name
                textCnt.text = item.cnt.toString()
                textCntHr.text = item.cnt.toString()
                textTotal.text = String.format("%.2f",item.totalPrice)+"$"
                if(item.type == TypeCar.PRODUCT.value) {
                    containerCntProduct.visibility = View.VISIBLE
                    containerCntService.visibility = View.GONE
                } else {
                    containerCntProduct.visibility = View.GONE
                    containerCntService.visibility = View.VISIBLE
                }
                btnDelete.setOnClickListener {
                    onDelete.invoke(item)
                }

                btnUpdate.setOnClickListener {
                    onUpdate.invoke(item)
                }
            }
        }
    }
}
