package com.example.intentexplicit20022023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

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

        randomImage()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_random -> randomImage()
        }
        return true
    }

    private fun randomImage(){
        arrNameAnimals = resources.getStringArray(R.array.array_animal).toList()
        val indexRandom = Random.nextInt(arrNameAnimals.size)
        val nameAnimalRandom = arrNameAnimals[indexRandom]
        val imageResource = resources.getIdentifier(nameAnimalRandom, "drawable", packageName)
        imgRandom.setImageResource(imageResource)
    }
}
