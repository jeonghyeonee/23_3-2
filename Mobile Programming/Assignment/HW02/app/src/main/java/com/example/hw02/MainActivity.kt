package com.example.hw02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.lang.IllegalStateException
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*//        HW02 #1
        val math = 100			// modify these scores for test
        val science = 100			// modify these scores for test
        val english = 90                  // modify these scores for test

        val me = Grade(math, science, english)
        Log.d("ITM","my math: $math, my science: $science, my english: $english")
        Log.d("ITM","Average is ${me.average()}")*/

/*//        HW02 #2
        val p = Point(5,5)
        p.x=10
        p.y=20
        p.show()

        val cp = ColorPoint(5, 5, "YELLOW")
        cp.setPoint(10, 20)
        cp.color = "GREEN"
        cp.y=100
        cp.show()*/

/*//        HW02 #3
        val item1 = Item(name="jinwoo1").apply{
            share = 100
            price = 500
        }

//        HW02 #4
        val random = Random()

        val myList: MutableList<Item> = mutableListOf()

//        Generate 10 items with random prices
        for(i in 0..10){
            val itemName = "jinwoo$i"
            val item = Item(name = itemName).apply {
                share = 100
                price = random.nextInt(1001)
            }
            myList.add(item)
        }

//        Log teh name and price of each item in the itemList
        myList.forEach{
            Log.d("ITM", "Name: ${it.name} Price: ${it.price}")
        }

//        HW02 #5
//        Log the items in the itemList with prices greater than 500 using fileter
//        Log.d("ITM", "${myList.filter{it.price > 500}}")


//        HW02 #6
        val str = myList.run {

            // sort the list
            // return the string representation of the list

            // Sort the myList by "price'
            this.sortBy { it.price }
            // Convert the sorted list to a string representation
            toString()

        }.also {

            // print the list contents with capital letters
            // Print the string representation in Uppercase
            Log.d("ITM", it.uppercase())

        }*/

/*//            HW02 #7
        val address1 = "Nooooooo!!"
        val address2 = null
        val address3 = "jinw.jeong@seoultech.ac.kr"

        sendEmail(address1)
        sendEmail(address2)
        sendEmail(address3)*/

/*//        HW02 #8
        draw_pyramid(5)*/

//        HW02 #9
        val cart = ShoppingCart()

        val product1 = Product("Jean", 50.0)
        val product2 = Product("Jean", 100.0)
        val product3 = Product("Jean", 80.0)
        val product4 = Product("Shoes", 70.0)
        val product5 = Product("Pants", 90.0)
        val product6 = Product("GPU", 2000.0)

        cart.addProduct(product1)
        cart.addProduct(product2)
        cart.addProduct(product3)
        cart.addProduct(product4)
        cart.addProduct(product5)
        cart.addProduct(product6)
        cart.calculateTotalPrice()

        cart.removeProduct("Jean")
        cart.calculateTotalPrice()

        cart.removeProduct("Shoes")
        cart.calculateTotalPrice()



    }

}

// HW02 #1
class Grade(math: Int, science: Int, english: Int){
//    Use Array to use the function "average"
    var score = arrayOf(math, science, english)

    fun average(): Int{
        if(score.isEmpty()){
            throw IllegalStateException("No Grade! You have to input grade!")
        }
//        Average function is return the "Double" type, so convert to "Int" type
        return score.average().toInt()
    }
}

// HW02 #2
open class Point(open var x: Int, open var y: Int) {
    fun move(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

    open fun show(){
        Log.d("ITM","Current Point: ($x, $y)")
    }
}

class ColorPoint(x: Int, y:Int, color: String) : Point(x, y){
    override var y: Int = y
        set(value){
            field = value
            Log.d("ITM","Y has been changed to $field")
        }

//    Set the Points
    fun setPoint(x: Int, y: Int){
        move(x, y)
    }
//    Override the show function to display color and Current Point
    var color = ""
    override fun show(){

        Log.d("ITM","Color:$color Current Point: ($x, $y)")
    }
}

// HW02 #3
data class Item(val name: String){
//    Initialization to execute when an instance of Item is created
    init{
        Log.d("ITM", "$name item was created")
    }

// Declare properties for price and share with custom setters
    var price: Int = 0
        set(value) {
            field = value       // Update the property value
            Log.d("ITM", "price set to $value. Are you serious?")
        }
    var share: Int = 0

}

// HW02 #7
fun sendEmail(email: String?){
    // Regular expression to validate email addresses
    val regexEamil = Regex("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")

    // Initialize a flag to track whether the eamil is valid
    var flag: Boolean = true

    flag = email?.matches(regexEamil) ?: false

    if(flag){
        Log.d("ITM", "Email sent to $email")
    }else Log.d("ITM", "Failed to send email. Please enter a valid email address")

}

// HW02 #8
fun draw_pyramid(floor: Int){
    val pyramid = StringBuilder().run {

        // draw pyramid using a loop (e.g., for, while, repeat)
        // Initialize a string to store the pyramid pattern
        var result = ""

        // Loop to draw the pyramid
        for(i in 1..floor){
            // Add spaces before start on each row
            for (space in 1..floor - i){
                result +=  " "
            }

            // Add stars on each row
            for (star in 1..(2 * i - 1)){
                result += "*"
            }

            // Add spaces after stars on each row
            for (j in 1..floor-i){
                result += " "
            }

            // Move to the next lines for the next row of the pyramid
            result += "\n"
        }
        Log.d("ITM", result)
    }
    println(pyramid)
}

// HW02 #9
class Product(val name: String, val price: Double)

class ShoppingCart {
    val cartItem = mutableListOf<Product>()

    // Add a product to the shopping cart
    fun addProduct(product: Product){
        cartItem.add(product)
        Log.d("ITM", "Add ${product.name} (${product.price}) to Shopping Cart")
    }

    // Remove all products matching the product name from the shopping cart
    fun removeProduct(productName: String){
        // Filter products with the specified name
        val removeProduct = cartItem.filter{it.name == productName}

        // Calculate the total price of removed products
        val removePrice = removeProduct.sumOf { it.price }

        Log.d("ITM", "Remove $productName ($removePrice) from Shopping Cart")

        // Remove all products with the specified name from the cart
        cartItem.removeIf{it.name == productName}
    }

    // Calculate the total price of all products in the cart
    fun calculateTotalPrice() {
        // Calculate the totla price of all products in the cart
        val total = cartItem.sumOf { it.price }.toDouble()

        Log.d("ITM", "Total Price: $total")

    }
}

