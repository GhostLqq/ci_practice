package com.example.kotlin_study

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class ObjectActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        Duck.idCard
    }
}

object AppConfig{
    init {
        Log.i("haha", "AppConfig init ...")
    }
}

class Duck(val name:String){
    companion object{
        var idCard = ""
        init {
            idCard = "XXX"
            println("companion init")
        }
        fun getId(): String {
            return idCard
        }
    }
}