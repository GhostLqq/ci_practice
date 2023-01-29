package com.example.kotlin_study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class InterfaceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
    }
}

interface Flyable {
    var hour: Int
    var speed: Int
    fun fly(): Int
}

// 可以参数中，复写接口定义的属性
class Bird(override var speed: Int) : Flyable {
    // 可以在属性中复写接口定义的属性
    override var hour: Int
        get() = 0
        set(value) {}

    override fun fly() = speed * hour
}

// 抽象类
abstract class IBird : Flyable {

}

class BigBird(override var speed: Int, override var hour: Int) : IBird() {
    override fun fly(): Int {
        return speed * hour
    }
}