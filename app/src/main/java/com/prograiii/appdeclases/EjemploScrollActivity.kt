package com.prograiii.appdeclases

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.prograiii.appdeclases.adapters.AdapterRecyclerEjemplo
import com.prograiii.appdeclases.databinding.ActivityEjemploScrollBinding
import com.prograiii.appdeclases.dataclases.DatosDeProyecto

class EjemploScrollActivity : AppCompatActivity() {

    val context: Context = this

    private lateinit var binding: ActivityEjemploScrollBinding

    val adapter by lazy { AdapterRecyclerEjemplo() }

    companion object {
        val ID_HOLA_MUNDO = "id_hola_mundo"
        val ID_DATOS_PROYECTO = "id_datos_proyecto"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding= ActivityEjemploScrollBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val proyectoUno = DatosDeProyecto(
            nombreGrupo = "Profesor",
            tipoDeProyecto = "De Clases",
            numeroDeIntegrantes = 1
        )

        binding.buttonEjemploScroll.setOnClickListener {
            val intentCambioPantalla: Intent = Intent(context , MainActivity::class.java)
            intentCambioPantalla.apply {
                putExtra(ID_HOLA_MUNDO,"Hola Mundo Enviado")
                putExtra(ID_DATOS_PROYECTO, proyectoUno)
            }
            startActivity(intentCambioPantalla)
        }

        val mutablelist = mutableListOf<String>()
        mutablelist.add("AAAAAAAAAAAAAAAA")
        mutablelist.add("BBBBBBBBBBBBBBBB")
        mutablelist.add("CCCCCCCCCCCCCCCC")
        mutablelist.add("DDDDDDDDDDDDDDDD")
        mutablelist.add("EEEEEEEEEEEEEEEE")
        mutablelist.add("FFFFFFFFFFFFFFFF")
        mutablelist.add("GGGGGGGGGGGGGGGG")
        mutablelist.add("HHHHHHHHHHHHHHHH")
        mutablelist.add("AAAAAAAAAAAAAAAA")
        mutablelist.add("BBBBBBBBBBBBBBBB")
        mutablelist.add("CCCCCCCCCCCCCCCC")
        mutablelist.add("DDDDDDDDDDDDDDDD")
        mutablelist.add("EEEEEEEEEEEEEEEE")
        mutablelist.add("FFFFFFFFFFFFFFFF")
        mutablelist.add("GGGGGGGGGGGGGGGG")
        mutablelist.add("HHHHHHHHHHHHHHHH")

        adapter.addDataCards(mutablelist)
        binding.recyclerEjemploScroll.layoutManager = LinearLayoutManager(this)
        binding.recyclerEjemploScroll.adapter = adapter

    }
}