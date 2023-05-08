package com.example.kotlin_study

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.core.app.ComponentActivity

@SuppressLint("RestrictedApi")
class CopyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val user = User("zhangsan1", 20)
        user.copy(age = 20)
        val (name, age) = user
        print("$name,$age years of age")
    }
}

data class User(val name: String, val age: Int)

fun copy(name: String, age: Int) = User(name, age)