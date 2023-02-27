package com.example.calc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.calc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    fun removeLastChar(str: String?): String? {
        return str?.replaceFirst(".$".toRegex(), "")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var calculate=Calculate()
        var binding=ActivityMainBinding.inflate(layoutInflater)
        val normalColor= ContextCompat.getColor(this, R.color.input)
        val errorColor=ContextCompat.getColor(this, R.color.inputError)

        val view = binding.root
        setContentView(view)

        binding.allButtons.buttonZero.setOnClickListener(){
            binding.allButtons.input.text=calculate.addSymbol('0')
            binding.allButtons.input.setTextColor(normalColor)
        }

        binding.allButtons.buttonOne.setOnClickListener(){
            binding.allButtons.input.text=calculate.addSymbol('1')
            binding.allButtons.input.setTextColor(normalColor)
        }

        binding.allButtons.buttonTwo.setOnClickListener(){
            binding.allButtons.input.text=calculate.addSymbol('2')
            binding.allButtons.input.setTextColor(normalColor)
        }

        binding.allButtons.buttonThree.setOnClickListener(){
            binding.allButtons.input.text=calculate.addSymbol('3')
            binding.allButtons.input.setTextColor(normalColor)
        }

        binding.allButtons.buttonFour.setOnClickListener(){
            binding.allButtons.input.text=calculate.addSymbol('4')
            binding.allButtons.input.setTextColor(normalColor)
        }

        binding.allButtons.buttonFive.setOnClickListener(){
            binding.allButtons.input.text=calculate.addSymbol('5')
            binding.allButtons.input.setTextColor(normalColor)
        }

        binding.allButtons.buttonSix.setOnClickListener(){
            binding.allButtons.input.text=calculate.addSymbol('6')
            binding.allButtons.input.setTextColor(normalColor)
        }

        binding.allButtons.buttonSeven.setOnClickListener(){
            binding.allButtons.input.text=calculate.addSymbol('7')
            binding.allButtons.input.setTextColor(normalColor)
        }

        binding.allButtons.buttonEight.setOnClickListener(){
            binding.allButtons.input.text=calculate.addSymbol('8')
            binding.allButtons.input.setTextColor(normalColor)
        }

        binding.allButtons.buttonNine.setOnClickListener(){
            binding.allButtons.input.text=calculate.addSymbol('9')
            binding.allButtons.input.setTextColor(normalColor)
        }

        binding.allButtons.buttonAC.setOnClickListener() {
            if (binding.allButtons.input.text.isNotEmpty()) {
                binding.allButtons.input.text = calculate.clear()
            }
        }

        binding.allButtons.buttonPlus.setOnClickListener() {
            binding.allButtons.input.setTextColor(normalColor)
            if (binding.allButtons.input.text.isNotEmpty() && binding.allButtons.input.text.last()!='.') {
                if (binding.allButtons.input.text.last() == '+' || binding.allButtons.input.text.last() == '-' || binding.allButtons.input.text.last() == '÷' || binding.allButtons.input.text.last() == '×' || binding.allButtons.input.text.last() == '%') {
                    binding.allButtons.input.text =
                        removeLastChar(binding.allButtons.input.text.toString())
                }
                binding.allButtons.input.text=calculate.addSymbol('+')
                if (binding.allButtons.input.text=="Error"){
                    binding.allButtons.input.setTextColor(errorColor)
                }
            }
        }

        binding.allButtons.buttonMinus.setOnClickListener() {
            binding.allButtons.input.setTextColor(normalColor)
            if (binding.allButtons.input.text.isNotEmpty() && binding.allButtons.input.text.last()!='.') {
                if (binding.allButtons.input.text.last() == '+' || binding.allButtons.input.text.last() == '-' || binding.allButtons.input.text.last() == '÷' || binding.allButtons.input.text.last() == '%' || binding.allButtons.input.text.last() == '×') {
                    binding.allButtons.input.text =
                        removeLastChar(binding.allButtons.input.text.toString())
                }
                binding.allButtons.input.text=calculate.addSymbol('-')
                if (binding.allButtons.input.text=="Error"){
                    binding.allButtons.input.setTextColor(errorColor)
                }
            }
        }

        binding.allButtons.buttonMultiplication.setOnClickListener() {
            binding.allButtons.input.setTextColor(normalColor)
            if (binding.allButtons.input.text.isNotEmpty() && binding.allButtons.input.text.last()!='.') {
                if (binding.allButtons.input.text.last() == '+' || binding.allButtons.input.text.last() == '-' || binding.allButtons.input.text.last() == '÷' || binding.allButtons.input.text.last() == '×' || binding.allButtons.input.text.last() == '%') {
                    binding.allButtons.input.text =
                        removeLastChar(binding.allButtons.input.text.toString())
                }
                binding.allButtons.input.text=calculate.addSymbol('×')
                if (binding.allButtons.input.text=="Error"){
                    binding.allButtons.input.setTextColor(errorColor)
                }
            }
        }

        binding.allButtons.buttonDivide.setOnClickListener() {
            binding.allButtons.input.setTextColor(normalColor)
            if (binding.allButtons.input.text.isNotEmpty() && binding.allButtons.input.text.last()!='.') {
                if (binding.allButtons.input.text.last() == '+' || binding.allButtons.input.text.last() == '-' || binding.allButtons.input.text.last() == '÷' || binding.allButtons.input.text.last() == '×' || binding.allButtons.input.text.last() == '%') {
                    binding.allButtons.input.text =
                        removeLastChar(binding.allButtons.input.text.toString())
                }
                binding.allButtons.input.text=calculate.addSymbol('÷')
                if (binding.allButtons.input.text=="Error"){
                    binding.allButtons.input.setTextColor(errorColor)
                }
            }
        }

        binding.allButtons.buttonPercent.setOnClickListener() {
            binding.allButtons.input.setTextColor(normalColor)
            if (binding.allButtons.input.text.isNotEmpty() && binding.allButtons.input.text.last()!='.') {
                if (binding.allButtons.input.text.last() == '+' || binding.allButtons.input.text.last() == '-' || binding.allButtons.input.text.last() == '÷' || binding.allButtons.input.text.last() == '×' || binding.allButtons.input.text.last() == '%') {
                    binding.allButtons.input.text =
                        removeLastChar(binding.allButtons.input.text.toString())
                }
                binding.allButtons.input.text=calculate.addSymbol('%')
                if (binding.allButtons.input.text=="Error"){
                    binding.allButtons.input.setTextColor(errorColor)
                }
            }
        }

        binding.allButtons.buttonComma.setOnClickListener() {
            binding.allButtons.input.setTextColor(normalColor)
            if (binding.allButtons.input.text.isNotEmpty() && binding.allButtons.input.text.last()!='.') {
                binding.allButtons.input.text=calculate.addSymbol(',')
                if (binding.allButtons.input.text=="Error"){
                    binding.allButtons.input.setTextColor(errorColor)
                }
            }
        }

        binding.allButtons.buttonPlusMinus.setOnClickListener() {
            if (binding.allButtons.input.text.isNotEmpty()) {
                binding.allButtons.input.setTextColor(normalColor)
                binding.allButtons.input.text=calculate.changeSign()
                if (binding.allButtons.input.text=="Error"){
                    binding.allButtons.input.setTextColor(errorColor)
                }
            }
        }

        binding.allButtons.backspace.setOnClickListener(){
            binding.allButtons.input.setTextColor(normalColor)
            if (binding.allButtons.input.text.isNotEmpty()) {
                binding.allButtons.input.text =
                    calculate.removeLastChar()
            }
        }

        binding.allButtons.buttonEqual.setOnClickListener(){
            try{
                if (binding.allButtons.input.text.last()!='.') {
                    binding.allButtons.input.text = calculate.equal()
                }
                if (binding.allButtons.input.text=="Error"){
                    binding.allButtons.input.setTextColor(errorColor)
                }
            } catch (e:java.lang.Exception){
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }
    }
}