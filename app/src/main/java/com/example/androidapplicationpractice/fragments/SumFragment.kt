package com.example.androidapplicationpractice.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.androidapplicationpractice.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SumFragment : Fragment() {

    // Mine
    private lateinit var etFirst: EditText
    private lateinit var etSecond: EditText
    private lateinit var btnCalc: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sum, container, false)
        etFirst = view.findViewById(R.id.etFirst)
        etSecond = view.findViewById(R.id.etSecond)
        btnCalc = view.findViewById(R.id.btnCalc)
        btnCalc.setOnClickListener {
            val result = etFirst.text.toString().toInt() + etSecond.text.toString().toInt()
            Toast.makeText(context, "$result", Toast.LENGTH_SHORT).show()
        }
        return view
    }

}