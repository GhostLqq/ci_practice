package com.example.kotlin_study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class GenericClassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val pkg = Package(Phone("IPhone"))
        println(pkg.openPackage())
        println(
            pkg.getProductName {
                it.name
            }
        )

        val pkg2 = Package(Apple("好吃"))
        println(pkg2.openPackage())
        println(
            pkg2.getProductName {
                it.name
            }
        )

        val pkg3 = Package2(Apple("gaga"))
        val pkg4 = Package2(Banana("gaga"))
    }
}

// 范型类
class Package<T>(t: T) {
    private val product: T = t

    // 范型方法
    fun openPackage(): T {
        return product
    }

    // 多参数范型函数
    fun <R> getProductName(block: (T) -> R): R {
        return block(product)
    }
}


class Package2<T : Friut>(t: T) {
    private val product: T = t

    fun openPackage(): T {
        return product
    }

    fun <R> getProductName(block: (T) -> R): R {
        return block(product)
    }
}

class Phone(var name: String)
open class Friut(val name: String) {

}

class Apple(name: String) : Friut(name) {

}

class Banana(name: String) : Friut(name) {

}