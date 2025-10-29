package com.prograiii.appdeclases.basededatos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EjemploParaRoom(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "unTextoColumna") val unTextoColumna: String,
    @ColumnInfo(name = "unNumeroColumna") val unNumeroColumna: Int,
    @ColumnInfo(name = "unBooleanColumna") val unBooleanColumna: Boolean
)
