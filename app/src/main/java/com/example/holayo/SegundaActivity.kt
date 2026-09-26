package com.example.holayo

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SegundaActivity : AppCompatActivity() {

    override fun onStart() { super.onStart(); Log.d("VIDA", "Main → onStart") }
    override fun onResume() { super.onResume(); Log.d("VIDA", "Main → onResume") }
    override fun onPause() { super.onPause(); Log.d("VIDA", "Main → onPause") }
    override fun onStop() { super.onStop(); Log.d("VIDA", "Main → onStop") }
    override fun onDestroy() { super.onDestroy(); Log.d("VIDA", "Main → onDestroy") }
    override fun onRestart() { super.onRestart(); Log.d("VIDA", "Main + onRestart") }

    private var contador = 0
    private val STATE_COUNT = "count"

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(STATE_COUNT, contador)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("VIDA", "Segunda → onCreate")
        setContentView(R.layout.activity_segunda)

        contador = savedInstanceState?.getInt(STATE_COUNT, 0) ?: 0

        val nombre = intent.getStringExtra("nombre") ?: "misterioso visitante"
        findViewById<TextView>(R.id.tvBienvenida).text =
            "Sala de experimentos de $nombre"

        val tvContador = findViewById<TextView>(R.id.tvContador)
        tvContador.text = contador.toString()

        findViewById<Button>(R.id.btnSumar).setOnClickListener {
            contador++
            tvContador.text = contador.toString()
        }
    }
}