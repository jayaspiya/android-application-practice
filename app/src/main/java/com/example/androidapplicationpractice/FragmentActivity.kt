package com.example.androidapplicationpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidapplicationpractice.fragments.AreaFragment
import com.example.androidapplicationpractice.fragments.SumFragment

class FragmentActivity : AppCompatActivity() {
    private lateinit var btnSumFragment: Button
    private lateinit var btnAreaFragment: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        btnSumFragment = findViewById(R.id.btnSumFragment)
        btnAreaFragment = findViewById(R.id.btnAreaFragment)
        btnSumFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().apply{
                replace(R.id.linearContainer, SumFragment())
                addToBackStack(null)
                commit()
            }
        }
        btnAreaFragment.setOnClickListener {
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.replace(R.id.linearContainer, AreaFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}