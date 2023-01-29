package com.example.kotlin_study

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ClassActivity : AppCompatActivity() {
    companion object {
        const val TAG = "ListActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val person = Person1()
        person.name = "张三"
        Log.i(TAG, person.name)
        Log.i(TAG, person.age.toString())
    }
}

class Person1 {
    // 针对每一个属性，都有一个field进行封装
    // 针对非private属性，都会生成一对getter和setter方法
    // 可以自定义getter和setter方法
    var name = ""
        get() = field.plus("_01")
        set(value) {
            field = value.uppercase()
        }

    // 针对val的属性，kotlin不提供setter方法
    val age = 0
        get() = field + 1

    // 对于private属性，kotlin不提供getter和setter方法
    // 虽然我们可以重写，但是外界无法访问，跟Java区别很大
    private var subject = ""
        get() = field.plus("gaga")
        set(value) {
            field = value
        }
}

// 定义在class 类名后的构造函数，是类的主构造函数
// 在主构造函数中，可以使用临时变量给类属性复制，为了方便识别，在kotlin中，临时变量通常会以下划线开头_属性名
// 也可以在主构造函数中，可以同事定义临时变量和类属性，要加上var或val修饰符
// 还可以在属性后直接设置默认值，创建对象时，默认参数可以不传
// 执行顺序：主构造函数、类属性、初始化代码块、次构造函数
class Person2(_name: String, var age: Int, var subject: String = "kotlin") {

    // lateinit 这个关键字，实现延迟初始化，属性在声明时，不需要赋值
    // 使用之前需要初始化
    lateinit var hobby: String

    // 通过lazy 可以实现惰性初始化
    // 属性声明时不必赋值，使用这个属性时，会自动初始化
    val lazy by lazy {
        lazyInit()
    }

    var name = _name
        get() = field.plus("_01")
        set(value) {
            field = value.lowercase()
        }

    // 次构造函数
    constructor(_name: String, age: Int) : this(_name, age, "java") {
        this.name = _name.trim()
    }

    // 无参次构造函数
    constructor() : this("", 1, "")

    // 初始化代码块
    init {
        require(age > 0) {
            "age must be >0"
        }
        require(name.isNotEmpty()) {
            "name can not be empty"
        }
    }

    fun initHobby() {
        hobby = "game"
    }

    fun isInit(): Boolean {
        return ::hobby.isInitialized
    }

    private fun lazyInit():Boolean{
        return true
    }
}