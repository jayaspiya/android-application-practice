package com.example.androidapplicationpractice.fragments

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

/**
 * A simple [Fragment] subclass.
 * Use the [AreaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AreaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var etRadius: EditText
    private lateinit var btnCalc: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_area, container, false)
        etRadius = view.findViewById(R.id.etRadius)
        btnCalc = view.findViewById(R.id.btnCalc)
        btnCalc.setOnClickListener {
            val radius = etRadius.text.toString().toInt()
            val result = 22/7 * radius * radius
            Toast.makeText(requireActivity(), "$result", Toast.LENGTH_SHORT).show()
        }
        return view
    }


}