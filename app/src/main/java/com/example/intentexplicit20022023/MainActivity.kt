package com.example.intentexplicit20022023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvScore: TextView
    private lateinit var imgRandom: ImageView
    private lateinit var imgPick: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvScore = findViewById(R.id.text_view_score)
        imgRandom = findViewById(R.id.image_view_random)
        imgPick = findViewById(R.id.image_view_pick)
    }
}
