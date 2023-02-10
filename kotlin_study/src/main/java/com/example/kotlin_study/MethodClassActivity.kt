package com.example.kotlin_study

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MethodClassActivity : AppCompatActivity() {

    val listString = listOf("zhangsan","lisi","wangwu")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

//        stringMapper("haha") {
//            it.length
//        }
//
//        stringMapper("gaga", ::stringLengthInner)

//        var stringMapperFunction = stringMapperFunction("gegaege")
//        var invoke = stringMapperFunction.invoke("agege")
//        Log.i("liuqianqian", "onCreate: $invoke")


//        var it = "zhangsan".let {
//            it.plus("zhangsan")
//        }
//
//        Log.i("liuqianqian", "onCreate: $it")


//        var length = "zhangsan".apply {
//            this.plus("gege")
//        }.length
//        Log.i("liuqianqian", "onCreate: $length")

//        var length = "zhangsan".run {
//            this.plus("haha")
//        }.length
//        Log.i("liuqianqian", "onCreate: $length")

//        var last = listString.last

        test()
    }

    private fun test(){
        hightLevelFunction("android"){
            it.length
            return
        }
        Log.d("TestInline", "tested")
    }

    private inline fun hightLevelFunction(input:String,mapper:(String)->Int):Int{
        return mapper(input)
    }


    val stringLengthFunc: (String) -> Int = { input ->
        input.length
    }

    val printTime: () -> Unit = {
        Log.i("zhangsan", "current:${System.currentTimeMillis()}")
    }

    val stringLength: Int = stringLengthFunc("Android")

    fun generateAnswerString1(count: Int, countThreshold: Int): String {
        return if (count > countThreshold) {
            "I have the answer."
        } else {
            "The answer eludes me."
        }
    }

    fun generateAnswerString2(count: Int, countThreshold: Int) =
        if (count > countThreshold) {
            "I have the answer."
        } else {
            "The answer eludes me."
        }

    fun stringMapper(input: String, mapper: (String) -> Int): Int {
        return mapper(input)
    }

    fun stringLengthInner(input: String) = input.length

    fun stringMapperFunction(input: String): (String) -> Int {
        return {
            val newString = it.substring(
                input.indexOf("a")
            )
            newString.length
        }
    }
}

val <T> List<T>.last: T get() = get(size - 1)