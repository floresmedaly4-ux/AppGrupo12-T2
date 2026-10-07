package pe.edu.cibertec.appgrupo12t2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.edu.cibertec.appgrupo12t2.databinding.ItemProductoBinding

class ProductoAdapter(private val listaProductos: List<Producto>) :
    RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    inner class ProductoViewHolder(val binding: ItemProductoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val binding = ItemProductoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = listaProductos[position]
        with(holder.binding) {
            tvTitulo.text = producto.title
            tvCategoria.text = "Categoría: ${producto.category}"
            tvPrecio.text = "Precio: $${producto.price}"

            Glide.with(root.context)
                .load(producto.thumbnail)
                .into(imgProducto)
        }
    }

    override fun getItemCount(): Int = listaProductos.size
}