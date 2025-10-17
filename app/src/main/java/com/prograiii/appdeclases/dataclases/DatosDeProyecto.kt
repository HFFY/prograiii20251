package com.prograiii.appdeclases.dataclases

import java.io.Serializable

data class DatosDeProyecto(
    val nombreGrupo: String,
    val tipoDeProyecto: String,
    val numeroDeIntegrantes: Int
): Serializable
