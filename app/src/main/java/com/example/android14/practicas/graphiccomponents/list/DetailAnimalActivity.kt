package com.example.android14.practicas.graphiccomponents.list

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android14.R
import com.squareup.picasso.Picasso

class DetailAnimalActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_animal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.title = "Animal Seleccionado"

        val animal = getAnimalFromIntent()

        if (animal != null) {
            val tvAnimalName = findViewById<TextView>(R.id.tvAnimalName)
            val ivAnimalImage = findViewById<ImageView>(R.id.ivAnimalDetail)

            tvAnimalName.text = animal.name
            Picasso.get().load(animal.image).into(ivAnimalImage)
        }
    }

    private fun getAnimalFromIntent(): AnimalEntity? {
        val key = "EXTRA_ANIMAL"
        return intent.getSerializableExtra(key) as? AnimalEntity
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}