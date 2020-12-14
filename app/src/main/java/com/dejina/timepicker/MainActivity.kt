package com.dejina.timepicker

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var btnLoadTimePicker: Button
    private lateinit var tvTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLoadTimePicker = findViewById(R.id.btnLoadTimePicker)
        tvTime = findViewById(R.id.tvTime)

        btnLoadTimePicker.setOnClickListener{
            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minute = c.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(
                this, TimePickerDialog.OnTimeSetListener{ _: TimePicker?, hourOfDay: Int, minute: Int ->

                    if (hourOfDay in 0..12) {
                        tvTime.text = "$hourOfDay : $minute am"
                    }
                    if (hourOfDay in 13..23) {
                        tvTime.text = "${hourOfDay-12} : $minute pm"
                    }
                },
                hour, minute, true
            )
            timePickerDialog.show()
    }
    }
}
