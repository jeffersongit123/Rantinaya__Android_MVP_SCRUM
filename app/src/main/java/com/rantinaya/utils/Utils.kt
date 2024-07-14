package com.rantinaya.utils

import android.os.Handler
import android.os.Looper
import android.util.Patterns
import androidx.recyclerview.widget.RecyclerView

fun isValidEmail(email: String): Boolean {
    return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun RecyclerView.setAutomaticSlider(position: Int, size: Int) {
    Handler(Looper.getMainLooper()).postDelayed({
        if (position + 1 >= size) {
            this.smoothScrollToPosition(0)
            setAutomaticSlider(0, size)
        } else {
            this.smoothScrollToPosition(position + 1)
            setAutomaticSlider(position + 1, size)
        }
    }, 3000)
}