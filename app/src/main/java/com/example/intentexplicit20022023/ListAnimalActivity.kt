package com.example.intentexplicit20022023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import kotlin.math.ceil

class ListAnimalActivity : AppCompatActivity() {

    private lateinit var tableLayout: TableLayout
    private lateinit var arrNameAnimals: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_animal)

        tableLayout = findViewById(R.id.table_layout)

        arrNameAnimals = resources.getStringArray(R.array.array_animal).toList()

        val totalColumn = 3
        val totalRow = ceil((arrNameAnimals.size / 3.0f)).toInt()

        if (arrNameAnimals.isNotEmpty()) {
            Loop1@for (row in 0 until totalRow) {
                val tableRow = TableRow(this)
                for (column in 0 until totalColumn) {
                    val index = ((totalColumn * row) + column)
                    if (index >= arrNameAnimals.size) break@Loop1
                    val image = ImageView(this)
                    val nameAnimal = arrNameAnimals[index]
                    val imageResource = resources.getIdentifier(nameAnimal, "drawable", packageName)
                    image.setImageResource(imageResource)
                    tableRow.addView(image)
                }
                tableLayout.addView(tableRow)
            }
        }
    }
}
