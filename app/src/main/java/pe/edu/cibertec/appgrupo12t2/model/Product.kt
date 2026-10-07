package pe.edu.cibertec.appgrupo12t2.model

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val category: String,
    val thumbnail: String
)