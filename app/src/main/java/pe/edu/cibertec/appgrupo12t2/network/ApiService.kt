package pe.edu.cibertec.appgrupo12t2.network

import pe.edu.cibertec.appgrupo12t2.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    fun obtenerProductos(): Call<ProductResponse>
}