package ru.borisov.bodymassindex

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var heightET: EditText
    lateinit var weightET: EditText
    lateinit var calculateBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        heightET = findViewById(R.id.heightET)
        weightET = findViewById(R.id.weightET)
        calculateBTN = findViewById(R.id.calculateBTN)
        calculateBTN.setOnClickListener {
            val height = heightET.text.toString().toDouble()
            val weight = weightET.text.toString().toDouble()
            val index = BodyMassIndex(height, weight).calculate()
            println(index)
            val intent = Intent(this, ResultBodyMassIndexActivity::class.java).apply {
                putExtra("index", index)
            }
            startActivity(intent)
        }
    }
}