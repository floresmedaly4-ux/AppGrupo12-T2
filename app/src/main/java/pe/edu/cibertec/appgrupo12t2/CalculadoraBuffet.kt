package pe.edu.cibertec.appgrupo12t2

class CalculadoraBuffet {
    fun calcularPenalizacion(gramos: Double): Double {
        require(gramos.isFinite() && gramos >= 0) {
            "Los gramos deben ser un número válido mayor o igual a cero."
        }
        return if (gramos <= 100.0) {
            0.0
        } else {
            15.0 + 0.12 * (gramos - 100.0)
        }
    }
}
