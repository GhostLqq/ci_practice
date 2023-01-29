package com.example.kotlin_study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class OtherClassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val mouse = Computer.Mouse("Logitech")
        //可以通知嵌套类的实例，访问其定义的属性和函数
        mouse.showDescribe()
        println(mouse.name)

        val e1 = MotionEvent(10, 10)
        val e2 = MotionEvent(10, 10)
        println(e1)
        println(e1.toString())
        // 数据类的==是判断的equals方法，比较的是内容，而不是对象引用
        println(e1 == e2)
        // 数据类支持解构
        val (x, y) = e1
        println("$x,$y")

        val dog = Dog("hanmeimei", 18)
        val (name: String, age: Int) = dog
        println("$name,$age")


    }
}

// 嵌套类
class Computer {
    class Mouse(val name: String) {
        fun showDescribe() {
            println("mouse name is $name")
        }
    }
}

// 数据类
data class MotionEvent(var x: Int, var y: Int) {

}

// 解构声明
class Dog(val name: String, val age: Int) {
    operator fun component1() = name
    operator fun component2() = age
}

enum class Week(){
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;

    fun getDay(): String {
        return when (this) {
            SUNDAY -> "星期天"
            MONDAY -> "星期一"
            TUESDAY -> "星期二"
            WEDNESDAY -> "星期三"
            THURSDAY -> "星期四"
            FRIDAY -> "星期五"
            SATURDAY -> "星期六"
        }
    }
}
