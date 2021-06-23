package com.example.androidapplicationpractice

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class TimePickerActivity : AppCompatActivity() {
    private lateinit var btnSelectTime:Button
    private lateinit var tvSelectedTime: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker)
        btnSelectTime = findViewById(R.id.btnSelectTime)
        tvSelectedTime = findViewById(R.id.tvSelectedTime)
        btnSelectTime.setOnClickListener {
            selectTime()
        }
    }

    private fun selectTime() {
        val cal = Calendar.getInstance()
        var presentHour = cal.get(Calendar.HOUR)
        var presentMinute = cal.get(Calendar.MINUTE)
        TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                tvSelectedTime.text = "$hourOfDay: $minute"
            },
            presentHour,
            presentMinute,
            false
        ).show()
    }
}