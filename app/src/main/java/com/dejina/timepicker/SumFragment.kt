package com.dejina.timepicker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.dejina.timepicker.R

class SumFragment : Fragment() {
    private lateinit var et1 : EditText
    private lateinit var et2 : EditText
    private lateinit var btnAdd : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sum, container, false)

        et1 = view.findViewById(R.id.et1)
        et2 = view.findViewById(R.id.et2)
        btnAdd = view.findViewById(R.id.btnAdd)

        btnAdd.setOnClickListener{
            addNumbers()
        }

        return view
    }

    private fun addNumbers(){
        Toast.makeText(context, "The sum is ${et1.text.toString().toInt() + et2.text.toString().toInt()}",
        Toast.LENGTH_SHORT).show()
    }

}