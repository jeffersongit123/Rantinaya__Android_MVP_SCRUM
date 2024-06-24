package com.rantinaya.services.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rantinaya.databinding.ItemServicesBinding
import com.rantinaya.services.data.ServiceByCanton
import com.rantinaya.utils.modelBackUp.listImageInfoServices

/**
 * Adaptador personalizado para manejar la lista de servicios en un RecyclerView.
 * @param list Lista mutable de ServiceByCanton que contiene los datos de servicios.
 */
class ServicesAdapter(var list: MutableList<ServiceByCanton>) :
    RecyclerView.Adapter<ServicesAdapter.MyViewHolder>() {

    lateinit var onSelect: (position: Int) -> Unit

    /**
     * Crea y devuelve una instancia de MyViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemServicesBinding.inflate(
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
     * Devuelve el número total de elementos en la lista de servicios.
     */
    override fun getItemCount(): Int = list.size

    /**
     * Actualiza el adaptador cuando cambia la lista de servicios.
     */
    fun update() {
        notifyDataSetChanged()
    }

    /**
     * ViewHolder personalizado que mantiene las vistas de cada elemento de servicio.
     * @param binding Binding generado por ViewBinding para acceder a las vistas de cada elemento.
     */
    inner class MyViewHolder(var binding: ItemServicesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Vincula los datos del servicio especificado con las vistas enlazadas.
         * @param item Objeto ServiceByCanton que contiene los datos del servicio.
         * @param position Posición del elemento en la lista.
         */
        fun bind(item: ServiceByCanton, position: Int) {
            binding.apply {
                textDescription.text = item.Descripción
                textName.text = item.Servicio
                try {
                    // Intenta establecer la imagen del servicio desde listImageInfoServices
                    imgService.setImageResource(
                        listImageInfoServices.firstOrNull { it.name == item.Servicio }!!.logo
                    )
                } catch (e: Exception) {
                    println(e.message)
                }

                // Configura el OnClickListener para el botón de selección
                btnSelect.setOnClickListener {
                    onSelect.invoke(position)
                }
            }
        }
    }
}
