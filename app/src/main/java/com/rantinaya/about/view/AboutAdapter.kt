package com.rantinaya.about.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rantinaya.databinding.ItemAboutBinding
import com.rantinaya.about.data.AboutMember

/**
 * Adaptador para manejar la lista de miembros en un RecyclerView.
 *
 * @property list Lista de miembros.
 */
class AboutAdapter(var list: MutableList<AboutMember>) : RecyclerView.Adapter<AboutAdapter.MyViewHolder>() {

    // Función lambda para abrir URLs.
    lateinit var openWeb: ((url: String) -> Unit)

    /**
     * Crea y devuelve un ViewHolder para un elemento de la lista.
     *
     * @param parent El ViewGroup padre.
     * @param viewType Tipo de vista del nuevo ViewHolder.
     * @return Un nuevo ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemAboutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    /**
     * Asocia un ViewHolder con los datos en una posición específica.
     *
     * @param holder ViewHolder que debe actualizarse para representar los contenidos del elemento.
     * @param position Posición del elemento dentro del adaptador.
     */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        holder.bind(list[position], position)
    }

    /**
     * Devuelve el tamaño de la lista.
     *
     * @return Número de elementos en la lista.
     */
    override fun getItemCount(): Int = list.size

    /**
     * Notifica al adaptador que los datos han cambiado y deben actualizarse.
     */
    fun update() {
        notifyDataSetChanged()
    }

    /**
     * ViewHolder interno para manejar la vinculación de vistas.
     *
     * @property binding Enlace a las vistas del elemento de la lista.
     */
    inner class MyViewHolder(var binding: ItemAboutBinding) : RecyclerView.ViewHolder(binding.root) {

        /**
         * Vincula un elemento de la lista con el ViewHolder.
         *
         * @param item Elemento AboutMember que se va a mostrar.
         * @param position Posición del elemento en la lista.
         */
        fun bind(item: AboutMember, position: Int) {
            binding.apply {
                textName.text = item.name
                textEmail.text = "Correo : " + item.email
                textPhone.text = "Telefono : " + item.phone

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
