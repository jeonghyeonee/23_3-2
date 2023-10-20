package com.example.hw03

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.hw03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val CALL_REQUEST_CODE = 1

    // Activity Result Launcher for dialing intent
    private val dialLauncher = registerForActivityResult(ActivityResultContracts.
    StartActivityForResult()) { result ->
        val resultCode = result.resultCode
        val data = result.data
        if (resultCode == RESULT_OK) {
            // Extract the phone number from the result
            val extractedPhoneNumber = data?.getStringExtra("phoneNumber")
            if(extractedPhoneNumber != null){
                val extractedPhoneNumber = data?.getStringExtra("phoneNumber")
                if (extractedPhoneNumber != null) {
                    // Display a Toast message indicating that calling is not possible
                    Toast.makeText(this,
                        "You can't call to $extractedPhoneNumber !!!!",
                        Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ViewBinding: Initialize ViewBinding for the activity
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        HW03 #2: New Version

        // Initialize the ActivityResultLauncher for dialing intent
        binding.callBtn.setOnClickListener {
            val phoneNum = binding.phoneNum.text.toString().trim()
            if (phoneNum.isNotEmpty()) {
                // Create a dialing intent with the provided phone number
                val dialIntent = Intent(Intent.ACTION_DIAL)
                dialIntent.data = Uri.parse("tel:$phoneNum")

                // Create a chooser dialog to select the app for dialing
                val chooser = Intent.createChooser(dialIntent, "Which app to use?")
                dialLauncher.launch(chooser)
            } else {
                // Display a Toast message if no phone number is entered
                Toast.makeText(this,
                    "Please enter a phone number",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }


/*//        HW03 #1
        // Set an onClickListener for the button
        binding.btnSay.setOnClickListener{
            // Check if the TextView is currently visible
            if (binding.txtSay.visibility == View.VISIBLE){
                // If it's visible, hide it
                binding.txtSay.visibility = View.INVISIBLE
            }
            else{
                // If it's not visible, make it visible
                binding.txtSay.visibility = View.VISIBLE
            }

        }*/

/*//        HW03 #2: Old Version
        binding.callBtn.setOnClickListener {
            // Retrieve the phone number from the input field and trim any extra spaces
            val phoneNum = binding.phoneNum.text.toString().trim()
            if(phoneNum.isNotEmpty()){

                // Create a dialing intent with the provided phone number
                val dialIntent = Intent(Intent.ACTION_DIAL)
                dialIntent.data = Uri.parse("tel:$phoneNum")

                // Create a chooser dialog to select the app for dialing
                val chooser = Intent.createChooser(dialIntent, "Which app to use?")

                // Start the dialing intent and await the result
                startActivityForResult(chooser,CALL_REQUEST_CODE)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Check if the result is from the dialing request
        if(requestCode == CALL_REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                // Extract the phone number from the intent
                val extractedPhoneNumber = data?.getStringExtra("phoneNumber")
                if(extractedPhoneNumber != null){
                    val extractedPhoneNumber = data?.getStringExtra("phoneNumber")
                    if (extractedPhoneNumber != null) {
                        // Display a Toast message indicating that calling is not possible
                        Toast.makeText(this, "You can't call to $extractedPhoneNumber !!!!", Toast.LENGTH_SHORT).show()
                    }

                }

            }

        }
    }*/


}