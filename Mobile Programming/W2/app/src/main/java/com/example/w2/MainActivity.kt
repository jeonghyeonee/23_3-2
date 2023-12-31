package com.example.w2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.Arrays

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        LogCat

        Log.d("ITM", "I am  Jeonghyeon Lee")

//        String Template
        val i = 10
        Log.d("ITM", "i = $i")      // prints "i=10"

        val s = "abc"
        Log.d("ITM", "$s.length is ${s.length}")    //prints "abc.length is 3

//        Variable and Constant
        var x = 5   // 'Int' type is inferred
        x += 1
        Log.d("ITM", "$x")      //prints "6"

        var x2: Int
        x2 = 30
        Log.d("ITM", "$x2")      //prints "6"

        val a: Int = 1  // immediate assignment
        val b = 2       //'Int' type is inferred
        val c: Int      // Type required when no initializer is provided
        c = 3           // deferred assignment
//        you can not be reassigned val variable!
//        c = 5

//        Conditional Expressions : if statement
        var a1 = 20
        var b1 = 10

        val max = if (a1 > b1){
            Log.d("ITM", "Choose A!")
            a1
        }
        else{
            Log.d("ITM", "Choose B!")
            b1
        }

        Log.d("ITM", "higher value was $max!")
        if (max > 10) Log.d("ITM", "Hmm~ smells good!")


//        Conditional Expressions : when statement
        val grade = "A+"
        when(grade){
            "A+" -> Log.d("ITM", "Oh.. great..!!!")
            "B+" -> Log.d("ITM", "Hey?")
            else -> {
                Log.d("ITM", "I don't know who you are.")
            }
        }

//        Conditional Expressions : when statement with comma
        val grade1 = "F"
        when(grade1){
            "A+", "B+", "C+" -> Log.d("ITM", "Oh.. great..!!!")
            "A", "B", "C" -> Log.d("ITM", "Hey?")
            else -> {
                Log.d("ITM", "I don't know who you are.")
            }
        }

//        Conditional Expressions : when statement range check
        val score = 89
        when(score){
            in 90..100 -> Log.d("ITM", "A+")
            else -> Log.d("ITM", "resit!!!!")
        }

//        Conditional Expressions : when statement without a parameter
        val score2 = 55
        when{
            score2 > 90 -> Log.d("ITM", "A+")
            score2 in 50..89 -> Log.d("ITM", "A0")
            else -> Log.d("ITM", "resit!!!!")
        }

//        Conditional Expressions : when statement type checking(is syntax)
        val x3:Any = 20.5
        when (x3){
            is Int -> Log.d("ITM", "It's Int type")
            is String -> Log.d("ITM", "It's String type!")
            else -> Log.d("ITM", "What is this?")
        }

//        Conditional Expressions : when statement as expression
        val myScore = 80
        var myGrade = when (myScore){
            in 90..100 -> "A+"
            else -> "F"
        }
        Log.d("ITM", "my score is $myScore, so my grade is $myGrade")

//        Array
        val x4: IntArray = intArrayOf(1, 2, 3)      // use these values to create intArray
        val y4 = arrayOf("one", "two", "three")
        val arr = IntArray(5)                   // create IntArray with size of 5
        val arr2 = IntArray(5) {42}             // create IntArray with size of 5, values of 42
        var arr3 = IntArray(5) {it + 1}         // create IntArray with size of 5, values of index + 1
        var arr4 = Array(5){i -> i*i}

        Log.d("ITM", Arrays.toString(x4))
        Log.d("ITM", Arrays.toString(y4))
        Log.d("ITM", Arrays.toString(arr))
        Log.d("ITM", Arrays.toString(arr2))
        Log.d("ITM", Arrays.toString(arr3))
        Log.d("ITM", Arrays.toString(arr4))


//        Array: Some utilities
        val arr5: IntArray = IntArray(10) {it + 1}
        val first = arr5[0]
        val first2 = arr5.first()
        val first3 = arr5.get(0)
        val last = arr5.last()

        Log.d("ITM", "${Arrays.toString(arr5)}")
        Log.d("ITM", "first: $first $first2 $first3 last: $last")

        arr5[0] = 100
        arr5.set(1, 200)

        Log.d("ITM", "${Arrays.toString(arr5)}")

        arr5.sort()                             // in -place sorting
        val arr6 = arr5.sortedArrayDescending() // return a new sorted array (desc.)

        Log.d("ITM", "${Arrays.toString(arr5)}")
        Log.d("ITM", "${Arrays.toString(arr6)}")

//        Loop: for
        for(i in 1..3){
            Log.d("ITM", "$i")
        }

        for(i in 6 downTo 0){
            Log.d("ITM", "$i")
        }

        for(i in 1..1 step 3){
            Log.d("ITM", "$i")
        }

        for (i in 6 downTo 0 step 2){
            Log.d("ITM", "$i")
        }

        for (i in 1 until 11 step 2){
            Log.d("ITM", "$i")
        }

        val arr7 = IntArray(5) {it+1}

        for (i in arr7){
            Log.d("ITM", "$i")
        }

        for((index, i) in arr7.withIndex()){
            Log.d("ITM", "$index's value = $i")
        }

        arr7.forEach { Log.d("ITM", "$it") }

//        Loop: while & do-while
        for(i in 1..10){
            Log.d("ITM", "$i")
        }

        var num = 1
        while (num <= 10){
            Log.d("ITM", "$num")
            num++
        }

        var num2 = 1
        do{
            Log.d("ITM", "$num2")
            num2++
        }while(num2<=10)

//        continue & break with labes

//        for(i in 1..3){
//            for(j in 1..5){
//                if(j%2 == 0) continue   // break
//                Log.d("ITM", "$i, $j")
//            }
//        }

        outer@ for (i in 1..3){
            for(j in 1..5){
                if(j%2 == 0) continue@outer     //break@outer
                Log.d("ITM", "$i, $j")
            }
        }

        // List
        val numbers = listOf("one", "two", "three", "four")
        Log.d("ITM", "Number of elements: ${numbers.size}")
        Log.d("ITM", "Third of elements: ${numbers.get(2)}")
        Log.d("ITM", "Fourth of elements: ${numbers[3]}")
        Log.d("ITM", "Index of element \"two\": ${numbers.indexOf("two")}")

        // mutableList
        val numbers2 = mutableListOf(1,2,3,4)
        numbers2.add(5)
        numbers2.removeAt(1)
        Log.d("ITM", "${numbers2}")

        numbers2[0] = 0
        numbers2.shuffle()
        Log.d("ITM", "${numbers2}")

        // Set
        val numbers3 = setOf(1,2,3,4)
        Log.d("ITM", "Number of elements: ${numbers3.size}")
        if(numbers3.contains(1)) Log.d("ITM", "1 is in the set")

        val numbersBackward = setOf(4,3,2,1)
        Log.d("ITM", "The sets are equal: ${numbers3 == numbersBackward}")

        // mutableSet
        val depts = mutableSetOf("ITM")
        Log.d("ITM", "Number of elements: ${depts.size}")
        Log.d("ITM", "${depts}")

        depts.add("IISE")
        depts.add("AIX")
        depts.add("Computer")
        Log.d("ITM", "${depts}")

        depts.remove("Data science")
        depts.remove("IISE")
        Log.d("ITM", "${depts}")

        // Map
        val studentGrade = mutableMapOf<String, Int>()
        studentGrade.put("Jeong", 100)
        studentGrade.put("Kim", 90)
        studentGrade.put("Hong", 80)
        studentGrade.put("Park", 70)

        val studentGrade2 = mutableMapOf<String, Int>("Jeong" to 100, "Kim" to 90, "Hong" to 80, "Park" to 70)
        val studentGrade3 = mutableMapOf<String, Int>(Pair("Jeong", 100), Pair("Kim", 90), Pair("Hong", 80), Pair("Park", 70))

        Log.d("ITM", "${studentGrade}")

        Log.d("ITM", "${studentGrade.get("Jeong")}")
        Log.d("ITM", "${studentGrade.get("Wow")}")

        studentGrade.put("Jeong", 0)
        Log.d("ITM", "${studentGrade}")

        // Transformation
        // map
        val numbers4 = setOf(1,2,3,4,5)
        val numbers5 = numbers4.map{it*2}

        Log.d("ITM", "${numbers4}")
        Log.d("ITM", "${numbers5}")

        val studentGrade4 = mutableMapOf<String, Int>()
        studentGrade4.put("Jinwoo", 100)
        studentGrade4.put("Kim", 90)
        studentGrade4.put("Hong", 80)
        studentGrade4.put("Park", 70)

        val grade2 = studentGrade4.mapValues { it.value / 10 }
        Log.d("ITM", "${grade2}")

        // zip
        val colors = listOf("red", "brown", "grey")
        val animals = listOf("fox", "bear", "wolf")
        Log.d("ITM", "${colors zip animals}")

        val twoAnimals = listOf("fox", "bear")
        Log.d("ITM", "${colors.zip(twoAnimals)}")

        Log.d("ITM", "${colors.zip(animals) {color, animal -> "The ${color.replaceFirstChar { it.uppercase() }} is $animal"}}")

        // filter
        val numbers6 = listOf("one", "two", "three", "four")
        val longerThan3 = numbers6.filter{ it.length > 3 }
        Log.d("ITM", "$longerThan3")

        val numbersMap = mapOf("key 1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
        val filterMap = numbersMap.filter { (key, value) -> key.endsWith("1")&&value > 10 }
        Log.d("ITM", "$filterMap")


        // Retrieval
        // first()/last()

        val numbers7 = listOf("one", "two", "three", "four", "five", "six")
        Log.d("ITM", numbers7.first {it.length > 3})
        Log.d("ITM", numbers7.last {it.startsWith("f")})

        val numbers8 = listOf(1,2,3,4)
        Log.d("ITM", "${numbers8.find {it % 2 == 0}}")
        Log.d("ITM", "${numbers8.findLast { it % 2 == 0 }}")

        // Aggregate
        val numbers9 = listOf(6, 42, 10, 4)

        Log.d("ITM", "Count: ${numbers9.count()}")
        Log.d("ITM", "Max: ${numbers9.maxOrNull()}")
        Log.d("ITM", "Min: ${numbers9.minOrNull()}")
        Log.d("ITM", "Average: ${numbers9.average()}")
        Log.d("ITM", "Sum: ${numbers9.sum()}")

        // Iterator
        val numbers10 = listOf("one", "two", "three", "four")
        val numbersIterator = numbers10.iterator()
        while (numbersIterator.hasNext()){
            Log.d("ITM", numbersIterator.next())
        }

    }
}