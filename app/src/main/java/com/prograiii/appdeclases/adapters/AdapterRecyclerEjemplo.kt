package com.prograiii.appdeclases.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prograiii.appdeclases.databinding.AdapterEjemploClasesBinding
import com.prograiii.appdeclases.dataclases.EjemploRecyclerDataClass

class AdapterRecyclerEjemplo:
    RecyclerView.Adapter<AdapterRecyclerEjemplo.EjemploCardViewHolder>() {

    private val dataCards = mutableListOf<EjemploRecyclerDataClass>()
    private var context: Context? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EjemploCardViewHolder {
        context = parent.context
        return EjemploCardViewHolder(
            AdapterEjemploClasesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: EjemploCardViewHolder, position: Int) {
        holder.binding(dataCards[position])
    }

    override fun getItemCount(): Int = dataCards.size


    // Donde hacer la logica
    inner class EjemploCardViewHolder(private val binding: AdapterEjemploClasesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun binding(data: EjemploRecyclerDataClass) {
            binding.textAdapterEjemplo.text = data.textoUno
            binding.textAdapterEjemploNumero.text = data.numero.toString()
        }
    }

    fun addDataCards(list: List<EjemploRecyclerDataClass>) {
        dataCards.clear()
        dataCards.addAll(list)
    }
}