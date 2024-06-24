package com.rantinaya

import androidx.test.platform.app.InstrumentationRegistry // Importa la clase InstrumentationRegistry para acceder al contexto de la aplicación durante las pruebas
import androidx.test.ext.junit.runners.AndroidJUnit4 // Importa AndroidJUnit4 para ejecutar las pruebas en un dispositivo Android

import org.junit.Test // Importa Test para definir métodos de prueba
import org.junit.runner.RunWith // Importa RunWith para especificar el corredor de pruebas

import org.junit.Assert.* // Importa Assert para utilizar métodos de aserción como assertEquals

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class) // Indica que las pruebas se ejecutarán en un dispositivo Android usando AndroidJUnit4
class ExampleInstrumentedTest {

    // Método de prueba que verifica el contexto de la aplicación
    @Test
    fun useAppContext() {
        // Contexto de la aplicación bajo prueba
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        // Verifica que el nombre del paquete de la aplicación coincida con "com.rantinaya"
        assertEquals("com.rantinaya", appContext.packageName)
    }
}
