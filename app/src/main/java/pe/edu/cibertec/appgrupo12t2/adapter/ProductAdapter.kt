package pe.edu.cibertec.appgrupo12t2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.edu.cibertec.appgrupo12t2.databinding.ItemProductBinding
import pe.edu.cibertec.appgrupo12t2.model.Product

class ProductAdapter(
    private val productos: List<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(
        private val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(producto: Product) {

            binding.tvTitulo.text = producto.title
            binding.tvCategoria.text = producto.category
            binding.tvPrecio.text = "$ %.2f".format(producto.price)

            Glide.with(binding.root.context)
                .load(producto.thumbnail)
                .into(binding.imgProducto)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {

        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ProductViewHolder,
        position: Int
    ) {
        holder.bind(productos[position])
    }

    override fun getItemCount(): Int {
        return productos.size
    }
}