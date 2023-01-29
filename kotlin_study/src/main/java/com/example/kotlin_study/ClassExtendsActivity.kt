package com.example.kotlin_study

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ClassExtendsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val student = Student("Hello")
        Log.i("Haha", (student is Person).toString())
        Log.i("Haha", (student is Student).toString())
    }
}

// kotlin中，类默认都是封闭的close的，如果让某个类开放继承，必须用open关键字修饰
// 类中的方法也是默认关闭的，如果需要子类复写父类的方法，也必须使用open关键字修饰
open class Person(val name: String) {
    var age = 0
    open fun doWork() {
        Log.i("Haha", "doWork: ")
    }
}

class Student(name: String):Person(name){
    override fun doWork() {
        Log.i("Haha", "doHomeWork: ")
    }
}