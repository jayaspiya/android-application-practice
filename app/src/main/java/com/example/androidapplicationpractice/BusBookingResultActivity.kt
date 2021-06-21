package com.example.androidapplicationpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BusBookingResultActivity : AppCompatActivity() {
    private lateinit var tvDestination: TextView
    private lateinit var tvCount: TextView
    private lateinit var tvCost: TextView
    private lateinit var tvTotal: TextView
    private lateinit var tvStartDate: TextView
    private lateinit var tvReturnDate: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_booking_result)
        // destination, count, cost, start, return
        tvDestination = findViewById(R.id.tvDestination)
        tvCount = findViewById(R.id.tvCount)
        tvCost = findViewById(R.id.tvCost)
        tvTotal = findViewById(R.id.tvTotal)
        tvStartDate = findViewById(R.id.tvStartDate)
        tvReturnDate = findViewById(R.id.tvReturnDate)
        val destination =  intent.getStringExtra("destination")
        val count =  intent.getIntExtra("count",0)
        val cost =  intent.getIntExtra("cost",0)
        val returnDate =  intent.getStringExtra("returnDate")
        val startDate =  intent.getStringExtra("startDate")
        tvDestination.text = destination
        tvCount.text ="$count"
        tvCost.text = "$cost"
        tvTotal.text = "${count * cost}"
        tvStartDate.text = "Date: $startDate"
        tvReturnDate.text = "Returning Date: $returnDate"
    }
}