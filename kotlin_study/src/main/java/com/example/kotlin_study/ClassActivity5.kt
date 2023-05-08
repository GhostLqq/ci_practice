package com.example.kotlin_study

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity

class ClassActivity5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recatangle = Rectangle()
        printClassName(recatangle)

        val list = mutableListOf(1,2,3)
        list.lastIndex
    }

    open class Shape
    class Rectangle : Shape()

    fun Shape.getName() = "Shape"
    fun Rectangle.getName() = "Rectangle"

    fun printClassName(s: Shape) {
        Log.i(TAG, "${s.getName()}")
    }
}


fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

val <T> List<T>.lastIndex: Int
    get() = size - 1
