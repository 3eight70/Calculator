package com.example.calc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var binding=ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.myButton.setOnClickListener(){

        }
    }
}