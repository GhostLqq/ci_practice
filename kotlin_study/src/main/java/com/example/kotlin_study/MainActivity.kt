package com.example.kotlin_study

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    var fruits = listOf("banana", "avocado", "apple", "kiwifruit")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("${maxOf(1, 2)}")

        fruits.filter {
            it.startsWith("a")
        }.sortedBy {
            it
        }.map {
            it.uppercase()
        }.forEach {
            Log.d("liuqianqian", it)
        }
    }
}