package com.example.androidapplicationpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CountryCapitalResultActivity : AppCompatActivity() {
    private lateinit var tvCountry: TextView
    private lateinit var tvCapital: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_capital_result)
        tvCountry = findViewById(R.id.tvCountry)
        tvCapital = findViewById(R.id.tvCapital)
        tvCapital.text = intent.getStringExtra("capital")
        tvCountry.text = intent.getStringExtra("country")
    }
}