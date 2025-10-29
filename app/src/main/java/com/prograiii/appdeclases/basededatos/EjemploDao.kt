package com.prograiii.appdeclases.basededatos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EjemploDao {
    @Query("SELECT * FROM ejemplopararoom")
    fun getAll(): List<EjemploParaRoom>

    @Insert
    fun insertAll(vararg ejemplopararoom: EjemploParaRoom)

    @Delete
    fun delete(ejemplopararoom: EjemploParaRoom)
}