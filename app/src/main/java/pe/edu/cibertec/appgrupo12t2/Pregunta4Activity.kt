package pe.edu.cibertec.appgrupo12t2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.appgrupo12t2.databinding.ActivityPregunta4Binding

// Permite probar el fragmento sin depender de Login ni de HomeActivity.
class Pregunta4Activity : AppCompatActivity() {

    private lateinit var binding: ActivityPregunta4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPregunta4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val teclado = insets.getInsets(WindowInsetsCompat.Type.ime())
            view.setPadding(
                barras.left, barras.top, barras.right,
                maxOf(barras.bottom, teclado.bottom)
            )
            insets
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.contenedorBuffet.id, Pregunta2Fragment())
                .commit()
        }
    }
}
