package com.rantinaya.about.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rantinaya.databinding.ActivityAboutBinding
import com.rantinaya.about.AboutContract
import com.rantinaya.about.data.AboutMember
import com.rantinaya.about.presenter.AboutPresenter

/**
 * Activity que muestra información sobre los miembros.
 * Implementa la interfaz AboutContract para comunicar con el presentador.
 */
class AboutActivity : AppCompatActivity(), AboutContract {

    // Enlace a la vista definida en el layout XML.
    private lateinit var binding: ActivityAboutBinding

    // Instancia del presentador para manejar la lógica.
    private val presenter = AboutPresenter(this)

    // Adaptador para manejar la lista de miembros.
    private lateinit var adapter: AboutAdapter

    /**
     * Método llamado cuando la actividad es creada.
     * @param savedInstanceState Estado de la instancia guardada.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.getMembers()
    }

    /**
     * Establece la lista de miembros en el adaptador y lo asigna al RecyclerView.
     * @param members Lista de objetos AboutMember.
     */
    override fun setMembers(members: List<AboutMember>) {
        adapter = AboutAdapter(members.toMutableList())
        adapter.openWeb = { presenter.openWeb(it) }
        binding.rvMembers.adapter = adapter
    }

    /**
     * Abre una URL en el navegador web.
     * @param url La URL que se debe abrir.
     */
    override fun openWeb(url: String) {
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(url)
        )
        try {
            startActivity(intent)
        } catch (e: Exception) {
            // Manejo de excepción si no se puede abrir la URL.
        }
    }

    /**
     * Método llamado cuando la actividad se destruye.
     * Libera los recursos del presentador.
     */
    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}
