package pe.edu.cibertec.appgrupo12t2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Pregunta6Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pregunta6)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.contenedorPregunta6,
                    Pregunta4Fragment()
                )
                .commit()
        }
    }
}