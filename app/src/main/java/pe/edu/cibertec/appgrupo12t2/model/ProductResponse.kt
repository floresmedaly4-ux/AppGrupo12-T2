package pe.edu.cibertec.appgrupo12t2.model

data class ProductResponse(
    val products: List<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int
)


