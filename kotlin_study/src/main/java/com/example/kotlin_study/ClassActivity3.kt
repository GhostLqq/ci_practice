package com.example.kotlin_study

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class ClassActivity3 : AppCompatActivity() {
    val TAG = "ClassActivity3----"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var recatangle = Recatangle1(20, 30)
//        recatangle.height = 20
//        Log.i(TAG, "Recatangle1.area = ${recatangle.area} ")

//        val myInterfaceImpl1 = MyInterfaceImpl1()
//        myInterfaceImpl1.prop = 50
//        val myInterfaceImpl2 = MyInterfaceImpl2()
//        Log.i(TAG, "myInterfaceImpl1.prop = ${myInterfaceImpl1.prop} ")
//        Log.i(TAG, "myInterfaceImpl2.prop = ${myInterfaceImpl2.prop} ")

        val isEven = object : IntPredicate {
            override fun accept(i: Int) = i % 2 == 0
        }

        var accept = isEven.accept(4)


        printer {

        }
    }

    fun copyAddress(address: Address): Address {
        val result = Address()
        result.name = address.name
        result.stree = address.stree
        return result
    }

    fun printer(block: () -> Unit): Printer = object : Printer {
        override fun print() = block()
    }
}


class Address {
    var name: String = "Hello"
    var stree: String = "Baker"
    var city: String = "Lodon"
    var state: String? = null
    var zip: String = "123456"
}

class Recatangle1(val width: Int, var height: Int) {
    val area get() = width * height
}

interface MyInterface {
    var prop: Int

    val propertyWithImplementation: String
        get() = "foo"

    fun Prop() {
        print(prop)
    }
}

class MyInterfaceImpl1() : MyInterface {
    override var prop: Int = 20
        set(value) {
            field = value
        }
}

class MyInterfaceImpl2() : MyInterface {
    override var prop: Int = 30
}

interface IntPredicate {
    fun accept(i: Int): Boolean
}


interface Printer {
    fun print()
}