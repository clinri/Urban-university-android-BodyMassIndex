package ru.borisov.bodymassindex

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class ResultBodyMassIndexActivity : AppCompatActivity() {
    lateinit var indexTV: TextView
    lateinit var bodyTypeIV: ImageView
    lateinit var descriptionTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_body_mass_index)
        val index = intent.getDoubleExtra("index", 0.0)
        indexTV = findViewById(R.id.indexTV)
        bodyTypeIV = findViewById(R.id.bodyTypeIV)
        descriptionTV = findViewById(R.id.descriptionTV)
        indexTV.text = String.format(Locale.getDefault(), "%.1f", index)
        bodyTypeIV.setImageResource(
            when {
                index in 0.0..18.5 -> R.drawable.thin
                index in 18.5..25.0 -> R.drawable.normal
                index > 25.0 -> R.drawable.fat
                else -> throw Exception("Invalid index")
            }
        )
        descriptionTV.text = assets
            .open(
                when {
                    index in 0.0..18.5 -> "thin"
                    index in 18.5..25.0 -> "normal"
                    index > 25.0 -> "fat"
                    else -> throw Exception("Invalid index")
                }
            )
            .bufferedReader()
            .use { it.readText() }
    }
}