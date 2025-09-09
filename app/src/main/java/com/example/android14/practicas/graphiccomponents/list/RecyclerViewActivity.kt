package com.example.android14.practicas.graphiccomponents.list

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android14.R

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportActionBar?.hide()

        val list = findViewById<RecyclerView>(R.id.list)

        val data = listOf(AnimalEntity("Leon","Amarillo","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU"),
            AnimalEntity("Armadillo","Cafe","https://lagodechapala.org/wp-content/uploads/2022/02/Armadillo.jpg"),
            AnimalEntity("Tigre", "Naranja", "https://images.pexels.com/photos/30730860/pexels-photo-30730860/free-photo-of-retrato-en-primer-plano-de-un-tigre-siberiano-en-la-nieve.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"),
            AnimalEntity("Elefante", "Gris", "https://files.worldwildlife.org/wwfcmsprod/images/African_Elephant_Walking/story_carousel/3arzfzjsw0_Medium_WW1113482.jpg"),
            AnimalEntity("Jirafa", "Amarillo", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmdoImgd6JXi0yHgqkJyXmMNB8_Lo0oUzXSA&s"),
            AnimalEntity("Oso Pardo", "Café","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-Y5KxJ6pJH8Ng63IF_UAUJwwpOr3oN4K2dA&s"),
            AnimalEntity("Cebra", "Blanco y Negro","https://cdn0.bioenciclopedia.com/es/posts/6/1/2/cebra_216_orig.jpg"),
            AnimalEntity("Mono", "Café","https://monkeyworlds.com/wp-content/uploads/human-monkey.webp"),
            AnimalEntity("Rinoceronte", "Gris","https://static.nationalgeographicla.com/files/styles/image_3200/public/nationalgeographic2791108.jpg?w=1900&h=1425"),
            AnimalEntity("Pingüino", "Blanco y Negro","https://static.nationalgeographicla.com/files/styles/image_3200/public/mm1012723121410486.webp?w=760&h=1140"))

        val adapter = AnimalAdapter(data)

        adapter.onItemSelected ={
            //TODO Mandar a llamar un activity y pasar la info de animalEntity(it) y enseñarlo en lugar Toast
            val intent = Intent(this, DetailAnimalActivity::class.java)
            intent.putExtra("EXTRA_ANIMAL", it)
            startActivity(intent)

        }

        list.adapter = adapter
        //list.layoutManager = GridLayoutManager(this, 2)
        list.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)

    }
}