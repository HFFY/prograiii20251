package com.prograiii.appdeclases.dataclases

import kotlinx.serialization.Serializable


@Serializable
data class DatosDeProyecto(
    val nombreGrupo: String,
    val tipoDeProyecto: String,
    val numeroDeIntegrantes: Int
)
