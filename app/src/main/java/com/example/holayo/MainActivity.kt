package com.example.holayo
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

data class Perfil(
    val nombre: String,
    val dato: String,
    val apodo: String?, // el ? declara: "puede no haber apodo" — y el compilador lo vigila
    val equipo: String? = null // Opcional: puede ser String o null
)
class MainActivity : AppCompatActivity() {
    private val perfil = Perfil(
        nombre = "Ramón Estudiante",
        dato = "Estoy cursando Aplicaciones Móviles",
        apodo = "Rami", // probá también con un apodo real: "Rama"
        equipo = "Boca Juniors"
    )
    private var saludoFormal = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvSaludo = findViewById<TextView>(R.id.tvSaludo)
        val tvDato = findViewById<TextView>(R.id.tvDato)
        val tvEquipo = findViewById<TextView>(R.id.tvEquipo)
        val btnSaludar = findViewById<Button>(R.id.btnSaludar)

        // Si hay apodo se usa; si es null, el nombre. El operador ?: es el "plan B".
        val comoLlamarme = perfil.apodo ?: perfil.nombre
        tvSaludo.text = "Hola, soy $comoLlamarme"
        tvDato.text = perfil.dato

        // paso 3
        perfil.equipo?.let { equipoTexto ->
            tvEquipo.text = "Hincha de: $equipoTexto"
        }

        // Una lambda: la función que se ejecuta cuando el botón se toca.
        btnSaludar.setOnClickListener {
            saludoFormal = !saludoFormal
            tvSaludo.text = if (saludoFormal)
                "Hola, soy $comoLlamarme"
            else
                "¡Buenas! Acá $comoLlamarme"
        }
    }
}