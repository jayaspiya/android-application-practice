package com.example.androidapplicationpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class CountryCapitalActivity : AppCompatActivity() {
    private lateinit var lvCountry: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_capital)
        lvCountry = findViewById(R.id.lvCountry)
        val countries = arrayOf("India", "Nepal", "UK")
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            countries
        )
        lvCountry.adapter = adapter
    }
}