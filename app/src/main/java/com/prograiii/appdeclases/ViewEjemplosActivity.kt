package com.prograiii.appdeclases

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.prograiii.appdeclases.databinding.ActivityViewEjemplosBinding

class ViewEjemplosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewEjemplosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewEjemplosBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Glide
            .with(this)
            .load("https://cdn.wikimg.net/en/hkwiki/images/a/a1/HK_first_cover_art.png")
            .into(binding.imageEjemploGlide)

        binding.imageEjemploDrawable.setImageDrawable(
            ContextCompat.getDrawable(this, R.drawable.alien_svgrepo_com)
        )
    }
}