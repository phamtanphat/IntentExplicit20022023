package com.example.intentexplicit20022023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvScore: TextView
    private lateinit var imgRandom: ImageView
    private lateinit var imgPick: ImageView
    private lateinit var arrNameAnimals: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvScore = findViewById(R.id.text_view_score)
        imgRandom = findViewById(R.id.image_view_random)
        imgPick = findViewById(R.id.image_view_pick)

        arrNameAnimals = resources.getStringArray(R.array.array_animal).toList()
        val nameAnimalIndex0 = arrNameAnimals[1]
        val imageResource = resources.getIdentifier(nameAnimalIndex0, "drawable", packageName)
        imgRandom.setImageResource(imageResource)
    }
}
