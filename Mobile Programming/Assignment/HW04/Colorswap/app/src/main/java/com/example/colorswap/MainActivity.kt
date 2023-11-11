package com.example.colorswap

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.colorswap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Declare a lateinit variable for View Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set a click listener for the color button
        binding.colorBtn.setOnClickListener { changeColor() }
    }

    // Function to change the color when the button is clicked
    private fun changeColor() {
        // Generate a random color
        val randomColor = generateRandomColor()

        // Create a string with the RGB values
        val colorText = "COLOR: ${Color.red(randomColor)}r, " +
                "${Color.green(randomColor)}g, " +
                "${Color.blue(randomColor)}b"

        // Set the text and text color of the TextView
        binding.colorTextView.text = colorText
        binding.colorTextView.setTextColor(randomColor)
    }

    // Function to generate a random color
    private fun generateRandomColor(): Int {
        // Generate random values for red, green, and blue components
        val randomR = (0..255).random()
        val randomG = (0..255).random()
        val randomB = (0..255).random()

        // Create and return the color using RGB values
        return Color.rgb(randomR, randomG, randomB)
    }
}