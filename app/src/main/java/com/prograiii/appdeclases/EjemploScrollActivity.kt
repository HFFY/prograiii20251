package com.prograiii.appdeclases

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EjemploScrollActivity : AppCompatActivity() {

    val context: Context = this

    companion object {
        val ID_HOLA_MUNDO = "id_hola_mundo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo_scroll)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button: Button = findViewById(R.id.button_ejemplo_scroll)
        button.setOnClickListener {
            val intentCambioPantalla: Intent = Intent(context , MainActivity::class.java)
            intentCambioPantalla.apply {
                putExtra(ID_HOLA_MUNDO,"Hola Mundo Enviado")
            }
            startActivity(intentCambioPantalla)
        }
    }
}