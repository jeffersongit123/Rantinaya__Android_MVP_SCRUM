package com.rantinaya

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rantinaya.R

// Clase principal de la actividad MainActivity, que hereda de AppCompatActivity
class MainActivity : AppCompatActivity() {

    // Método llamado cuando se crea la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llama al método onCreate de la clase base

        // Establece el layout de la actividad desde activity_main.xml en el directorio res/layout
        setContentView(R.layout.activity_main)
    }
}
