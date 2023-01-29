package com.example.kotlin_study

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.IllegalArgumentException
import java.util.*
import java.util.jar.Attributes
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class MainActivity : AppCompatActivity() {
    val TAG = "liuqianqian"

    // 匿名函数赋值
    val sayHello: () -> String = {
        "你好明天"
    }

    // 匿名函数带有参数
    val sayHello2: (String) -> String = { name ->
        "你好$name"
    }

    val sayHello3: (String, Int) -> String = { name, age ->
        "你好,我是$name,今年${age}岁了"
    }

    // 匿名函数类型推断
    val sayHello4 = {
        "2023年还能买房吗"
    }

    val sayHello5 = { name: String, age: Int ->
        "你好,我是$name,今年${age}岁了"
    }

    val happyNewYear = { name: String, year: Int ->
        "${name},happy ${year}!"
    }

    fun sayHi(name: String, happyNewYear: (name: String, year: Int) -> String) {
        val year = 2022
        Log.i(TAG, happyNewYear(name, year))
    }

    fun sayHaHa(): (String) -> String {
        return {
            val year = 2022
            "$it happy $year"
        }
    }

    private var listActivity: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listActivity = findViewById(R.id.listActivity)
        initView()


//        Log.i(TAG, sayHello())
//        Log.i(TAG, sayHello2("zhangsan"))
//        Log.i(TAG, sayHello3("赵四", 18))
//        Log.i(TAG, sayHello4())
//        Log.i(TAG, sayHello5("李四", 25))
//
//        sayHi("李梅", happyNewYear)
//
//        sayHi("哈哈", happyNewYear = { name: String, year: Int ->
//            "${name},happy ${year}!"
//        })
//
//        sayHi("嘎嘎") { name: String, year: Int ->
//            "${name},happy ${year}!"
//        }
//
//        val haha = sayHaHa()
//        Log.i(TAG, haha("格格"))
    }

    private fun initView() {
        listActivity?.setOnClickListener {
            var intent = Intent(this@MainActivity, ListActivity::class.java)
            startActivity(intent)
        }
    }
}

