package com.myfirstapp

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val findBeer = findViewById<Button>(R.id.find_beer) //create varible, findViewById<Button>(give the type of element).Give the ID
        findBeer.setOnClickListener {
            val beerColor = findViewById<Spinner>(R.id.beer_color)
            val color = beerColor.selectedItem.toString()
            val beerList = getBeers(color.toString())
            val beers = beerList.reduce{str, item -> str +'\n'+item}
            val brands = findViewById<TextView>(R.id.brands)
            brands.text = beers
        }
    }
    fun getBeers (color: String): List<String>{
        return when (color){
            "Light" -> listOf("Jail Pale Ale", "Lager Lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else -> listOf("Got Stout", "Dark Daniel")
        }
    }
}
