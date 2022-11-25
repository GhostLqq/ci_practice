package com.example.kotlin_study

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.lang.IllegalArgumentException
import java.util.*

class MainActivity : AppCompatActivity() {

    var fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    var ints = listOf(-1, 2, 3)
    var map = mapOf("a" to 1, "b" to 2, "c" to 3)

    val p: String by lazy {
        ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("${maxOf(1, 2)}")

        val a = 1
        val b: Long? = a.toLong()

    }

    fun transform(color: String) = when (color) {
        "red" -> 1
        "blue" -> 2
        "green" -> 3
        else -> throw IllegalArgumentException("Invalid color param value")
    }

    fun String.spaceToCamelCase() {

    }

    val myObject = object : MyAbstractClass() {
        override fun doSomething() {
            TODO("Not yet implemented")
        }

        override fun sleep() {
            TODO("Not yet implemented")
        }
    }
}

abstract class MyAbstractClass {
    abstract fun doSomething()
    abstract fun sleep()
}

class Turle {
    fun openDown() {}
    fun penUp() {}
    fun turn(degrees: Double) {}
    fun forward(pixels: Double) {}
}