package com.rantinaya.about.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rantinaya.databinding.ItemAboutBinding
import com.rantinaya.about.data.AboutMember

class AboutAdapter (var list : MutableList<AboutMember>) : RecyclerView.Adapter<AboutAdapter.MyViewHolder>() {
    lateinit var openWeb : ((url : String) -> Unit)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemAboutBinding.inflate(
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

    inner class MyViewHolder(var binding : ItemAboutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : AboutMember, position: Int) {
            binding.apply {
                textName.text = item.name
                textEmail.text = "Correo : "+item.email
                textPhone.text = "Telefono :"+item.phone

                btnLink.setOnClickListener {
                    openWeb.invoke(item.links.second)
                }

                btnGit.setOnClickListener {
                    openWeb.invoke(item.links.third)
                }

                btnGmail.setOnClickListener {
                    openWeb.invoke(item.links.first)
                }
            }
        }
    }
}
