package pe.edu.cibertec.appgrupo12t2

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    fun obtenerProductos(): Call<ProductoResponse>
}