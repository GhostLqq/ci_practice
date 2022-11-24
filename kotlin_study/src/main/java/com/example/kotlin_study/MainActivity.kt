package com.example.kotlin_study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var items = listOf("zhangsan","lisi","wangwu")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("${maxOf(1, 2)}")

        items.forEach{
            println(it)
        }

        for (item in items) {
            println(item)
        }

        for (index in items.indices){
            println()
        }
    }

    class Rectangle(var heigh: Int, var length: Double) {
        var perimeter = (heigh + length) * 2
    }

    fun maxOf(a: Int, b: Int) = if (a > b) a else b
}