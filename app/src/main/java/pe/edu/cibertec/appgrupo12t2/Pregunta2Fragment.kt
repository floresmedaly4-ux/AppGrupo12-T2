package pe.edu.cibertec.appgrupo12t2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import pe.edu.cibertec.appgrupo12t2.databinding.FragmentPregunta2Binding
import java.util.Locale

// Pregunta 4 del examen: corresponde a la segunda pestaña de Home.
class Pregunta2Fragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPregunta2Binding? = null
    private val binding get() = _binding!!
    private val calculadora = CalculadoraBuffet()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewCompat.setAccessibilityHeading(binding.tvTituloBuffet, true)
        // En un Fragment los controles existen después de onCreateView.
        binding.btnCalcularBuffet.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btnCalcularBuffet) {
            calcularPenalizacion()
        }
    }

    private fun calcularPenalizacion() {
        val entrada = binding.etGramosBuffet.text.toString().trim()
        binding.tvResultadoBuffet.text = ""
        binding.etGramosBuffet.error = null

        if (entrada.isBlank()) {
            mostrarError(getString(R.string.buffet_error_vacio))
            return
        }

        // Admite tanto 150.5 como 150,5, según el teclado del dispositivo.
        val gramos = entrada.replace(',', '.').toDoubleOrNull()
        if (gramos == null || !gramos.isFinite() || gramos < 0) {
            mostrarError(getString(R.string.buffet_error_numero))
            return
        }

        binding.etGramosBuffet.clearFocus()
        WindowCompat.getInsetsController(requireActivity().window, binding.root)
            .hide(WindowInsetsCompat.Type.ime())

        if (gramos <= 100.0) {
            binding.tvResultadoBuffet.text = getString(R.string.buffet_sin_penalizacion)
        } else {
            val exceso = gramos - 100.0
            val penalizacion = calculadora.calcularPenalizacion(gramos)
            binding.tvResultadoBuffet.text = String.format(
                Locale.US,
                getString(R.string.buffet_resultado),
                gramos,
                exceso,
                penalizacion
            )
        }
    }

    private fun mostrarError(mensaje: String) {
        binding.etGramosBuffet.error = mensaje
        binding.etGramosBuffet.requestFocus()
        Toast.makeText(requireContext(), mensaje, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
