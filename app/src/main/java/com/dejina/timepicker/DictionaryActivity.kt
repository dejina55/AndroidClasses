package com.dejina.timepicker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText


import java.util.*

class DictionaryActivity : AppCompatActivity() {
    private val words = arrayOf("cat", "A type of domesticated animal belonging to feline families",
            "pizza", "A fast food item consisting mainly of dough, cheese and capsicum",
            "scaffold", "A type of support used during construction in order to build higher floors",
            "wardrobe", "A type of furniture where usually clothes and cosmetic items are stored",
            "python", "One of the subspecies of snake family")

    private lateinit var etWord : EditText
    private lateinit var btnMeaning : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dictionary)

        val wordsToMeaning = mutableMapOf<String, String>()

        for (i in words.indices step 2){
            wordsToMeaning[words[i]] = words[i + 1]
        }

        etWord = findViewById(R.id.etWord)
        btnMeaning = findViewById(R.id.btnMeaning)

        btnMeaning.setOnClickListener{
            var word = etWord.text.toString().toLowerCase(Locale.ROOT).trim()

            val intent = Intent(this, MeaningActivity::class.java)

            var meaning = wordsToMeaning[word].toString()

                intent.putExtra("word", word)
                intent.putExtra("meaning", meaning)

                startActivity(intent)

        }
        etWord.addTextChangedListener(object: TextWatcher {
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int) {
                btnMeaning.isEnabled = s.toString().trim { it <= ' ' }.isNotEmpty()
            }
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int,
                                           after:Int) {
                btnMeaning.isEnabled = false
            }
            override fun afterTextChanged(s: Editable) {
                // TODO Auto-generated method stub
            }
        })

    }
}