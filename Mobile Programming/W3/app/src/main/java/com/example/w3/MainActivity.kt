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
/*class InitOrderDemo(name: String){
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
}*/

/*// OOP: Properties
class Address{
    var name: String = "default"
        get() = field + "!!!!!!!"
        set(value) {field = value+", Korea"}
    val street: String = "Baker"
    val city: String = "London"
    val state: String? = null
    var zip: String = "123456"
}*/

/*// Object and Companion Object
object ITM{
    val numStudents = 60
    fun print(){
        Log.d("ITM", "we don't love Kotlin")
    }
}

class IE{
    companion object{
        val numStudents = 30
        fun print(){
            Log.d("ITM", "we don't like Kotlin")
        }
    }

    fun graduate(){
        Log.d("ITM", "No. Go to graduate school!")
    }
}*/

/*// Data Class
data class User(val name: String, val age: Int)*/

//// Inheritance
//open class Shape{
//    open fun draw(){/*...*/}
//    fun fill(){/*...*/}
//    open val count = 2
//}
//
//class Circle : Shape(){
//    override val count = 0
//    override fun draw() {
//        /*...*/
//    }
////    override fun fill(){/*...*/}      // it is not 'open' keyword
//}
//
//class Rectangle: Shape() {
//    override val count = 4
//}
//
//open class Base(val name: String){
//    init {
//        Log.d("ITM", "Initializing a base class")
//    }
//    open val size: Int =
//        name.length.also { Log.d("ITM", "Initializing size in teh base class: $it") }
//}
//
//class Derived(name: String, val lastName: String):
//        Base(name.replaceFirstChar{it.uppercase()}.also { Log.d("ITM", "Argument for the base class: $it") }){
//            init {
//                Log.d("ITM", "Initializing a derived class")
//            }
//
//            override val size: Int =
//                (super.size + lastName.length).also { Log.d("ITM", "Initializing size in teh derived class: $it") }
//        }

// Scope Function: apply
data class Person(var name: String, var age: Int=0, var city: String = "")

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

//        val instance = InitOrderDemo(20)
//        val instance2 = InitOrderDemo2(20)

/*        // Properties
        var addr = Address()
        Log.d("ITM", addr.name)
        addr.name = "no"
        Log.d("ITM", addr.name)*/

/*        // Object and Companion Object
        Log.d("ITM", "${ITM.numStudents}")
        ITM.print()         // Possible! Why? Object

//        IE.graduate() > Error (class) => you should instance
        Log.d("ITM", "${IE.numStudents}")
        IE.print()

        val myIE = IE() // instance of class!!!!!
        myIE.graduate()*/

/*        // Data Class
        val uData = User("jinwoo", 38)
        Log.d("ITM", uData.toString())
        val uData2 = uData.copy(age=28)
        Log.d("ITM", "this is real: ${uData2.toString()}")*/


/*        // Inheritance

        Derived("jinwoo", "jeong")*/

/*        // Null Safety
        var a: String = "abc" // Regular initialization means non-null by default
//        a = null // compilation error
        val l = a.length // it's guaranteed not to cause an NPE

        var b: String? = "abc" // can be set to null
        b = null // ok
        print(b)

        // Explicit Check
//        val l = b.length // error: variable 'b' can be null
        val l2 = if (b != null) b.length else -1

        // More Complex Example
        val c: String? = "Kotlin"
        if (c != null && c.length > 0){
            print("String of length ${c.length}")
        }else{
            print("Empty string")
        }

        // Safe calls
        val d = "null"
        val e: String? = "string"
        Log.d("ITM", "${(e?.length)}")
        Log.d("ITM", "${(d?.length)}")      // Unnecessary safe call

        // Elvis Operator
        val l3: Int = if (b != null) b.length else -1
        val l4 = b?.length ?: -1*/

        // Scope Functions
/*        // let
        val numbers = mutableListOf("one", "two", "three", "four", "five")
        val resultList = numbers.map {it.length}.filter {it > 3}
        Log.d("ITM", "$resultList")

        numbers.map {it.length}.filter {it>3}.let{
            Log.d("ITM", "$it")     // use 'it' parameters
            Log.d("ITM", "${it.size}")
            Log.d("ITM", "${it[0]}")
            // and more function calls if needed
        }*/

/*        // with
        val numbers = mutableListOf("one", "two", "three", "four", "five")
        with(numbers){
            Log.d("ITM", "with' is called with argument $this")     // not 'it' parameter
            Log.d("ITM", "It contains $size elements")
            Log.d("ITM", "It contains ${this.size} elements")// this can be skipped
        }*/

/*        // run: Extension Function
        val service = MultiportService("https://example.kotlinlang.org", 80)

        val result = service.run{
            port = 8080
            query(prepareRequest() + " to port $port")
        }

        // the same code written with let() function:
        val letResult = service.let{
            it.port = 8080
            it.query(it.prepareRequest() + " to port ${it.port}")
        }*/

/*        // run: Non-extension Function
        val hexNumberRegex = run{
            val digits = "0-9"
            val hexDigits = "A-Fa-f"
            val sign = "+-"

            Regex("[$sign]?[$digits$hexDigits]+")
        }

        for (match in hexNumberRegex.findAll("+1234 -FFFF not-a-number")){
            Log.d("ITM", match.value)
        }*/

/*        // apply
        val adam = Person("Adam").apply {
            age = 32
            city = "London"
//            this.age = 32         // can omit the 'this'
//            this.city = "London"
        }

        Log.d("ITM", adam.toString())*/

/*        // also
        val numbers = mutableListOf("one", "two", "three")
        numbers
            .also { Log.d("ITM", "The list elements before adding new one: $it") }
            .apply{
                add("four")
                Log.d("ITM", "$this")
            }*/

/*        // Scope Function: Output Distinction
        // Context Object
        val numberList = mutableListOf<Double>()
        numberList.also { Log.d("ITM", "Populating the list, length: ${it.size}") }
            .apply {
                add(2.71)
                Log.d("ITM", "Sorting the list, length: $size")
                add(3.14)
                add(1.0)
            }
            .also { Log.d("ITM", "Sorting the list, length: ${it.size}") }
            .sort()

        Log.d("ITM", "$numberList")*/

        // Lambda Result
        val numbers = mutableListOf("one", "two", "three")
        val countEndsWithE = numbers.run{
            add("four")
            add("five")
            count { it.endsWith("e") }
        }

        Log.d("ITM", "There are $countEndsWithE elements that end with e")
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