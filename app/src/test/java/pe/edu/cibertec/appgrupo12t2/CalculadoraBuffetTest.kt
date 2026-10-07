package pe.edu.cibertec.appgrupo12t2

import org.junit.Assert.assertEquals
import org.junit.Test

class CalculadoraBuffetTest {
    private val calculadora = CalculadoraBuffet()

    @Test
    fun ceroYLimiteNoGeneranPenalizacion() {
        assertEquals(0.0, calculadora.calcularPenalizacion(0.0), 0.000001)
        assertEquals(0.0, calculadora.calcularPenalizacion(100.0), 0.000001)
    }

    @Test
    fun cobraBaseYUnicamenteLosGramosQueExcedenCien() {
        assertEquals(15.12, calculadora.calcularPenalizacion(101.0), 0.000001)
        assertEquals(21.0, calculadora.calcularPenalizacion(150.0), 0.000001)
        assertEquals(27.0, calculadora.calcularPenalizacion(200.0), 0.000001)
    }

    @Test
    fun admiteFraccionesDeGramo() {
        assertEquals(15.06, calculadora.calcularPenalizacion(100.5), 0.000001)
    }

    @Test(expected = IllegalArgumentException::class)
    fun rechazaGramosNegativos() {
        calculadora.calcularPenalizacion(-1.0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun rechazaInfinito() {
        calculadora.calcularPenalizacion(Double.POSITIVE_INFINITY)
    }

    @Test(expected = IllegalArgumentException::class)
    fun rechazaNan() {
        calculadora.calcularPenalizacion(Double.NaN)
    }
}
