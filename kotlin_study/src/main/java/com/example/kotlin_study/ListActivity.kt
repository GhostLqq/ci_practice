package com.example.kotlin_study

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class ListActivity : AppCompatActivity() {
    companion object {
        const val TAG = "ListActivity"
    }

    val arrayList = ArrayList<String>()
    val linkedList = LinkedList<String>()
    val hashSet = HashSet<String>()
    val hashMap = HashMap<String, String>()

    // 创建不可变集合
    val list = listOf<Int>(1, 2, 3)
    val set = setOf<Int>(1, 2, 3)
    val map = mapOf<Int,String>(1 to "zhangsan", 2 to "lisi")

    // 创建可变集合
    val mutableList = mutableListOf<Int>(1, 2, 3)
    val mutableSet = mutableSetOf<Int>(1, 2, 3)
    val mutableMap = mutableMapOf(1 to "zhangsan", 2 to "lisi")


    override fun onCreate(savedInstanceState: Bundle?) {
        (super.onCreate(savedInstanceState))
        setContentView(R.layout.activity_list)

        Log.i(TAG, list[1].toString())
        // 角标越界不会抛出异常，而是返回一个null
        Log.i(TAG, list.getOrNull(3).toString())
        // 角标越界，返回相应值
        Log.i(TAG, (list.getOrNull(3) ?: -1).toString())
        // 角标越界，返回lambda中的值
        val value = list.getOrElse(3) {
            -1
        }
        Log.i(TAG, value.toString())

        // 可变集合
        mutableList.set(1, 2)
        mutableList[1] = 2

        // add 操作
        mutableList.add(4)
        mutableList += 5

        // remove 操作
        mutableList.remove(5)
        mutableList -= 5
        // 根据lambda表达式进行操作
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mutableList.removeIf { it == 4 }
            mutableList.removeIf {
                it == 5
            }
        }

        // 集合遍历
        for (item in list) {
            Log.i(TAG, item.toString())
        }
        list.forEach {
            Log.i(TAG, it.toString())
        }
        list.forEachIndexed { index, i ->
            Log.i(TAG, "$index---$value")
        }

        // set 集合操作
        mutableSet += 4
        mutableSet -= 4
        mutableSet.remove(3)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mutableSet.removeIf {
                it == 4
            }
        }
        // list 和 set 相互转换
        val list = mutableSet.toList()
        val set = mutableList.toSet()

        // map 的get操作
        map[1]?.let { Log.i(TAG, it) }
        Log.i(TAG, map.getValue(1))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Log.i(TAG, map.getOrDefault(1,"default"))
        }
        Log.i(TAG, map.getOrElse(1){
            "default"
        })
        // map 的遍历
        map.forEach{ it ->
            Log.i(TAG, "${it.key}---${it.value}")
        }
        map.forEach { (key, value ) ->
            Log.i(TAG, "$key---$value")
        }
        // map 的增删
        mutableMap+=3 to "haha"
        mutableMap[4] = "gaga"
    }
}