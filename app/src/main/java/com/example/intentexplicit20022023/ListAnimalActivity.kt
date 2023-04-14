package com.example.intentexplicit20022023

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.math.ceil

class ListAnimalActivity : AppCompatActivity() {

    private lateinit var tableLayout: TableLayout
    private lateinit var arrNameAnimals: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_animal)

        tableLayout = findViewById(R.id.table_layout)

        arrNameAnimals = resources.getStringArray(R.array.array_animal).toList().shuffled()

        val totalColumn = 3
        val totalRow = ceil((arrNameAnimals.size / 3.0f)).toInt()

        if (arrNameAnimals.isNotEmpty()) {
            Loop1@for (row in 0 until totalRow) {
                val tableRow = TableRow(this)
                val tableLayoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                tableLayoutParams.marginStart = 15
                tableLayout.layoutParams = tableLayoutParams
                for (column in 0 until totalColumn) {
                    val index = ((totalColumn * row) + column)
                    if (index >= arrNameAnimals.size) break@Loop1
                    val image = ImageView(this)
                    val layoutParams: TableRow.LayoutParams = TableRow.LayoutParams(350, 350)
                    image.layoutParams = layoutParams
                    val nameAnimal = arrNameAnimals[index]
                    val imageResource = resources.getIdentifier(nameAnimal, "drawable", packageName)
                    image.setImageResource(imageResource)
                    image.setOnClickListener {
                        val intent = Intent(this@ListAnimalActivity, MainActivity::class.java)
                        val resource = resources.getIdentifier(arrNameAnimals[index], "drawable", packageName)
                        intent.putExtra("resource", resource)
                        setResult(RESULT_OK, intent)
                        finish()
                    }
                    tableRow.addView(image)
                }
                tableLayout.addView(tableRow)
            }
        }
    }
}
