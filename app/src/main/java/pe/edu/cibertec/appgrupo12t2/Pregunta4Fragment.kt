package pe.edu.cibertec.appgrupo12t2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.appgrupo12t2.adapter.ProductAdapter
import pe.edu.cibertec.appgrupo12t2.databinding.FragmentPregunta4Binding
import pe.edu.cibertec.appgrupo12t2.model.ProductResponse
import pe.edu.cibertec.appgrupo12t2.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Pregunta4Fragment : Fragment() {

    private var _binding: FragmentPregunta4Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPregunta4Binding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        configurarRecyclerView()
        obtenerProductos()
    }

    private fun configurarRecyclerView() {
        binding.rvProductos.layoutManager =
            LinearLayoutManager(requireContext())
    }

    private fun obtenerProductos() {

        binding.progressBar.visibility = View.VISIBLE

        RetrofitClient.apiService.obtenerProductos()
            .enqueue(object : Callback<ProductResponse> {

                override fun onResponse(
                    call: Call<ProductResponse>,
                    response: Response<ProductResponse>
                ) {
                    binding.progressBar.visibility = View.GONE

                    if (response.isSuccessful) {

                        val productos = response.body()?.products

                        if (productos != null) {
                            binding.rvProductos.adapter =
                                ProductAdapter(productos)
                        }

                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Error al obtener los productos",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(
                    call: Call<ProductResponse>,
                    t: Throwable
                ) {
                    binding.progressBar.visibility = View.GONE

                    Toast.makeText(
                        requireContext(),
                        "Error de conexión: ${t.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}