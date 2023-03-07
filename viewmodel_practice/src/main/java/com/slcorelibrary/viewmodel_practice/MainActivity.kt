package com.slcorelibrary.viewmodel_practice

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.slcorelibrary.viewmodel_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var binding = ActivityMainBinding.inflate(layoutInflater)

        var viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        var viewModel2 = ViewModelProvider(this)[MainViewModel::class.java]

        val viewModel3: MainViewModel by viewModels()
    }
}