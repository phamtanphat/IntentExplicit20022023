package com.example.intentexplicit20022023

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var tvScore: TextView
    private lateinit var imgRandom: ImageView
    private lateinit var imgPick: ImageView
    private lateinit var arrNameAnimals: List<String>
    private var resourceRandom = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvScore = findViewById(R.id.text_view_score)
        imgRandom = findViewById(R.id.image_view_random)
        imgPick = findViewById(R.id.image_view_pick)

        randomImage()
        eventView()
    }

    private fun eventView() {
        imgPick.setOnClickListener {
            val intent = Intent(this@MainActivity, ListAnimalActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val resourcePick = result.data?.getIntExtra("resource", -1)
            if (resourcePick == null || resourcePick == -1) return@registerForActivityResult
            imgPick.setImageResource(resourcePick)
            if (resourceRandom == resourcePick) {
                Toast.makeText(this, "Chính xác", Toast.LENGTH_SHORT).show()
                randomImage()
            } else {
                Toast.makeText(this, "Bạn đã chọn sai", Toast.LENGTH_SHORT).show()
            }
        }
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
        resourceRandom = resources.getIdentifier(nameAnimalRandom, "drawable", packageName)
        imgRandom.setImageResource(resourceRandom)
    }
}
