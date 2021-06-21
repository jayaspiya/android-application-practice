package com.example.androidapplicationpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

// List View & Pass value in intent
class CountryCapitalActivity : AppCompatActivity() {
    private lateinit var lvCountry: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_capital)
        lvCountry = findViewById(R.id.lvCountry)
        val countryCapital = mapOf(
            "India" to "New Delhi",
            "Nepal" to "Kathmandu",
            "UK" to "London",
        )
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            countryCapital.keys.toTypedArray()
        )
        lvCountry.adapter = adapter
        lvCountry.setOnItemClickListener { parent, view, position, id ->
            val country = parent.getItemAtPosition(position).toString()
            val capital = countryCapital[country]
            val intent = Intent(this, CountryCapitalResultActivity::class.java)
            intent.putExtra("country", country)
            intent.putExtra("capital", capital)
            startActivity(intent)
        }
    }
}