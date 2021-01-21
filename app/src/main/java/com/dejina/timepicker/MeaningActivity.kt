package com.dejina.timepicker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.dejina.timepicker.R
import java.util.*

class MeaningActivity : AppCompatActivity() {
    private lateinit var tvWord : TextView
    private lateinit var tvMeaning : TextView

    @ExperimentalStdlibApi
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meaning)

        tvWord = findViewById(R.id.tvWord)
        tvMeaning = findViewById(R.id.tvMeaning)

        if(intent != null){


            val word = intent.getStringExtra("word")
            val meaning = intent.getStringExtra("meaning")

            if (meaning != "null") {
                tvWord.text = "The meaning of ${word?.capitalize(Locale.ROOT)} is:"
                tvMeaning.text = meaning.toString()
            }
            else{
                tvMeaning.text = "Sorry, our app doesn't have the meaning of this word :("
            }
        }
        else{
            tvMeaning.text = "Sorry, our app doesn't have the meaning of this word :("
        }
    }
}