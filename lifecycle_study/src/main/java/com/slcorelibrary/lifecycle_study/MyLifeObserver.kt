package com.slcorelibrary.lifecycle_study

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyLifeObserver :LifecycleObserver{
    companion object{
        var TAG = "Lifecycler_Test"
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_RESUME)
    fun connect(){
        Log.i(TAG, "connect: ")
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_PAUSE)
    fun  disConnect(){
        Log.i(TAG, "disConnect: ")
    }

}

