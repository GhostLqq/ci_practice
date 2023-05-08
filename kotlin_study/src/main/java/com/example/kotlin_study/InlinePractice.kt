package com.example.kotlin_study

class InlinePractice {

    val name = "zhangsan"

    fun sayHaha(){
        sayHello()
    }

    inline fun sayHello(){
        println("hello $name")
    }

}

