package com.example.kotlin_study

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.core.app.ComponentActivity
import java.io.File
import javax.sql.DataSource

@SuppressLint("RestrictedApi")
class SealedClass : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val box = Box(20);
    }
}

sealed interface Error
sealed class IOError() : Error
class FileReadError(val file: File) : IOError()
class DatebaseError(val source: DataSource) : IOError()
object RuntimeError : Error


class Box<T>(t: T) {

}

fun demo(strs: Source<String>) {
    val objects: Source<Any> = strs
}

fun demo2(numbers: Comparable<Number>) {
    numbers.compareTo(1.0f)
    val y: Comparable<Int> = numbers
}

interface Source<out T> {
    fun nextT(): T
}

interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

