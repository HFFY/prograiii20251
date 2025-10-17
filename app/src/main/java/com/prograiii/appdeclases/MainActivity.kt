package com.prograiii.appdeclases

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.prograiii.appdeclases.EjemploScrollActivity.Companion.ID_DATOS_PROYECTO
import com.prograiii.appdeclases.EjemploScrollActivity.Companion.ID_HOLA_MUNDO
import com.prograiii.appdeclases.databinding.ActivityMainBinding
import com.prograiii.appdeclases.dataclases.DatosDeProyecto

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //@RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val stringReci: String? = intent.getStringExtra(ID_HOLA_MUNDO)
        val proyectoUno: DatosDeProyecto? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(ID_DATOS_PROYECTO, DatosDeProyecto::class.java)
        } else {
            intent.getSerializableExtra(ID_DATOS_PROYECTO) as DatosDeProyecto
        }
        binding.textViewEjemplo6.text = stringReci
        binding.textViewEjemplo4.text = proyectoUno?.tipoDeProyecto ?: "No me pasaron los datos"

        val test = "test"
    }
}