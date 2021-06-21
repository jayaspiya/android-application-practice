package com.example.androidapplicationpractice

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*

class BusBookingActivity : AppCompatActivity() {
    private lateinit var spDestination: Spinner
    private lateinit var btnSelectStartDate: Button
    private lateinit var tvStartDate: TextView
    private lateinit var btnSelectReturnDate: Button
    private lateinit var tvReturnDate: TextView
    private lateinit var etPassenger: EditText
    private lateinit var btnBookTicket: Button
    private var startYear: Int = 0
    private var startMonth: Int = 0
    private var startDay: Int = 0
    private var returnYear: Int = 0
    private var returnMonth: Int = 0
    private var returnDay: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_booking)
        spDestination = findViewById(R.id.spDestination)
        btnSelectStartDate = findViewById(R.id.btnSelectStartDate)
        tvStartDate = findViewById(R.id.tvStartDate)
        btnSelectReturnDate = findViewById(R.id.btnSelectReturnDate)
        tvReturnDate = findViewById(R.id.tvReturnDate)
        etPassenger = findViewById(R.id.etPassenger)
        btnBookTicket = findViewById(R.id.btnBookTicket)
        tvReturnDate.isEnabled = false
        btnSelectReturnDate.isEnabled = false
        val destinationNCost = mapOf(
            "Pokhara" to 1200,
            "Chitwan" to 1000,
            "Bhairawa" to 2000
        )
        val adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, destinationNCost.keys.toTypedArray()
        )
        spDestination.adapter = adapter
        btnSelectStartDate.setOnClickListener {
            selectDate()
        }
        btnSelectReturnDate.setOnClickListener {
            selectDate(true)
        }
        btnBookTicket.setOnClickListener {
            if(etPassenger.text.toString().toInt() < 0){
                etPassenger.requestFocus()
                etPassenger.error = "Please specify passengers"
            }
            else if(startYear*startMonth*startDay*returnYear*returnMonth*returnDay == 0){
                Toast.makeText(this, "Please Select Date", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, BusBookingResultActivity::class.java)
                val destination: String = spDestination.selectedItem.toString()
                val startDate: String = "$startDay-$startMonth-$startYear"
                val returnDate: String = "$returnDay-$returnMonth-$returnYear"
                intent.putExtra("destination", destination )
                intent.putExtra("count", etPassenger.text.toString().toInt())
                intent.putExtra("cost",destinationNCost[destination] )
                intent.putExtra("startDate", startDate)
                intent.putExtra("returnDate", returnDate)
                startActivity(intent)
            }
        }
    }

    private fun selectDate(isReturningSelect: Boolean = false) {
        var cal = Calendar.getInstance()
        var limitYear = cal.get(Calendar.YEAR)
        var limitMonth = cal.get(Calendar.MONTH)
        var limitDay = cal.get(Calendar.DAY_OF_MONTH)
        if(isReturningSelect){
            limitYear = startYear
            limitMonth = startMonth-1
            limitDay = startDay
        }
        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                if(dayOfMonth >= limitDay || month > limitMonth || year > limitYear ){
                    if(!isReturningSelect) {
                        startYear = year
                        startMonth = month+1
                        startDay = dayOfMonth
                        tvStartDate.text = "$startDay-$startMonth-$startYear"
                        tvReturnDate.isEnabled = true
                        btnSelectReturnDate.isEnabled = true
                        returnYear = 0
                        returnMonth = 0
                        returnDay = 0
                        tvReturnDate.text = "dd-mm-yyyy"
                    }
                    else{
                        returnYear = year
                        returnMonth = month+1
                        returnDay = dayOfMonth
                        tvReturnDate.text = "$returnDay-$returnMonth-$returnYear"
                    }
                }
                else{
                    Toast.makeText(this,  "You have to pick a future date", Toast.LENGTH_SHORT).show()
                }
            },
            limitYear,
            limitMonth,
            limitDay
        ).show()
    }
}