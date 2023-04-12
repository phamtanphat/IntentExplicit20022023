package com.example.intentexplicit20022023

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow

class ListAnimalActivity : AppCompatActivity() {

    private lateinit var tableLayout: TableLayout
    private lateinit var arrNameAnimals: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_animal)

        tableLayout = findViewById(R.id.table_layout)

        arrNameAnimals = resources.getStringArray(R.array.array_animal).toList()

        val totalColumn = 3
        val totalRow = 6

        for (row in 0 until totalRow) {
            val tableRow = TableRow(this)
            for (column in 0 until totalColumn) {
                val image = ImageView(this)
                val nameAnimal = arrNameAnimals[((totalColumn * row) + column)]
                val imageResource = resources.getIdentifier(nameAnimal, "drawable", packageName)
                image.setImageResource(imageResource)
                tableRow.addView(image)
            }
            tableLayout.addView(tableRow)
        }
    }

}
