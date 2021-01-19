package com.dejina.countrycapital
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import com.dejina.timepicker.R
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintStream

class MainActivity : AppCompatActivity() {

    private lateinit var etCountry: EditText
    private lateinit var etCapital: EditText
    private lateinit var btnadd: Button
    private lateinit var listview: ListView
    val countryCapitalMap= mutableMapOf<String,String>()

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etCountry = findViewById(R.id.etCountry)
        etCapital = findViewById(R.id.etCapital)
        btnadd = findViewById(R.id.btnadd)
        listview = findViewById(R.id.listview)

        loadCountriesFromText()
        btnadd.setOnClickListener {
            addCountryToText()
            loadCountriesFromText()
            etCountry.text.clear()
            etCapital.text.clear()
        }

    }
    private fun addCountryToText(){
        try {
            val country = etCountry.text.toString()
            val capital = etCapital.text.toString()
            val printStream = PrintStream(
                    openFileOutput(
                            "Country.txt",
                            Context.MODE_APPEND
                    )
            )
            printStream.println("$country -> $capital")
            Toast.makeText(
                    this,"$country saved", Toast.LENGTH_SHORT).show()

        }catch (e: IOException) {
            Toast.makeText(this,"Error ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun loadCountriesFromText(){
        try{
            val fileInputStream = openFileInput("Country.txt")
            val inputStream = InputStreamReader(fileInputStream)
            val bufferedReader = BufferedReader(inputStream)
            for(line in bufferedReader.lines()){
                val countryCapital = line.split(" -> ")
                val country = countryCapital[0]
                val capital = countryCapital[1]
                countryCapitalMap[country]=capital
            }
            displayCountries(countryCapitalMap)
        }catch (e:IOException){
            Toast.makeText(this,"Error ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun displayCountries(countryCapitalMap:MutableMap<String,String>){
        val adapter = ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                countryCapitalMap.keys.toTypedArray()
        )
        listview.adapter = adapter
    }
}
