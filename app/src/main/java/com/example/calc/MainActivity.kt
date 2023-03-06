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

    enum class Action(val symbol: Char) {
        ZERO('0'),
        ONE('1'),
        TWO('2'),
        THREE('3'),
        FOUR('4'),
        FIVE('5'),
        SIX('6'),
        SEVEN('7'),
        EIGHT('8'),
        NINE('9'),
        PLUS('+'),
        MINUS('-'),
        MULTIPLICATION('×'),
        DIVIDE('÷'),
        PERCENT('%'),
        COMMA(','),
        AC('~'),
        PLUSMINUS('±'),
        BACKSPACE('B'),
        EQUAL('=')
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var calculate=Calculate()
        var binding=ActivityMainBinding.inflate(layoutInflater)
        val normalColor= ContextCompat.getColor(this, R.color.input)
        val errorColor=ContextCompat.getColor(this, R.color.inputError)
        val error="Error"

        val view = binding.root
        setContentView(view)

        val numberButtons = mapOf(binding.buttonZero to Action.ZERO.symbol, binding.buttonOne to Action.ONE.symbol, binding.buttonTwo to Action.TWO.symbol,binding.buttonThree to Action.THREE.symbol,binding.buttonFour to Action.FOUR.symbol,binding.buttonFive to Action.FIVE.symbol,binding.buttonSix to Action.SIX.symbol,binding.buttonSeven to Action.SEVEN.symbol,binding.buttonEight to Action.EIGHT.symbol, binding.buttonNine to Action.NINE.symbol)
        numberButtons.forEach { (button, number) ->
            button.setOnClickListener() {
                binding.input.text=calculate.addSymbol(number)
                binding.input.setTextColor(normalColor)
            }
        }

        val operationButtons=mapOf(binding.buttonPlus to Action.PLUS.symbol,binding.buttonMinus to Action.MINUS.symbol,binding.buttonDivide to Action.DIVIDE.symbol,binding.buttonMultiplication to Action.MULTIPLICATION.symbol, binding.buttonPercent to Action.PERCENT.symbol, binding.buttonComma to Action.COMMA.symbol, binding.buttonEqual to Action.EQUAL.symbol)
        operationButtons.forEach { (button, operation) ->
            button.setOnClickListener(){
                binding.input.setTextColor(normalColor)
                try {
                    if (binding.input.text.isNotEmpty() && binding.input.text.last() != '.') {
                        binding.input.text = calculate.addSymbol(operation)
                        if (binding.input.text == error) {
                            binding.input.setTextColor(errorColor)
                        }
                    }
                } catch (e:java.lang.Exception) {
                    Log.d("Ошибка", "сообщение: ${e.message}")
                }
            }
        }

        val anotherOperationButtons=mapOf(binding.buttonAC to Action.AC.symbol, binding.buttonPlusMinus to Action.PLUSMINUS.symbol, binding.backspace to Action.BACKSPACE.symbol)
        anotherOperationButtons.forEach { (button, operation) ->
            button.setOnClickListener() {
                if (binding.input.text.isNotEmpty()) {
                    binding.input.text = calculate.addSymbol(operation)
                }
            }
        }
    }
}