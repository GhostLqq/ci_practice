package com.example.kotlin_study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ClassActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var isEven: IntPredicate1 = { it % 7 == 0 }
        isEven(7)

        var isHaha: IntPredicate2 = { i, b ->
            false
        }
    }
}

typealias IntPredicate1 = (i: Int) -> Boolean

typealias IntPredicate2 = (i: Int, b: Boolean) -> Boolean