package com.prograiii.appdeclases

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prograiii.appdeclases.adapters.AdapterRecyclerEjemplo
import com.prograiii.appdeclases.databinding.ActivityEjemploScrollBinding
import com.prograiii.appdeclases.dataclases.DatosDeProyecto
import com.prograiii.appdeclases.dataclases.EjemploRecyclerDataClass
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

class EjemploScrollActivity : AppCompatActivity() {

    val context: Context = this

    private lateinit var binding: ActivityEjemploScrollBinding

    val adapter by lazy { AdapterRecyclerEjemplo() }
    val adapterNumeral by lazy { AdapterRecyclerEjemplo() }

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
                putExtra(ID_DATOS_PROYECTO, Json.encodeToString(proyectoUno))
            }
            startActivity(intentCambioPantalla)
        }

        val mutablelist = mutableListOf<EjemploRecyclerDataClass>()

        mutablelist.add(EjemploRecyclerDataClass(
            "Text Ejemplo",
            123
        ))
        mutablelist.add(EjemploRecyclerDataClass(
            "Text Ejemplo",
            123
        ))
        mutablelist.add(EjemploRecyclerDataClass(
            "Text Ejemplo",
            123
        ))
        mutablelist.add(EjemploRecyclerDataClass(
            "Text Ejemplo",
            123
        ))
        mutablelist.add(EjemploRecyclerDataClass(
            "Text Ejemplo",
            123
        ))
        mutablelist.add(EjemploRecyclerDataClass(
            "Text Ejemplo",
            123
        ))

        val nuevaLista = mutableListOf<EjemploRecyclerDataClass>()
        nuevaLista.add(EjemploRecyclerDataClass(
            "Text Ejemplo",
            123
        ))
        nuevaLista.add(EjemploRecyclerDataClass(
            "Text Ejemplo",
            123
        ))
        nuevaLista.add(EjemploRecyclerDataClass(
            "Text Ejemplo",
            123
        ))
        nuevaLista.add(EjemploRecyclerDataClass(
            "Text Ejemplo",
            123
        ))
        nuevaLista.add(EjemploRecyclerDataClass(
            "Text Ejemplo",
            123
        ))
        nuevaLista.add(EjemploRecyclerDataClass(
            "Text Ejemplo",
            123
        ))
        nuevaLista.add(EjemploRecyclerDataClass(
            "Text Ejemplo",
            123
        ))

        adapter.addDataCards(mutablelist)

        adapterNumeral.addDataCards(nuevaLista)

        binding.recyclerEjemploScroll.layoutManager = GridLayoutManager(this,2)
        binding.recyclerEjemploScroll.adapter = adapter

        binding.recyclerEjemploScrollDos.layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL, false)
        binding.recyclerEjemploScrollDos.adapter = adapterNumeral

        binding.buttonEjemploScroll2.setOnClickListener {
            val intentEjemplos = Intent(context, ViewEjemplosActivity::class.java)
            startActivity(intentEjemplos)
        }

    }
}