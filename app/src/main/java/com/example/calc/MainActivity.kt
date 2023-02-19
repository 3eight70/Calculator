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

        binding.allButtons.buttonZero.setOnClickListener(){
            binding.allButtons.input.append("0")
        }

        binding.allButtons.buttonOne.setOnClickListener(){
            binding.allButtons.input.append("1")
        }

        binding.allButtons.buttonTwo.setOnClickListener(){
            binding.allButtons.input.append("2")
        }

        binding.allButtons.buttonThree.setOnClickListener(){
            binding.allButtons.input.append("3")
        }

        binding.allButtons.buttonFour.setOnClickListener(){
            binding.allButtons.input.append("4")
        }

        binding.allButtons.buttonFive.setOnClickListener(){
            binding.allButtons.input.append("5")
        }

        binding.allButtons.buttonSix.setOnClickListener(){
            binding.allButtons.input.append("6")
        }

        binding.allButtons.buttonSeven.setOnClickListener(){
            binding.allButtons.input.append("7")
        }

        binding.allButtons.buttonEight.setOnClickListener(){
            binding.allButtons.input.append("8")
        }

        binding.allButtons.buttonNine.setOnClickListener(){
            binding.allButtons.input.append("9")
        }

        binding.allButtons.buttonAC.setOnClickListener(){
            binding.allButtons.input.text=""
        }

        binding.allButtons.buttonPlus.setOnClickListener(){
            binding.allButtons.input.append("+")
        }

        binding.allButtons.buttonMinus.setOnClickListener(){
            binding.allButtons.input.append("-")
        }

        binding.allButtons.buttonMultiplication.setOnClickListener(){
            binding.allButtons.input.append("×")
        }

        binding.allButtons.buttonDivide.setOnClickListener(){
            binding.allButtons.input.append("÷")
        }

        binding.allButtons.buttonPercent.setOnClickListener(){
            binding.allButtons.input.append("%")
        }

        binding.allButtons.buttonComma.setOnClickListener(){
            binding.allButtons.input.append(",")
        }

        binding.allButtons.buttonPlusMinus.setOnClickListener(){
            binding.allButtons.input.append("±")
        }

        binding.allButtons.backspace.setOnClickListener(){
            binding.allButtons.input.text?.replaceFirst(".$".toRegex(),"")
        }
    }
}