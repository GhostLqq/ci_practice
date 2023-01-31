package com.example.kotlin_study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ExtendMethodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        "haha".addExtention()
        "haha".easyPrint()

    }

}

// 扩展string函数
fun String.addExtention() = "kotlin".plus(this)
fun String.easyPrint() = print(this)

// 扩展自自定义类的函数
fun Apple.name() = "apple name".plus(this.name)

// 扩展范型函数
fun <T> T.easyPrint() {
    println(this)
}

// 扩展属性计算字符串"a"的个数
val String.aCount
    get() = count { "a".contains(it) }