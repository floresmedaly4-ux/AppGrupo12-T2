package pe.edu.cibertec.appgrupo12t2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import pe.edu.cibertec.appgrupo12t2.databinding.ActivityPregunta1Binding

class Pregunta1Activity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPregunta1Binding

    private val usuarios = listOf(
        Usuario("i201620507", "71458236"), // Hans
        Usuario("i202505415", "72649158"), // Joseph
        Usuario("i202211504", "70163842"), // Juan Diego
        Usuario("i202402509", "74521963"), // Ailyn
        Usuario("i202512236", "73830717"), // Medaly
        Usuario("i202221935", "71935482"), // Luis Gustavo
        Usuario("i202214802", "73284615")  // Ronny Darwin
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPregunta1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIngresar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnIngresar -> validarLogin()
        }
    }

    private fun validarLogin() {

        val usuario = binding.etUsuario.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        if (usuario.isEmpty() || password.isEmpty()) {
            Toast.makeText(
                this,
                "Ingrese usuario y contraseña.",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        if (credencialesValidas(usuario, password)) {

            Toast.makeText(
                this,
                "Inicio de sesión correcto.",
                Toast.LENGTH_SHORT
            ).show()

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)

            // Evita regresar al Login con el botón Atrás
            finish()

        } else {

            Toast.makeText(
                this,
                "Usuario o contraseña incorrectos.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun credencialesValidas(
        usuario: String,
        password: String
    ): Boolean {

        return usuarios.any {
            it.usuario == usuario && it.password == password
        }
    }
}