package com.example.androidapplicationpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import com.bumptech.glide.Glide

class ImageViewActivity : AppCompatActivity() {
    private lateinit var ivPokemon: ImageView
    private lateinit var rdoOshawott: RadioButton
    private lateinit var rdoSnivy: RadioButton
    private lateinit var rdoTepig: RadioButton
    private lateinit var rdoPikachu: RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)
        ivPokemon = findViewById(R.id.ivPokemon)
        rdoPikachu = findViewById(R.id.rdoPikachu)
        rdoTepig = findViewById(R.id.rdoTepig)
        rdoSnivy = findViewById(R.id.rdoSnivy)
        rdoOshawott = findViewById(R.id.rdoOshawott)

        rdoOshawott.setOnClickListener {
            ivPokemon.setImageResource(R.drawable.oshawott)
        }
        rdoSnivy . setOnClickListener {
            ivPokemon.setImageResource(R.drawable.snivy)
        }
        rdoTepig . setOnClickListener {
            ivPokemon.setImageResource(R.drawable.tepig)
        }
        rdoPikachu . setOnClickListener {
            Glide.with(this)
                .load("https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png")
                .into(ivPokemon)
        }
    }
}