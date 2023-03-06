package com.example.calc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.calc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

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

        binding.buttonZero.setOnClickListener(){
            binding.input.text=calculate.addSymbol('0')
            binding.input.setTextColor(normalColor)
        }

        binding.buttonOne.setOnClickListener(){
            binding.input.text=calculate.addSymbol('1')
            binding.input.setTextColor(normalColor)
        }

        binding.buttonTwo.setOnClickListener(){
            binding.input.text=calculate.addSymbol('2')
            binding.input.setTextColor(normalColor)
        }

        binding.buttonThree.setOnClickListener(){
            binding.input.text=calculate.addSymbol('3')
            binding.input.setTextColor(normalColor)
        }

        binding.buttonFour.setOnClickListener(){
            binding.input.text=calculate.addSymbol('4')
            binding.input.setTextColor(normalColor)
        }

        binding.buttonFive.setOnClickListener(){
            binding.input.text=calculate.addSymbol('5')
            binding.input.setTextColor(normalColor)
        }

        binding.buttonSix.setOnClickListener(){
            binding.input.text=calculate.addSymbol('6')
            binding.input.setTextColor(normalColor)
        }

        binding.buttonSeven.setOnClickListener(){
            binding.input.text=calculate.addSymbol('7')
            binding.input.setTextColor(normalColor)
        }

        binding.buttonEight.setOnClickListener(){
            binding.input.text=calculate.addSymbol('8')
            binding.input.setTextColor(normalColor)
        }

        binding.buttonNine.setOnClickListener(){
            binding.input.text=calculate.addSymbol('9')
            binding.input.setTextColor(normalColor)
        }

        binding.buttonAC.setOnClickListener() {
            if (binding.input.text.isNotEmpty()) {
                binding.input.text = calculate.clear()
            }
        }

        binding.buttonPlus.setOnClickListener() {
            binding.input.setTextColor(normalColor)
            if (binding.input.text.isNotEmpty() && binding.input.text.last()!='.') {
                if (binding.input.text.last() == '+' || binding.input.text.last() == '-' || binding.input.text.last() == '÷' || binding.input.text.last() == '×' || binding.input.text.last() == '%') {
                    binding.input.text =
                        removeLastChar(binding.input.text.toString())
                }
                binding.input.text=calculate.addSymbol('+')
                if (binding.input.text=="Error"){
                    binding.input.setTextColor(errorColor)
                }
            }
        }

        binding.buttonMinus.setOnClickListener() {
            binding.input.setTextColor(normalColor)
            if (binding.input.text.isNotEmpty() && binding.input.text.last()!='.') {
                if (binding.input.text.last() == '+' || binding.input.text.last() == '-' || binding.input.text.last() == '÷' || binding.input.text.last() == '×' || binding.input.text.last() == '%') {
                    binding.input.text =
                        removeLastChar(binding.input.text.toString())
                }
                binding.input.text=calculate.addSymbol('-')
                if (binding.input.text=="Error"){
                    binding.input.setTextColor(errorColor)
                }
            }
        }

        binding.buttonMultiplication.setOnClickListener() {
            binding.input.setTextColor(normalColor)
            if (binding.input.text.isNotEmpty() && binding.input.text.last()!='.') {
                if (binding.input.text.last() == '+' || binding.input.text.last() == '-' || binding.input.text.last() == '÷' || binding.input.text.last() == '×' || binding.input.text.last() == '%') {
                    binding.input.text =
                        removeLastChar(binding.input.text.toString())
                }
                binding.input.text=calculate.addSymbol('×')
                if (binding.input.text=="Error"){
                    binding.input.setTextColor(errorColor)
                }
            }
        }

        binding.buttonDivide.setOnClickListener() {
            binding.input.setTextColor(normalColor)
            if (binding.input.text.isNotEmpty() && binding.input.text.last()!='.') {
                if (binding.input.text.last() == '+' || binding.input.text.last() == '-' || binding.input.text.last() == '÷' || binding.input.text.last() == '×' || binding.input.text.last() == '%') {
                    binding.input.text =
                        removeLastChar(binding.input.text.toString())
                }
                binding.input.text=calculate.addSymbol('÷')
                if (binding.input.text=="Error"){
                    binding.input.setTextColor(errorColor)
                }
            }
        }

        binding.buttonPercent.setOnClickListener() {
            binding.input.setTextColor(normalColor)
            if (binding.input.text.isNotEmpty() && binding.input.text.last()!='.') {
                if (binding.input.text.last() == '+' || binding.input.text.last() == '-' || binding.input.text.last() == '÷' || binding.input.text.last() == '×' || binding.input.text.last() == '%') {
                    binding.input.text =
                        removeLastChar(binding.input.text.toString())
                }
                binding.input.text=calculate.addSymbol('%')
                if (binding.input.text=="Error"){
                    binding.input.setTextColor(errorColor)
                }
            }
        }

        binding.buttonComma.setOnClickListener() {
            binding.input.setTextColor(normalColor)
            if (binding.input.text.isNotEmpty() && binding.input.text.last()!='.') {
                binding.input.text=calculate.addSymbol(',')
                if (binding.input.text=="Error"){
                    binding.input.setTextColor(errorColor)
                }
            }
        }

        binding.buttonPlusMinus.setOnClickListener() {
            if (binding.input.text.isNotEmpty()) {
                binding.input.setTextColor(normalColor)
                binding.input.text=calculate.changeSign()
                if (binding.input.text=="Error"){
                    binding.input.setTextColor(errorColor)
                }
            }
        }

        binding.backspace.setOnClickListener(){
            binding.input.setTextColor(normalColor)
            if (binding.input.text.isNotEmpty()) {
                binding.input.text =
                    calculate.removeLastChar()
            }
        }

        binding.buttonEqual.setOnClickListener(){
            try{
                if (binding.input.text.last()!='.') {
                    binding.input.text = calculate.equal()
                }
                if (binding.input.text=="Error"){
                    binding.input.setTextColor(errorColor)
                }
            } catch (e:java.lang.Exception){
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }
    }
}