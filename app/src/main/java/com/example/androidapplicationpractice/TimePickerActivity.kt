package com.example.androidapplicationpractice

import android.app.AlertDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*

class TimePickerActivity : AppCompatActivity() {
    private lateinit var btnSelectTime:Button
    private lateinit var btnAlertDialog:Button
    private lateinit var tvSelectedTime: TextView
    private lateinit var acTextView: AutoCompleteTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker)
        btnSelectTime = findViewById(R.id.btnSelectTime)
        tvSelectedTime = findViewById(R.id.tvSelectedTime)
        acTextView = findViewById(R.id.acTextView)
        btnAlertDialog = findViewById(R.id.btnAlertDialog)
        val animeArr = arrayOf("Pokemon", "Dragon Ball Z", "One Piece", "Naruto", "Black Clover")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, animeArr)
        acTextView.setAdapter(adapter)
        acTextView.threshold = 1
        btnSelectTime.setOnClickListener {
            selectTime()
        }
        btnAlertDialog.setOnClickListener {
            alertDialog()
        }
    }

    private fun alertDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert Title")
        builder.setMessage("Do you want to set the current time?")
        builder.setIcon(android.R.drawable.ic_dialog_dialer)
        builder.setPositiveButton("yes"){
                _,_ ->
                    val cal = Calendar.getInstance()
                    var presentHour = cal.get(Calendar.HOUR)
                    var presentMinute = cal.get(Calendar.MINUTE)
                    tvSelectedTime.text = "$presentHour: $presentMinute"
        }
        builder.setNegativeButton("No"){
            _,_ ->
                Toast.makeText(this, "Set current time canceled", Toast.LENGTH_SHORT).show()

        }
        builder.setNeutralButton("Cancel"){
            _,_ ->
                Toast.makeText(this, "Alert Canceled", Toast.LENGTH_SHORT).show()
        }
        val alert = builder.create()
        alert.setCancelable(false)
        alert.show()
    }

    private fun selectTime() {
        val cal = Calendar.getInstance()
        var presentHour = cal.get(Calendar.HOUR)
        var presentMinute = cal.get(Calendar.MINUTE)
        val timerPicker = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                tvSelectedTime.text = "$hourOfDay: $minute"
            },
            presentHour,
            presentMinute,
            false
        )
        timerPicker.setCancelable(false)
        timerPicker.show()
    }
}