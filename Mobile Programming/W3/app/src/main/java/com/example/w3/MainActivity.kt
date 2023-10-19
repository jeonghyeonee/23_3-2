package com.example.w3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.Arrays

// OOP: Constructor
/*class InitOrderDemo(val name: String){
    val firstProperty = "First property: $name"     // Property initializer

    init{
        Log.d("ITM", "First initializer block that prints ${name}")     // Initializer block
        Log.d("ITM", "First initializer block that prints ${firstProperty}")     // Initializer block
    }

    val secondProperty = "Second property: ${name.length}"

    init{
        Log.d("ITM", "Second Initializer block that prints ${name.length}")
        Log.d("ITM", "Second Initializer block that prints ${secondProperty.length}")
    }

    fun print() {
//        Log.d("ITM", "$name")     // Error -> So you have to val/var in header
        Log.d("ITM", "$name")
    }

}*/

// Constructors Example
class InitOrderDemo(name: String){
    val firstProperty = "First Property: $name"

    init{
        Log.d("ITM", "First Initializer block that prints ${name}")
    }

    val secondaryProperty = "Second property: ${name.length}"

    constructor(age: Int): this("hey"){
        Log.d("ITM", "Secondary constructor block that prints ${age}")
    }
}

class InitOrderDemo2{
    init{
        Log.d("ITM", "Init body")
    }

    constructor(age: Int){
        Log.d("ITM", "Secondary constructor block that prints ${age}")
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Function
        // Unit
        /*printHello("Hey!")
        printHello(null)*/

/*        // Lambda
        val sum: (Int, Int) -> Int = {x, y -> x+y}
        Log.d("ITM", "${sum(3,5)}")

        // you must declare type of parameters
        val sum2 = {x: Int, y: Int -> x+y}
        Log.d("ITM", "${sum2(3,5)}")*/

        /*// it
        val ints = IntArray(5) {it*2}
        val newInts = ints.filter{
            Log.d("ITM", "")
            it > 0
//            true
        }

        Log.d("ITM", Arrays.toString(ints))
        Log.d("ITM", "$newInts")*/

/*        // Example: Lambda

        val sum = {x: Int, y:Int -> x+y}
        val multiply:(Int, Int) -> Unit = {x, y ->
            Log.d("ITM", "x * y = ${x * y}")
        }

        Log.d("ITM", "by lambda: ${sum(2, 3)}")
        Log.d("ITM", "by function: ${sum1(2, 3)}")
        multiply(3,4)
        Log.d("ITM", highOrderFun({x:Int, y: Int -> x.toString() + y.toString()}))*/

        // OOP: Constructor
//        InitOrderDemo("Jinwoo")
//        InitOrderDemo("jinwoo").print()

        val instance = InitOrderDemo(20)
        val instance2 = InitOrderDemo2(20)

    }

    // Functions
    // Unit
    fun printHello(name: String?): Unit{
        if(name != null)
            Log.d("ITM", "Hello $name")
        else
            Log.d("ITM", "Hi there!")
        // 'return Unit' or 'return' is optional
    }

    // Example: Lambda
    fun sum1 (x: Int, y:Int) : Int{
        return x+y
    }

    fun highOrderFun(f:(Int, Int) -> (String)): String{
        return f(2,3)
    }
}