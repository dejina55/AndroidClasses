package com.dejina.timepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


import com.example.timepicker.SumFragment


class FragmentActivity : AppCompatActivity() {
    private lateinit var btnSum : Button
    private lateinit var btnArea : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        btnSum = findViewById(R.id.btnSum)
        btnArea = findViewById(R.id.btnArea)

        btnSum.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.layoutFragment, SumFragment())
                addToBackStack(null)
                commit()
            }
        }

        btnArea.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.layoutFragment, AreaOfCircleFragment())
                addToBackStack(null)
                commit()
            }
        }
    }
}