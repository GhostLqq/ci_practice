package com.example.kotlin_study

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import androidx.activity.ComponentActivity

class ClassActivity6 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

//        BaseCaller().call(Base1())
//        DerivedCaller().call(Base1())
//        DerivedCaller().call(Derived())

        var webView = findViewById<WebView>(R.id.wv)
        webView.loadUrl("https://kcai-dev.siling-tech.com/")
    }
}

open class Base1 {

}

class Derived : Base1() {

}

open class BaseCaller {
    open fun Base1.printFunctionInfo() {
        Log.i(TAG, "Base extension function in BaseCaller")
    }

    open fun Derived.printFunctionInfo() {
        Log.i(TAG, "Derived extension function in BaseCaller")
    }

    fun call(b: Base1) {
        b.printFunctionInfo()
    }
}

class DerivedCaller : BaseCaller() {
    override fun Base1.printFunctionInfo() {
        Log.i(TAG, "Base extension function in DerivedCaller")
    }

    override fun Derived.printFunctionInfo() {
        Log.i(TAG, "Derived extension function in DerivedCaller")
    }
}