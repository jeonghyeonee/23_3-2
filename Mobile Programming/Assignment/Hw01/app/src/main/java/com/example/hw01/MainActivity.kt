package com.example.hw01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.lang.Math.random
import java.util.Arrays

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*//        HW1 #1
        val expression = "100 / 0"  //modify this line for test

//        implement here
//        split with white space
        val splitExpress = expression.split(" ")
//        type casting operands to Int type
        val op1: Int = splitExpress[0].toInt()
        val op2: Int = splitExpress[2].toInt()

//        the condition of each operator and assigned the results
        var result = when(splitExpress[1]){
            "+" -> op1 + op2
            "-" -> op1 - op2
            "*" -> op1 * op2
            "/" -> {
                when(op2){
                    0 -> "Cannot divide by zero"
                    else -> op1 / op2
                }
            }
            "%" -> {
                when(op2){
                    0 -> "Cannot divide by zero"
                    else -> op1 % op2
                }
            }

            else -> null
        }

        Log.d("HW01", "result: $result, (expression: $expression)")*/

        /*//        HW1 #2
        val capacity = 20 // modify this for test

//       implement here
        if(capacity<1 || capacity > 100) Log.d("HW01", "Please input the number less than 100 or positive number")

//        generate myUniqueArray
        var myUniqueArray: IntArray = IntArray(capacity)

        val myUniqueSet = mutableSetOf<Int>()

        while(myUniqueSet.size < capacity){
            myUniqueSet.add((1..100).random())
        }

        myUniqueArray = myUniqueSet.toIntArray()

        Log.d("HW01", "result: ${Arrays.toString(myUniqueArray)}, capacity: $capacity")*/


        /*//        HW1 #3
        val strLine = "Exit" // initialize string array with string lines

        *//* Following is an example set of string lines
        "Seoul National University of Science and Technology",
        "Seoul Station",
        "IT Management",
        "Android and Kotlin is not that difficult",
        "Exit"
        *//*

// implement here
        var leng = strLine.split(" ")
        Log.d("HW01", "The number of words is ${leng.size}")*/

/*
//        HW1 #4

        var str = "I Love Kotlin" // modify this for test
        Log.d("HW01", str)

// implement here
        val len = str.length

        for (i in 1..len) {
            val sb = StringBuilder()
            var j = i  // Current index in str
            var k = 0  // Current index in temp

            // Copying the second part from the point
            // of rotation.
            for (k2 in j until str.length) {
                sb.insert(k, str[j])
                k++
                j++
            }

            // Copying the first part from the point
            // of rotation.
            j = 0
            while (j < i) {
                sb.insert(k, str[j])
                j++
                k++
            }

            Log.d("HW01","$sb")

        }
*/

/*//        HW1 #5
        val str = "WoWoW" // modify this for test

        var tmp = ""
//        Initializing a new boolean variable for the answer
        var ans = false

        for (i in str.length-1 downTo 0){
            tmp += str[i]
        }

//        Checking if both the strings are equal
        if(str == tmp){
            ans = true
        }

        when(ans){
            true -> Log.d("HW01", "$str is palindrome!")
            else -> Log.d("HW01", "$str is Not palindrome!")
        }*/

/*//        HW1 #6
        val testNum = 99;

// implement here

        val tmp = testNum.toString()

        if(tmp[0] == tmp[1])  Log.d("HW01", "Yes! two numbers are same! (Number: $testNum)")
        else  Log.d("HW01", "No! two numbers are NOT same! (Number: $testNum)")*/

//        HW1 #7

        val sequence = "abcabcdefabc"

        // implement here
//        Creating Map containing char as a key and occurrences as a value
        val charCountMap = mutableMapOf<Char, Int>()

        val strArray = sequence.toCharArray()

//        Checking each char of strArray
        for (c in strArray){
            if(charCountMap.containsKey(c)){
                charCountMap[c] = charCountMap[c]!! + 1
            }
            else{
                charCountMap[c] = 1
            }
        }

        for((key, value) in charCountMap){
            Log.d("HW01", "$key: $value")
        }


    }

}