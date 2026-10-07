package pe.edu.cibertec.appgrupo12t2
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.appgrupo12t2.databinding.FragmentPregunta4Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class Pregunta4Fragment : Fragment() {
    private var _binding: FragmentPregunta4Binding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta4Binding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvProductos.layoutManager = LinearLayoutManager(requireContext())
        cargarProductosApi()
    }
    private fun cargarProductosApi() {
        RetrofitClient.apiService.obtenerProductos().enqueue(object : Callback<ProductoResponse> {
            override fun onResponse(
                call: Call<ProductoResponse>,
                response: Response<ProductoResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val lista = response.body()!!.products
                    binding.rvProductos.adapter = ProductoAdapter(lista)
                } else {
                    Toast.makeText(context, "Error al obtener datos", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<ProductoResponse>, t: Throwable) {
                Toast.makeText(context, "Fallo de conexión: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}