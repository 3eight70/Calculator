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
        DIVIDE('%'),
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

        val view = binding.root
        setContentView(view)

        val numberButtons = listOf(binding.buttonZero, binding.buttonOne, binding.buttonTwo,binding.buttonThree,binding.buttonFour,binding.buttonFive,binding.buttonSix,binding.buttonSeven,binding.buttonEight, binding.buttonNine)
        numberButtons.forEachIndexed { index, button ->
            button.setOnClickListener() {
                binding.input.text=calculate.addSymbol(index.toString().toCharArray()[0])
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
                        if (binding.input.text == "Error") {
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