package com.example.changemaker

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.changemaker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Using View Binding to access UI elements
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    // Variable to store the entered amount in cents
    private var price = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Set up click listeners for number buttons
        setupClickListeners()

        // Set click listener for the Clear button to reset the entered amount
        binding.btnClear.setOnClickListener {
            resetPriceAndChange()
        }

        // Restore the entered amount and update the UI
        restoreInstanceState(savedInstanceState)
        updateDisplayedPrice()
        calculateChange()
    }

    // Set up click listeners for number buttons
    private fun setupClickListeners() {
        // Array of IDs for number buttons
        val numberButtonIds = arrayOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
            R.id.btn8, R.id.btn9
        )

        // Set onClickListener for each number button
        for (buttonId in numberButtonIds) {
            binding.root.findViewById<View>(buttonId).setOnClickListener(this)
        }
    }

    // Handle click events for number buttons
    override fun onClick(view: View?) {
        if (view != null) {
            // Extract the digit from the tag of the clicked button
            val digit = view.getTag()?.toString()?.toIntOrNull() ?: return
            // Update the entered amount with the clicked digit
            price = price * 10 + digit
            // Update the displayed amount and recalculate the change
            updateDisplayedPrice()
            calculateChange()
        }
    }

    // Reset the entered amount and update the UI
    private fun resetPriceAndChange() {
        price = 0
        updateDisplayedPrice()
        calculateChange()
    }

    // Calculate and display the change based on the entered amount
    private fun calculateChange() {
        var remaining = price

        // Calculate the number of each bill/coin and update the corresponding TextViews
        binding.d20.text = (remaining / 2000).toString(); remaining %= 2000
        binding.d10.text = (remaining / 1000).toString(); remaining %= 1000
        binding.d5.text = (remaining / 500).toString(); remaining %= 500
        binding.d1.text = (remaining / 100).toString(); remaining %= 100
        binding.c25.text = (remaining / 25).toString(); remaining %= 25
        binding.c10.text = (remaining / 10).toString(); remaining %= 10
        binding.c5.text = (remaining / 5).toString(); remaining %= 5
        binding.c1.text = remaining.toString()
    }

    // Update the displayed amount in dollars on the UI
    private fun updateDisplayedPrice() {
        binding.price.text = (price.toDouble() / 100).toString()
    }

    // Save the current entered amount during configuration changes
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("price", price)
    }

    // Restore the entered amount during configuration changes
    private fun restoreInstanceState(savedInstanceState: Bundle?) {
        price = savedInstanceState?.getInt("price", 0) ?: 0
    }
}
