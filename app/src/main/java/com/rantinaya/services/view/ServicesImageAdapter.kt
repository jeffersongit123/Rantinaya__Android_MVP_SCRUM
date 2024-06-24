package com.rantinaya.services.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rantinaya.databinding.ItemImageBinding

/**
 * Adaptador para manejar la lista de imágenes en un RecyclerView.
 * @param list Lista mutable de Int que contiene los recursos de imágenes a mostrar.
 */
class ServicesImageAdapter(var list: MutableList<Int>) :
    RecyclerView.Adapter<ServicesImageAdapter.MyViewHolder>() {

    /**
     * Crea y devuelve una instancia de MyViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    /**
     * Vincula los datos de un elemento en la posición especificada con la vista.
     */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        holder.bind(list[position], position)
    }

    /**
     * Devuelve el número total de elementos en la lista de imágenes.
     */
    override fun getItemCount(): Int = list.size

    /**
     * Actualiza el adaptador cuando cambia la lista de imágenes.
     */
    fun update() {
        notifyDataSetChanged()
    }

    /**
     * ViewHolder personalizado que mantiene las vistas de cada elemento de imagen.
     * @param binding Binding generado por ViewBinding para acceder a las vistas de cada elemento.
     */
    inner class MyViewHolder(var binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Vincula los datos de la imagen especificada con las vistas enlazadas.
         * @param item Recurso de imagen (Int) a mostrar.
         * @param position Posición del elemento en la lista.
         */
        fun bind(item: Int, position: Int) {
            binding.apply {
                imgProduct.setImageResource(item)
            }
        }
    }
}
