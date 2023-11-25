package com.example.midterm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.collections.List
import kotlin.random.Random
import kotlin.collections.List as Int

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*        val row = 1
        var col = 3

        var x: IntArray = intArrayOf(row)
        var y: IntArray = intArrayOf(col)

        for (j in 0..row){
            x.set(j, Random.nextInt())
        }
        
        for ( i in 0..row){
            for (j in 0..col){
                y.set(j, Random.nextInt())
            }
            x.set(i, y)
        }

        Log.d("ITM", "${y.toString()}")*/

        // #7

        val alice_pantry = mutableMapOf("egg" to 8, "cup of sugar" to 4, "cup of flour" to 4)
        val bob_pantry = mutableMapOf("egg" to 12, "cup of sugar" to 4, "cup of flour" to 5)

//        val recipes1 = mutableMapof<String, Map<String, Int>>()
//
//
//
        val recipes = mutableMapOf(
            "dusty cake" to mutableMapOf("cup of sugar" to 4, "cup of flour" to 4),
            "eggy cake" to mutableMapOf("egg" to 1),
            "eggier cake" to mutableMapOf("egg" to 100),
            "mega egg" to mutableMapOf("egg" to 100),
            "chocolate cake" to mutableMapOf("egg" to 2, "cup of sugar" to 2, "chocolate" to 1)
        )

        Log.d("ITM", "${alice_pantry}")
        Log.d("ITM", "${recipes}")




    }

    fun myList(col: Integer) {
        val col = col.toInt()
        val items:IntArray = intArrayOf(col)


        for (i in 0..col.toInt()){
            var tmp = Random.nextInt()
            items.set(i, tmp)
        }

        Log.d("ITM", "${items.toString()}")
    }


}

private fun IntArray.set(index: Int, value: IntArray) {

}

class ListItem (cnt: Int) {
    val cnt = 0
    private val items = mutableListOf<Integer>()

    fun addElements(){
        for(j in 0..cnt){
            var tmp = Random.nextInt()
            items.add(tmp)
        }
    }

}


fun get_bakeable(){

}


