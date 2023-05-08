package com.example.kotlin_study

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_study.FilledRectangle.Filler

const val TAG = "ClassActivity2----"

class ClassActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Log.i(TAG, "Constructing the derived class(\\\"hello\\\", \\\"world\\\")")
//        Dervid("hello", "world")

//        var fr = FilledRectangle()
//        var filler = fr.Filler()
//        filler.drawFilling()

        var square = Square()
        square.draw()

    }
}

open class Base(val name: String) {
    init {
        Log.i(TAG, "Initializing a base class")
    }

    open val size: Int = name.length.also { Log.i(TAG, "Initializing size in the base class: $it") }
}

class Dervid(name: String, val lastName: String) : Base(name.replaceFirstChar { it.uppercase() }
    .also { Log.i(TAG, "Argument for the base class: $it") }) {

    init {
        Log.i(TAG, "Initializing a derived class")
    }

    override val size: Int = (super.size + lastName.length).also {
        Log.i(TAG, "Initializing size in the derived class: $it")
    }
}


// 内部类访问外部类的超类,可以使用由外部雷鸣限定的 super 关键字来实现:super@Outer
open class Recatangle {
    open fun draw() {
        Log.i(TAG, "Drawing a rectangle")
    }

    val borderColor: String get() = "black"
}

class FilledRectangle : Recatangle() {
    override fun draw() {
        super.draw()
        Log.i(TAG, "Filling the rectangle")
    }
    
    inner class Filler{
        fun fill(){
            Log.i(TAG, "Filling")
        }
        fun drawFilling(){
            // 内部类调用外部类方法
            this@FilledRectangle.draw() // 调用 FilledRectangle 的 draw() 方法
            // 内部类调用外部类的超类方法
            super@FilledRectangle.draw() // 调用 Rectangle 的 draw() 方法
            fill()
            Log.i(TAG, "Drawn a filled rectangle with color ${super@FilledRectangle.borderColor}")
        }
    }

    val fillColor: String get() = super.borderColor
}

interface  Polygon{
    fun draw(){
        Log.i(TAG, "Polygon draw: ")
    }
}

class Square():Recatangle(),Polygon{
    override fun draw() {
        super<Recatangle>.draw()
        super<Polygon>.draw()
    }
}
