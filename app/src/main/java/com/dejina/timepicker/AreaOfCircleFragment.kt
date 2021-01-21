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


class AreaOfCircleFragment : Fragment() {
    private lateinit var etRadius : EditText
    private lateinit var btnCal : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_area_of_circle, container, false)

        etRadius = view.findViewById(R.id.etRadius)
        btnCal = view.findViewById(R.id.btnCal)

        btnCal.setOnClickListener{
            findArea()
        }

        return view
    }

    private fun findArea(){
        Toast.makeText(context, "The area of circle is ${(22 * etRadius.text.toString().toFloat() *
                etRadius.text.toString().toFloat()) / 7}", Toast.LENGTH_SHORT).show()
    }

}