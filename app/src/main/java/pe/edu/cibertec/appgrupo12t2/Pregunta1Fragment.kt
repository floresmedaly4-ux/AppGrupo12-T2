package pe.edu.cibertec.appgrupo12t2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import pe.edu.cibertec.appgrupo12t2.databinding.FragmentPregunta1Binding
import java.util.Locale

class Pregunta1Fragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPregunta1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btnCalcular) {
            calcularRecargo()
        }
    }

    private fun calcularRecargo() {
        val textoPeso = binding.etPeso.text.toString().trim()

        if (textoPeso.isEmpty()) {
            Toast.makeText(
                requireContext(),
                "Ingrese el peso de la mascota",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        val peso = textoPeso.toDoubleOrNull()

        if (peso == null || peso < 0) {
            Toast.makeText(
                requireContext(),
                "Ingrese un peso válido",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        if (peso <= 8) {
            binding.tvResultado.text =
                "Mascota apta para viajar en cabina sin sobrecosto."
        } else {
            val exceso = peso - 8
            val recargo = 150.0 + (35.0 * exceso)

            binding.tvResultado.text = String.format(
                Locale.getDefault(),
                "Peso total ingresado: %.2f kg\n" +
                        "Exceso de peso: %.2f kg\n" +
                        "Monto total a pagar por recargo: S/ %.2f",
                peso,
                exceso,
                recargo
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}