package com.rantinaya.utils

import android.os.Handler
import android.os.Looper
import android.util.Patterns
import androidx.recyclerview.widget.RecyclerView

/**
 * Verifica si una cadena de texto es una dirección de correo electrónico válida.
 *
 * @param email Cadena de texto que se desea verificar.
 * @return `true` si la cadena es una dirección de correo electrónico válida, `false` de lo contrario.
 */
fun isValidEmail(email: String): Boolean {
    return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

/**
 * Implementa un deslizador automático para un RecyclerView.
 *
 * @param position La posición actual del deslizador.
 * @param size Tamaño total de los elementos en el RecyclerView.
 */
fun RecyclerView.setAutomaticSlider(position: Int, size: Int) {
    // Manejador para manejar el hilo principal de la interfaz de usuario (UI thread)
    Handler(Looper.getMainLooper()).postDelayed({
        if (position + 1 >= size) {
            // Si alcanza el final de la lista, vuelve al inicio
            this.smoothScrollToPosition(0)
            setAutomaticSlider(0, size) // Llama recursivamente para iniciar el deslizador desde el principio
        } else {
            // Si no ha alcanzado el final, avanza al siguiente elemento
            this.smoothScrollToPosition(position + 1)
            setAutomaticSlider(position + 1, size) // Llama recursivamente para avanzar al siguiente elemento
        }
    }, 3000) // Retraso de 3000 milisegundos (3 segundos) entre cada deslizamiento
}
