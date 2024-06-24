package com.rantinaya

import org.junit.Test // Importa Test para definir métodos de prueba
import org.junit.Assert.* // Importa Assert para utilizar métodos de aserción como assertEquals

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    // Método de prueba que verifica una adición simple
    @Test
    fun addition_isCorrect() {
        // Verifica que la suma de 2 + 2 sea igual a 4
        assertEquals(4, 2 + 2)
    }
}
