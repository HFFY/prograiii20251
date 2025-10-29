package com.prograiii.appdeclases

import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.prograiii.appdeclases.EjemploScrollActivity.Companion.ID_DATOS_PROYECTO
import com.prograiii.appdeclases.EjemploScrollActivity.Companion.ID_HOLA_MUNDO
import com.prograiii.appdeclases.basededatos.EjemploDao
import com.prograiii.appdeclases.basededatos.EjemploDataBase
import com.prograiii.appdeclases.basededatos.EjemploParaRoom
import com.prograiii.appdeclases.databinding.ActivityMainBinding
import com.prograiii.appdeclases.dataclases.DatosDeProyecto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var sharedPreferences: SharedPreferences

    private val DATABASE_NAME: String = "USER_DATABASE"

    private lateinit var ejemploDao: EjemploDao

    //@RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sharedPreferences = this.getSharedPreferences("PrograIII", MODE_PRIVATE)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val stringReci: String? = intent.getStringExtra(ID_HOLA_MUNDO)
        val stringClase = intent.getStringExtra(ID_DATOS_PROYECTO) ?: ""
        val proyectoUno: DatosDeProyecto? = if (!stringClase.isEmpty()) {
            Json.decodeFromString<DatosDeProyecto>(stringClase)
        } else {
            null
        }
        binding.textViewEjemplo6.text = stringReci

        binding.buttonGuardar.setOnClickListener {
            guardarDataClass(proyectoUno ?: DatosDeProyecto("", "", 0))
            guardarDatosEnBaseDeDatos()
        }
        binding.buttonMostrarDatos.setOnClickListener {
            obtenerDataClass()
            obtenerDataDeFile()
            val datosEjemploRoom  = obtenerDatosEnBaseDeDatos()

            binding.textViewDatosRoom.text = datosEjemploRoom.toString()
        }


        val ejemploDataBase = Room.databaseBuilder(
            applicationContext, EjemploDataBase::class.java, DATABASE_NAME
        ).build()

        ejemploDao = ejemploDataBase.ejemploDao()
    }

    private fun guardarDataClass(proyecto: DatosDeProyecto) {
        val asdfgh: String = Json.encodeToString(proyecto)
        val editor = sharedPreferences.edit()
        editor.putString("datosProyecto", asdfgh)
        editor.apply()
    }

    private fun obtenerDataClass(): DatosDeProyecto? {
        val datoGuardado: String = sharedPreferences.getString("datosProyecto", null) ?: ""
        binding.textViewDatosSharedPrefs.text = datoGuardado
        if (!datoGuardado.isEmpty()) {
            val objetoGuardado = Json.decodeFromString<DatosDeProyecto>(datoGuardado)
            return objetoGuardado
        }
        return null
    }

    private fun obtenerDataDeFile(): DatosDeProyecto? {
        val fileString: String =
            applicationContext.assets.open("datosApp.json").bufferedReader().use { it.readText() }
        binding.textViewDatosLocalFile.text = fileString
        val objetoGuardado = Json.decodeFromString<DatosDeProyecto>(fileString)
        return objetoGuardado
    }

    private fun guardarDatosEnBaseDeDatos() {
        GlobalScope.launch {
            val ejemplo = EjemploParaRoom(
                id = 0,
                unTextoColumna = "Texto Ejemplo",
                unNumeroColumna = 1,
                unBooleanColumna = true,
            )
            ejemploDao.insertAll(ejemplo)
        }
    }

    private fun obtenerDatosEnBaseDeDatos():List<EjemploParaRoom>  {
        var ejemplo: List<EjemploParaRoom> = listOf()
        runBlocking {
            withContext(Dispatchers.IO){
                ejemplo = ejemploDao.getAll()
            }
        }
        return ejemplo
    }
}